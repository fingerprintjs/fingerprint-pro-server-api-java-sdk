package com.fingerprint.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fingerprint.model.*;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.ApiResponse;
import com.fingerprint.sdk.Pair;
import jakarta.ws.rs.core.GenericType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

/**
 * API tests for FingerprintApi
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FingerprintApiTest {
    private FingerprintApi api;
    private static final String MOCK_REQUEST_ID = "0KSh65EnVoB85JBmloQK";
    private static final String MOCK_VISITOR_ID = "AcxioeQKffpXF8iGQK3P";
    private static final String MOCK_WEBHOOK_VISITOR_ID = "Ibk1527CUFmcnjLwIs4A9";
    private static final String MOCK_WEBHOOK_EVENT_ID = "1708102555327.NLOjmg";

    private static final ObjectMapper MAPPER = getMapper();

    private InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private void validateIntegrationInfo(List<Pair> queryParams) {
        List<String> iiValues = queryParams.stream()
                .filter(pair -> "ii".equals(pair.getName()))
                .map(Pair::getValue)
                .collect(Collectors.toList());
        assertEquals(1, iiValues.size());
        assertEquals(FingerprintApi.INTEGRATION_INFO, iiValues.get(0));
    }

    @BeforeAll
    public void before() {
        ApiClient realApiClient = new ApiClient();
        ApiClient apiClient = Mockito.spy(realApiClient);
//        apiClient.setBearerToken("MOCK_API_KEY");
        api = new FingerprintApi(apiClient);
    }

    private static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @FunctionalInterface
    public interface ApiAnswerFunction<T> {
        ApiResponse<T> apply(InvocationOnMock invocation) throws ApiException, IOException;
    }

    private <T> void addMock(String operation, String path, ApiAnswerFunction<T> answerFunction) throws ApiException {
        ApiClient apiClient = api.getApiClient();
        String operationName = "FingerprintApi." + operation;
        String httpMethod;
        switch (operation) {
            case "getEvent":
                path = "/events/" + path;
                httpMethod = "GET";
                break;
            case "updateEvent":
                path = "/events/" + path;
                httpMethod = "PATCH";
                break;
            case "deleteVisitorData":
                path = "/visitors/" + path;
                httpMethod = "DELETE";
                break;
            case "searchEvents":
                path = "/events";
                httpMethod = "GET";
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
        Mockito.doAnswer(invocation -> {
            validateIntegrationInfo(invocation.getArgument(3));
            ApiResponse result = answerFunction.apply(invocation);
            if (result.getStatusCode() == 200) {
                return result;
            } else {
                throw new ApiException(result.getStatusCode(), result.getHeaders(), result.getData().toString());
            }
        }).when(apiClient).invokeAPI(
                eq(operationName),   // operation, for example "FingerprintApi.getEvent"
                eq(path),            // path
                eq(httpMethod),      // HTTP-method
                any(),               // queryParams
                argThat(body -> {
                    if (httpMethod.equals("PATCH")) {
                        return body != null;
                    } else {
                        return body == null;
                    }
                }),
                any(),               // headerParams
                any(),               // cookieParams
                any(),               // formParams
                any(),               // accept
                any(),               // contentType
                any(),               // authNames
                any(),               // returnType
                eq(false)      // isBodyNullable
        );
    }

    ApiResponse mockFileToResponse(int statusCode, InvocationOnMock invocation, String path) throws IOException {
        GenericType returnType = invocation.getArgument(11);
        if (statusCode == 200) {
            return new ApiResponse<>(statusCode, null, path != null ? MAPPER.readValue(getFileAsIOStream(path), returnType.getRawType()) : null);
        } else {
            return new ApiResponse<>(statusCode, null, new String(getFileAsIOStream(path).readAllBytes(), StandardCharsets.UTF_8));
        }
    }

    public static boolean listContainsPair(List<Pair> pairs, String key, String value) {
        if (pairs == null) {
            return false;
        }
        for (Pair pair : pairs) {
            if (key.equals(pair.getName()) && value.equals(pair.getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get event by requestId
     * This endpoint allows you to get events with all the information from each activated product (Fingerprint Pro or Bot Detection). Use the requestId as a URL path :request_id parameter. This API method is scoped to a request, i.e. all returned information is by requestId.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getEventTest() throws ApiException {
        addMock("getEvent", MOCK_REQUEST_ID, invocation -> {
            return mockFileToResponse(200, invocation, "mocks/events/get_event_200.json");
        });

        Event response = api.getEvent(MOCK_REQUEST_ID);
        assertNotNull(response);
        assertNotNull(response.getIdentification());
        assertEquals("Ibk1527CUFmcnjLwIs4A9", response.getIdentification().getVisitorId());

        assertFalse(response.getClonedApp());
        assertFalse(response.getEmulator());
        assertFalse(response.getFrida());
        assertFalse(response.getJailbroken());
        assertFalse(response.getIpBlocklist().getEmailSpam());
        assertFalse(response.getIpBlocklist().getTorNode());
        assertTrue(response.getProxy());
        assertEquals(ProxyDetails.ProxyTypeEnum.RESIDENTIAL, response.getProxyDetails().getProxyType());
        assertEquals(1708102555327L, response.getProxyDetails().getLastSeenAt());
        assertFalse(response.getTampering());
        assertFalse(response.getVpn());
        assertFalse(response.getVirtualMachine());
        assertInstanceOf(VelocityData.class, response.getVelocity().getDistinctCountry());
        assertFalse(response.getLocationSpoofing());
        assertEquals(0L, response.getFactoryResetTimestamp());
    }

    @Test
    public void updateEventLinkedIdRequest() throws ApiException {
        final String LINKED_ID = "myLinkedId";
        EventUpdate request = new EventUpdate();
        request.setLinkedId(LINKED_ID);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventUpdate body = invocation.getArgument(4);
            assertEquals(LINKED_ID, body.getLinkedId());
            assertNull(body.getTags());
            assertNull(body.getSuspect());
            return mockFileToResponse(200, invocation, null);
        });
        api.updateEvent(MOCK_REQUEST_ID, request);
    }

    @Test
    public void updateEventTagRequest() throws ApiException {
        final Map<String, Object> TAG = new HashMap<>();
        TAG.put("stringKey", "value");
        TAG.put("booleanPositiveKey", true);
        TAG.put("booleanNegativeKey", false);
        TAG.put("numberKey", 123);
        TAG.put("arrayStringKey", new String[]{"value1", "value2"});
        TAG.put("arrayIntKey", new int[]{1, 2, 7});
        TAG.put("arrayEmptyKey", new int[]{});
        TAG.put("mapKey", new HashMap<String, Object>() {{
            put("key1", "value1");
            put("key2", 2);
        }});
        EventUpdate request = new EventUpdate();
        request.setTags(TAG);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventUpdate body = invocation.getArgument(4);
            assertNull(body.getLinkedId());
            assertEquals(TAG, body.getTags());
            assertNull(body.getSuspect());
            return mockFileToResponse(200, invocation, null);
        });
        api.updateEvent(MOCK_REQUEST_ID, request);
    }

    @Test
    public void updateEventSuspectPositiveRequest() throws ApiException {
        EventUpdate request = new EventUpdate();
        request.setSuspect(true);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventUpdate body = invocation.getArgument(4);
            assertNull(body.getLinkedId());
            assertNull(body.getTags());
            assertTrue(body.getSuspect());
            return mockFileToResponse(200, invocation, null);
        });
        api.updateEvent(MOCK_REQUEST_ID, request);
    }

    @Test
    public void updateEventSuspectNegativeRequest() throws ApiException {
        EventUpdate request = new EventUpdate();
        request.setSuspect(false);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventUpdate body = invocation.getArgument(4);
            assertNull(body.getLinkedId());
            assertNull(body.getTags());
            assertFalse(body.getSuspect());
            return mockFileToResponse(200, invocation, null);
        });
        api.updateEvent(MOCK_REQUEST_ID, request);
    }

    @Test
    public void updateMultipleFieldsEventRequest() throws ApiException {
        final String LINKED_ID = "myLinkedId";
        final Map<String, Object> TAG = new HashMap<>();
        TAG.put("stringKey", "value");
        TAG.put("booleanKey", true);
        TAG.put("numberKey", 123);
        TAG.put("arrayStringKey", new String[]{"value1", "value2"});
        EventUpdate request = new EventUpdate();
        request.setLinkedId(LINKED_ID);
        request.setTags(TAG);
        request.setSuspect(true);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventUpdate body = invocation.getArgument(4);
            assertEquals(LINKED_ID, body.getLinkedId());
            assertEquals(TAG, body.getTags());
            assertTrue(body.getSuspect());
            return mockFileToResponse(200, invocation, null);
        });
        api.updateEvent(MOCK_REQUEST_ID, request);
    }

    @Test
    public void deleteVisitorDataTest() throws ApiException {
        addMock("deleteVisitorData", MOCK_VISITOR_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            return mockFileToResponse(200, invocation, null);
        });
        api.deleteVisitorData(MOCK_VISITOR_ID);
    }

    /**
     * Webhook
     * Check that webhook correctly deserializes the JSON payload to the WebhookVisit object.
     *
     * @throws Exception if the file reading or deserialization fails.
     */
    @Test
    public void webhookTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Event event = mapper.readValue(getFileAsIOStream("mocks/webhook/webhook_event.json"), Event.class);

        assertEquals(MOCK_WEBHOOK_VISITOR_ID, event.getIdentification().getVisitorId());
        assertEquals(MOCK_WEBHOOK_EVENT_ID, event.getEventId());
    }

    @Test
    public void searchEventsMinimumParamsTest() throws ApiException {
        int LIMIT = 1;
        addMock("searchEvents", null, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(2, queryParams.size());
            assertTrue(listContainsPair(queryParams, "limit", String.valueOf(LIMIT)));

            return mockFileToResponse(200, invocation, "mocks/events/search/get_event_search_200.json");
        });

        EventSearch response = api.searchEvents(new FingerprintApi.SearchEventsOptionalParams().setLimit(LIMIT));
        List<Event> events = response.getEvents();

        assertEquals(events.size(), 1);
        Event event = events.get(0);

        assertNotNull(event);
        assertNotNull(event.getIdentification());
        assertEquals("Ibk1527CUFmcnjLwIs4A9", event.getIdentification().getVisitorId());

        assertFalse(event.getClonedApp());
        assertFalse(event.getEmulator());
        assertFalse(event.getFrida());
        assertFalse(event.getJailbroken());
        assertFalse(event.getIpBlocklist().getAttackSource());
        assertFalse(event.getIpBlocklist().getTorNode());
        assertTrue(event.getProxy());
        assertFalse(event.getTampering());
        assertFalse(event.getVpn());
        assertFalse(event.getVirtualMachine());
        assertInstanceOf(VelocityData.class, event.getVelocity().getDistinctVisitorIdByLinkedId());
        assertFalse(event.getLocationSpoofing());
        assertEquals(0L, event.getFactoryResetTimestamp());
    }

    @Test
    public void searchEventsMaximumParamsTest() throws ApiException {
        final int LIMIT = 1;
        final String PAGINATION_KEY = "1741187431959";
        final String BOT = "good";
        final String IP_ADDRESS = "192.168.0.1/32";
        final String LINKED_ID = "some_id";
        final Long START = 1582299576511L;
        final Long END = 1582299576513L;
        final Boolean REVERSE = true;
        final Boolean SUSPECT = false;
        final Boolean ANTI_DETECT_BROWSER = true;
        final Boolean CLONED_APP = true;
        final Boolean FACTORY_RESET = true;
        final Boolean FRIDA = true;
        final Boolean JAILBROKEN = true;
        final Float MIN_SUSPECT_SCORE = 0.5f;
        final Boolean PRIVACY_SETTINGS = true;
        final Boolean ROOT_APPS = true;
        final Boolean TAMPERING = true;
        final Boolean VIRTUAL_MACHINE = true;
        final Boolean VPN = true;
        final String VPN_CONFIDENCE = "medium";
        final Boolean EMULATOR = true;
        final Boolean INCOGNITO = true;
        final Boolean IP_BLOCKLIST = true;
        final Boolean DATACENTER = true;
        final Boolean DEVELOPER_TOOLS = true;
        final Boolean LOCATION_SPOOFING = true;
        final Boolean MITM_ATTACK = true;
        final Boolean PROXY = true;
        final String SDK_VERSION = "testSdkVersion";
        final String SDK_PLATFORM = "testSdkPlatform";
        final List<String> ENVIRONMENT = new ArrayList<String>();
        ENVIRONMENT.add("env1");
        ENVIRONMENT.add("env2");
        final String PROXIMITY_ID = "testProximityId";
        final Integer PROXIMITY_PRECISION_RADIUS = 10;

        Map<String, String> expectedQueryParams = new HashMap<>();
        expectedQueryParams.put("limit", String.valueOf(LIMIT));
        expectedQueryParams.put("pagination_key", PAGINATION_KEY);
        expectedQueryParams.put("visitor_id", MOCK_VISITOR_ID);
        expectedQueryParams.put("bot", BOT);
        expectedQueryParams.put("ip_address", IP_ADDRESS);
        expectedQueryParams.put("linked_id", LINKED_ID);
        expectedQueryParams.put("start", START.toString());
        expectedQueryParams.put("end", END.toString());
        expectedQueryParams.put("reverse", String.valueOf(REVERSE));
        expectedQueryParams.put("suspect", String.valueOf(SUSPECT));
        expectedQueryParams.put("anti_detect_browser", String.valueOf(ANTI_DETECT_BROWSER));
        expectedQueryParams.put("cloned_app", String.valueOf(CLONED_APP));
        expectedQueryParams.put("factory_reset", String.valueOf(FACTORY_RESET));
        expectedQueryParams.put("frida", String.valueOf(FRIDA));
        expectedQueryParams.put("jailbroken", String.valueOf(JAILBROKEN));
        expectedQueryParams.put("min_suspect_score", MIN_SUSPECT_SCORE.toString());
        expectedQueryParams.put("privacy_settings", String.valueOf(PRIVACY_SETTINGS));
        expectedQueryParams.put("root_apps", String.valueOf(ROOT_APPS));
        expectedQueryParams.put("tampering", String.valueOf(TAMPERING));
        expectedQueryParams.put("virtual_machine", String.valueOf(VIRTUAL_MACHINE));
        expectedQueryParams.put("vpn", String.valueOf(VPN));
        expectedQueryParams.put("vpn_confidence", VPN_CONFIDENCE);
        expectedQueryParams.put("emulator", String.valueOf(EMULATOR));
        expectedQueryParams.put("incognito", String.valueOf(INCOGNITO));
//        expectedQueryParams.put("ip_blocklist", String.valueOf(IP_BLOCKLIST));
//        expectedQueryParams.put("datacenter", String.valueOf(DATACENTER));
        expectedQueryParams.put("developer_tools", String.valueOf(DEVELOPER_TOOLS));
        expectedQueryParams.put("location_spoofing", String.valueOf(LOCATION_SPOOFING));
        expectedQueryParams.put("mitm_attack", String.valueOf(MITM_ATTACK));
        expectedQueryParams.put("proxy", String.valueOf(PROXY));
        expectedQueryParams.put("sdk_version", SDK_VERSION);
        expectedQueryParams.put("sdk_platform", SDK_PLATFORM);
//        expectedQueryParams.put("proximity_id", PROXIMITY_ID);
//        expectedQueryParams.put("proximity_precision_radius", String.valueOf(PROXIMITY_PRECISION_RADIUS));

        addMock("searchEvents", null, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            // base expected + 1 for "ii" + N for each environment entry
            assertEquals(expectedQueryParams.size() + 1 + ENVIRONMENT.size(), queryParams.size());
            for (Map.Entry<String, String> expected : expectedQueryParams.entrySet()) {
                assertTrue(listContainsPair(queryParams, expected.getKey(), expected.getValue()));
            }

            List<String> actualEnv = queryParams.stream()
                    .filter(p -> "environment".equals(p.getName()) || "environment[]".equals(p.getName()))
                    .map(Pair::getValue)
                    // if your Pair values might be percent-encoded, decode them
                    .map(v -> URLDecoder.decode(v, StandardCharsets.UTF_8))
                    .collect(Collectors.toList());

            assertEquals(ENVIRONMENT, actualEnv);

            return mockFileToResponse(200, invocation, "mocks/events/search/get_event_search_200.json");
        });

        EventSearch response = api.searchEvents(new FingerprintApi.SearchEventsOptionalParams()
                .setLimit(LIMIT)
                .setPaginationKey(PAGINATION_KEY)
                .setVisitorId(MOCK_VISITOR_ID)
                .setBot(BOT).setIpAddress(IP_ADDRESS)
                .setLinkedId(LINKED_ID).setStart(START)
                .setEnd(END).setReverse(REVERSE)
                .setSuspect(SUSPECT)
                .setAntiDetectBrowser(ANTI_DETECT_BROWSER)
                .setClonedApp(CLONED_APP)
                .setFactoryReset(FACTORY_RESET)
                .setFrida(FRIDA)
                .setJailbroken(JAILBROKEN)
                .setMinSuspectScore(MIN_SUSPECT_SCORE)
                .setPrivacySettings(PRIVACY_SETTINGS)
                .setRootApps(ROOT_APPS)
                .setTampering(TAMPERING)
                .setVirtualMachine(VIRTUAL_MACHINE)
                .setVpn(VPN)
                .setVpnConfidence(VPN_CONFIDENCE)
                .setEmulator(EMULATOR)
                .setIncognito(INCOGNITO)
//                .setIpBlocklist(IP_BLOCKLIST)
//                .setDatacenter(DATACENTER)
                .setDeveloperTools(DEVELOPER_TOOLS)
                .setLocationSpoofing(LOCATION_SPOOFING)
                .setMitmAttack(MITM_ATTACK)
                .setProxy(PROXY)
                .setSdkVersion(SDK_VERSION)
                .setSdkPlatform(SDK_PLATFORM)
                .setEnvironment(ENVIRONMENT)
//                .setProximityId(PROXIMITY_ID)
//                .setProximityPrecisionRadius(PROXIMITY_PRECISION_RADIUS)
        );
        List<Event> events = response.getEvents();
        assertEquals(events.size(), 1);
    }

    @Test
    public void searchEvents400ErrorTest() throws ApiException, JsonProcessingException {
        int LIMIT = 1;
        addMock("searchEvents", null, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            return mockFileToResponse(400, invocation, "mocks/errors/400_ip_address_invalid.json");
        });

        ApiException exception = assertThrows(ApiException.class,
                () -> api.searchEvents(null));

        assertEquals(400, exception.getCode());
        ErrorResponse response = MAPPER.readValue(exception.getResponseBody(), ErrorResponse.class);
        assertEquals(ErrorCode.REQUEST_CANNOT_BE_PARSED, response.getError().getCode());
        assertEquals("invalid ip address", response.getError().getMessage());
    }

    @Test
    public void searchEvents403ErrorTest() throws ApiException, JsonProcessingException {
        int LIMIT = 1;
        addMock("searchEvents", null, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            return mockFileToResponse(403, invocation, "mocks/errors/403_feature_not_enabled.json");
        });

        ApiException exception = assertThrows(ApiException.class,
                () -> api.searchEvents(null));

        assertEquals(403, exception.getCode());
        ErrorResponse response = MAPPER.readValue(exception.getResponseBody(), ErrorResponse.class);
        assertEquals(ErrorCode.FEATURE_NOT_ENABLED, response.getError().getCode());
        assertEquals("feature not enabled", response.getError().getMessage());
    }
}
