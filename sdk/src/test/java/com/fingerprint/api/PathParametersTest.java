package com.fingerprint.api;

import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.ApiResponse;
import com.fingerprint.sdk.InvalidArgumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;

/**
 * Tests for the values every operation accepts as a URL path parameter.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PathParametersTest {

    @FunctionalInterface
    private interface Call {
        void apply(FingerprintApi api, String id) throws ApiException;
    }

    /**
     * An operation that takes an ID as a URL path parameter, so that every such operation can be
     * checked against the same set of values.
     */
    private static class Endpoint {
        final String name;
        final String prefix;
        final String paramName;
        final Call call;

        Endpoint(String name, String prefix, String paramName, Call call) {
            this.name = name;
            this.prefix = prefix;
            this.paramName = paramName;
            this.call = call;
        }
    }

    private static final List<Endpoint> ENDPOINTS = Arrays.asList(
            new Endpoint("getEvent", "/events/", "requestId",
                    (api, id) -> api.getEvent(id)),
            new Endpoint("updateEvent", "/events/", "requestId",
                    (api, id) -> api.updateEvent(id, new EventsUpdateRequest().linkedId("linked_id"))),
            new Endpoint("getVisits", "/visitors/", "visitorId",
                    (api, id) -> api.getVisits(id, null, null, null, null, null)),
            new Endpoint("deleteVisitorData", "/visitors/", "visitorId",
                    (api, id) -> api.deleteVisitorData(id))
    );

    /**
     * The paths a call handed to {@link ApiClient#invokeAPI}. Empty when no request was made.
     */
    private final List<String> requestedPaths = new ArrayList<>();

    private FingerprintApi apiCapturingPaths() throws ApiException {
        ApiClient apiClient = Mockito.spy(new ApiClient());

        requestedPaths.clear();
        Mockito.doAnswer(invocation -> {
            requestedPaths.add(invocation.getArgument(1));
            return new ApiResponse<>(200, null, null);
        }).when(apiClient).invokeAPI(
                any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), anyBoolean()
        );

        return new FingerprintApi(apiClient);
    }

    private static String urlDecode(String value) {
        try {
            return URLDecoder.decode(value, "utf8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * A malformed path parameter is percent-encoded into a single opaque path segment rather than
     * being interpreted as part of the path structure.
     */
    @Test
    public void pathParamIsEncodedAsSingleOpaqueSegment() throws ApiException {
        String[][] cases = {
                // value, expected encoding
                {"../events", "..%2Fevents"},
                {"../../events", "..%2F..%2Fevents"},
                {"/events/123", "%2Fevents%2F123"},
                {"https://domain.tld/evil", "https%3A%2F%2Fdomain.tld%2Fevil"},
                {"123?limit=1", "123%3Flimit%3D1"},
                {"123#fragment", "123%23fragment"},
                {"hello world", "hello%20world"},
                {"", ""},
        };

        for (Endpoint endpoint : ENDPOINTS) {
            for (String[] testCase : cases) {
                String value = testCase[0];
                String encoded = testCase[1];
                String context = endpoint.name + ": " + value;

                FingerprintApi api = apiCapturingPaths();
                endpoint.call.apply(api, value);

                assertEquals(1, requestedPaths.size(), context);
                assertEquals(endpoint.prefix + encoded, requestedPaths.get(0), context);

                // Decoding the path yields exactly the ID that was passed in, so the encoding never
                // changes which resource is addressed.
                assertEquals(endpoint.prefix + value, urlDecode(requestedPaths.get(0)), context);
            }
        }
    }

    /**
     * A path parameter of exactly "." or ".." is an RFC 3986 dot-segment. Such a value does not
     * address a resource, so the SDK rejects it up front instead of sending a request that URL
     * normalizers would resolve to a different endpoint.
     */
    @Test
    public void invalidPathParamThrowsWithoutSendingRequest() throws ApiException {
        for (Endpoint endpoint : ENDPOINTS) {
            for (String value : new String[]{".", ".."}) {
                String context = endpoint.name + ": " + value;

                FingerprintApi api = apiCapturingPaths();
                InvalidArgumentException exception = assertThrows(
                        InvalidArgumentException.class,
                        () -> endpoint.call.apply(api, value),
                        context
                );

                assertTrue(requestedPaths.isEmpty(), context);

                assertEquals(InvalidArgumentException.ERROR_CODE, exception.getErrorCode(), context);
                assertEquals(endpoint.paramName, exception.getParameter(), context);
                assertEquals(value, exception.getValue(), context);

                // The message names both the offending parameter and its value.
                assertTrue(exception.getMessage().contains(endpoint.paramName), context);
                assertTrue(exception.getMessage().contains(value), context);
            }
        }
    }

    /**
     * Catching {@link ApiException} keeps catching every failure these operations report, so the
     * new exception does not escape existing error handling.
     */
    @Test
    public void invalidPathParamIsAnApiException() throws ApiException {
        FingerprintApi api = apiCapturingPaths();

        ApiException exception = assertThrows(ApiException.class, () -> api.getEvent(".."));

        assertTrue(exception instanceof InvalidArgumentException);
        assertEquals(400, exception.getCode());
    }

    /**
     * The encoding does not mangle the IDs issued by Fingerprint. Only a segment made up of exactly
     * one or two dots is rejected; anything else containing a dot passes through unencoded, since
     * "." is otherwise an unreserved character.
     */
    @Test
    public void pathParamLeavesValidIdsUntouched() throws ApiException {
        String[] values = {
                "1708102555327.NLOjmg",
                "Ibk1527CUFmcnjLwIs4A9",
                "0KSh65EnVoB85JBmloQK",
                "...",
                "..a",
                "a..",
                "-_.",
        };

        for (Endpoint endpoint : ENDPOINTS) {
            for (String value : values) {
                String context = endpoint.name + ": " + value;

                FingerprintApi api = apiCapturingPaths();
                endpoint.call.apply(api, value);

                assertEquals(1, requestedPaths.size(), context);
                assertEquals(endpoint.prefix + value, requestedPaths.get(0), context);
            }
        }
    }

    /**
     * The encoded path reaches the wire untouched: nothing between {@link ApiClient#invokeAPI} and
     * the socket decodes or normalizes it back into several path segments.
     */
    @Test
    public void encodedPathIsSentAsIs() throws Exception {
        String[][] cases = {
                // value, expected request target
                {"../events", "/events/..%2Fevents"},
                {"/events/123", "/events/%2Fevents%2F123"},
                {"123?limit=1", "/events/123%3Flimit%3D1"},
                {"hello world", "/events/hello%20world"},
                {"1708102555327.NLOjmg", "/events/1708102555327.NLOjmg"},
        };

        for (String[] testCase : cases) {
            String value = testCase[0];
            String expectedTarget = testCase[1];

            try (SingleRequestServer server = new SingleRequestServer()) {
                ApiClient apiClient = new ApiClient().setBasePath(server.baseUrl());
                new FingerprintApi(apiClient).getEvent(value);

                // The request target as it was literally written to the socket, before any parsing.
                String target = server.awaitRequestTarget();
                assertEquals(expectedTarget, target.split("\\?", 2)[0], value);
            }
        }
    }

    /**
     * A local server that answers exactly one request with an empty JSON body and records the
     * request target it was asked for.
     */
    private static class SingleRequestServer implements Closeable {
        private final ServerSocket socket;
        private final CompletableFuture<String> requestTarget = new CompletableFuture<>();

        SingleRequestServer() throws IOException {
            socket = new ServerSocket(0, 1, InetAddress.getLoopbackAddress());

            Thread thread = new Thread(() -> {
                try (Socket connection = socket.accept()) {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

                    String requestLine = in.readLine();
                    requestTarget.complete(requestLine == null ? "" : requestLine.split(" ")[1]);

                    String line;
                    while ((line = in.readLine()) != null && !line.isEmpty()) {
                        // Skip the headers; none of these requests carry a body.
                    }

                    connection.getOutputStream().write((
                            "HTTP/1.1 200 OK\r\n"
                                    + "Content-Type: application/json\r\n"
                                    + "Content-Length: 2\r\n"
                                    + "\r\n"
                                    + "{}").getBytes(StandardCharsets.UTF_8));
                    connection.getOutputStream().flush();
                } catch (IOException e) {
                    requestTarget.completeExceptionally(e);
                }
            });
            thread.setDaemon(true);
            thread.start();
        }

        String baseUrl() {
            String host = socket.getInetAddress().getHostAddress();
            if (socket.getInetAddress() instanceof java.net.Inet6Address) {
                host = "[" + host + "]";
            }
            return "http://" + host + ":" + socket.getLocalPort();
        }

        String awaitRequestTarget() throws Exception {
            return requestTarget.get(10, TimeUnit.SECONDS);
        }

        @Override
        public void close() throws IOException {
            socket.close();
        }
    }

    /**
     * Operations without a path parameter are untouched by the check, including the one that takes
     * a visitor ID as a query parameter.
     */
    @Test
    public void operationsWithoutPathParamsAcceptDotSegments() throws ApiException {
        FingerprintApi api = apiCapturingPaths();

        api.getRelatedVisitors("..");
        api.searchEvents(1, new FingerprintApi.SearchEventsOptionalParams().setVisitorId(".."));

        assertEquals(Arrays.asList("/related-visitors", "/events/search"), requestedPaths);
    }
}
