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
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private static final String MOCK_REQUEST_WITH_EXTRA_FIELDS_ID = "EXTRA_FIELDS";
    private static final String MOCK_REQUEST_WITH_ALL_FAILED_SIGNALS = "ALL_FAILED_SIGNALS";
    private static final String MOCK_REQUEST_BOTD_FAILED = "MOCK_REQUEST_BOTD_FAILED";
    private static final String MOCK_REQUEST_BOTD_MANY_REQUEST = "MOCK_REQUEST_BOTD_MANY_REQUEST";
    private static final String MOCK_REQUEST_IDENTIFICATION_FAILED = "MOCK_REQUEST_IDENTIFICATION_FAILED";
    private static final String MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST = "MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST";
    private static final String MOCK_VISITOR_ID = "AcxioeQKffpXF8iGQK3P";
    private static final String MOCK_VISITOR_REQUEST_ID = "1655373780901.HhjRFX";
    private static final String MOCK_WEBHOOK_VISITOR_ID = "3HNey93AkBW6CRbxV6xP";
    private static final String MOCK_WEBHOOK_REQUEST_ID = "Px6VxbRC6WBkA39yeNH3";

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
                httpMethod = "PUT";
                break;
            case "getVisits":
                path = "/visitors/" + path;
                httpMethod = "GET";
                break;
            case "deleteVisitorData":
                path = "/visitors/" + path;
                httpMethod = "DELETE";
                break;
            case "getRelatedVisitors":
                path = "/related-visitors";
                httpMethod = "GET";
                break;
            case "searchEvents":
                path = "/events/search";
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
                    if (httpMethod.equals("PUT")) {
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
            return mockFileToResponse(200, invocation, "mocks/get_event_200.json");
        });

        EventsGetResponse response = api.getEvent(MOCK_REQUEST_ID);
        assertNotNull(response.getProducts());
        assertNotNull(response.getProducts().getIdentification());
        assertNotNull(response.getProducts().getIdentification().getData());
        assertEquals("Ibk1527CUFmcnjLwIs4A9", response.getProducts().getIdentification().getData().getVisitorId());

        assertFalse(response.getProducts().getClonedApp().getData().getResult());
        assertFalse(response.getProducts().getEmulator().getData().getResult());
        assertFalse(response.getProducts().getFrida().getData().getResult());
        assertFalse(response.getProducts().getJailbroken().getData().getResult());
        assertFalse(response.getProducts().getIpBlocklist().getData().getResult());
        assertFalse(response.getProducts().getProxy().getData().getResult());
        assertFalse(response.getProducts().getTampering().getData().getResult());
        assertFalse(response.getProducts().getTor().getData().getResult());
        assertFalse(response.getProducts().getVpn().getData().getResult());
        assertFalse(response.getProducts().getVirtualMachine().getData().getResult());
        assertFalse(response.getProducts().getHighActivity().getData().getResult());
        assertFalse(response.getProducts().getLocationSpoofing().getData().getResult());
        assertEquals(0, response.getProducts().getFactoryReset().getData().getTimestamp());
        ProductRawDeviceAttributes signalResponseRawDeviceAttributes = response.getProducts().getRawDeviceAttributes();
        assertEquals(127, signalResponseRawDeviceAttributes.getData().get("architecture").getValue());
        assertEquals(35.73832903057337, signalResponseRawDeviceAttributes.getData().get("audio").getValue());
        Map<String, Object> canvasAttribute = (Map<String, Object>) response.getProducts().getRawDeviceAttributes().getData().get("canvas").getValue();
        assertEquals(true, canvasAttribute.get("Winding"));
        assertEquals("4dce9d6017c3e0c052a77252f29f2b1c", canvasAttribute.get("Geometry"));
        assertEquals("p3", signalResponseRawDeviceAttributes.getData().get("colorGamut").getValue());
        assertEquals(true, signalResponseRawDeviceAttributes.getData().get("cookiesEnabled").getValue());
    }

    @Test
    public void updateEventLinkedIdRequest() throws ApiException {
        final String LINKED_ID = "myLinkedId";
        EventsUpdateRequest request = new EventsUpdateRequest();
        request.setLinkedId(LINKED_ID);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventsUpdateRequest body = invocation.getArgument(4);
            assertEquals(LINKED_ID, body.getLinkedId());
            assertNull(body.getTag());
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
        EventsUpdateRequest request = new EventsUpdateRequest();
        request.setTag(TAG);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventsUpdateRequest body = invocation.getArgument(4);
            assertNull(body.getLinkedId());
            assertEquals(TAG, body.getTag());
            assertNull(body.getSuspect());
            return mockFileToResponse(200, invocation, null);
        });
        api.updateEvent(MOCK_REQUEST_ID, request);
    }

    @Test
    public void updateEventSuspectPositiveRequest() throws ApiException {
        EventsUpdateRequest request = new EventsUpdateRequest();
        request.setSuspect(true);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventsUpdateRequest body = invocation.getArgument(4);
            assertNull(body.getLinkedId());
            assertNull(body.getTag());
            assertTrue(body.getSuspect());
            return mockFileToResponse(200, invocation, null);
        });
        api.updateEvent(MOCK_REQUEST_ID, request);
    }

    @Test
    public void updateEventSuspectNegativeRequest() throws ApiException {
        EventsUpdateRequest request = new EventsUpdateRequest();
        request.setSuspect(false);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventsUpdateRequest body = invocation.getArgument(4);
            assertNull(body.getLinkedId());
            assertNull(body.getTag());
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
        EventsUpdateRequest request = new EventsUpdateRequest();
        request.setLinkedId(LINKED_ID);
        request.setTag(TAG);
        request.setSuspect(true);

        addMock("updateEvent", MOCK_REQUEST_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(1, queryParams.size());

            EventsUpdateRequest body = invocation.getArgument(4);
            assertEquals(LINKED_ID, body.getLinkedId());
            assertEquals(TAG, body.getTag());
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
     * Get event by requestId
     * This endpoint allows you to get events with all the information from each activated product (Fingerprint Pro or Bot Detection). Use the requestId as a URL path :request_id parameter. This API method is scoped to a request, i.e. all returned information is by requestId.
     * Answer will contain fields of additional products that don't described in schema
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getEventWithExtraFieldsTest() throws ApiException {
        addMock("getEvent", MOCK_REQUEST_WITH_EXTRA_FIELDS_ID,
                invocation -> mockFileToResponse(200, invocation, "mocks/get_event_200_extra_fields.json")
        );
        EventsGetResponse response = api.getEvent(MOCK_REQUEST_WITH_EXTRA_FIELDS_ID);
        Products products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getData());
        assertEquals("Ibk1527CUFmcnjLwIs4A9", products.getIdentification().getData().getVisitorId());
    }

    @Test
    public void getEventWithAllFailedSignalsTest() throws ApiException {
        addMock("getEvent", MOCK_REQUEST_WITH_ALL_FAILED_SIGNALS,
                invocation -> mockFileToResponse(200, invocation, "mocks/get_event_200_all_errors.json")
        );

        EventsGetResponse response = api.getEvent(MOCK_REQUEST_WITH_ALL_FAILED_SIGNALS);
        Products products = response.getProducts();

        assertNotNull(products);
        assertEquals(ErrorCode.FAILED, products.getIdentification().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getBotd().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getIpInfo().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getIncognito().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getRootApps().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getEmulator().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getIpBlocklist().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getTor().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getVpn().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getProxy().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getTampering().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getClonedApp().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getFactoryReset().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getJailbroken().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getFrida().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getPrivacySettings().getError().getCode());
        assertEquals(ErrorCode.FAILED, products.getVirtualMachine().getError().getCode());

        ProductRawDeviceAttributes signalResponseRawDeviceAttributes = response.getProducts().getRawDeviceAttributes();
        assertEquals("Error", signalResponseRawDeviceAttributes.getData().get("audio").getError().getName());
        assertEquals("internal server error", signalResponseRawDeviceAttributes.getData().get("audio").getError().getMessage());
        assertEquals("Error", signalResponseRawDeviceAttributes.getData().get("canvas").getError().getName());
        assertEquals("internal server error", signalResponseRawDeviceAttributes.getData().get("canvas").getError().getMessage());
    }

    @Test
    public void getEventBotdFailedErrorTest() throws ApiException {
        addMock("getEvent", MOCK_REQUEST_BOTD_FAILED,
                invocation -> mockFileToResponse(200, invocation, "mocks/get_event_200_botd_failed_error.json")
        );

        EventsGetResponse response = api.getEvent(MOCK_REQUEST_BOTD_FAILED);
        Products products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getData());
        assertEquals("Ibk1527CUFmcnjLwIs4A9", products.getIdentification().getData().getVisitorId());

        assertNotNull(products.getBotd());
        assertNotNull(products.getBotd().getError());
        assertEquals(ErrorCode.FAILED, products.getBotd().getError().getCode());
    }

    @Test
    public void getEventBotdManyRequestsErrorTest() throws ApiException {
        addMock("getEvent", MOCK_REQUEST_BOTD_MANY_REQUEST,
                invocation -> mockFileToResponse(200, invocation, "mocks/get_event_200_too_many_requests_error.json")
        );

        EventsGetResponse response = api.getEvent(MOCK_REQUEST_BOTD_MANY_REQUEST);
        Products products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getBotd());
        assertNotNull(products.getBotd().getError());
        assertEquals(ErrorCode.TOO_MANY_REQUESTS, products.getBotd().getError().getCode());
    }

    @Test
    public void getEventIdentificationFailedErrorTest() throws ApiException {
        addMock("getEvent", MOCK_REQUEST_IDENTIFICATION_FAILED,
                invocation -> mockFileToResponse(200, invocation, "mocks/get_event_200_identification_failed_error.json")
        );

        EventsGetResponse response = api.getEvent(MOCK_REQUEST_IDENTIFICATION_FAILED);
        Products products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getError());
        assertEquals(ErrorCode.FAILED, products.getIdentification().getError().getCode());
        assertNotNull(products.getBotd());
        assertNotNull(products.getBotd().getData());
    }

    @Test
    public void getEventIdentificationManyRequestsErrorTest() throws ApiException {
        addMock("getEvent", MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST,
                invocation -> mockFileToResponse(200, invocation, "mocks/get_event_200_too_many_requests_error.json")
        );

        EventsGetResponse response = api.getEvent(MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST);
        Products products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getError());
        assertEquals(ErrorCode._429_TOO_MANY_REQUESTS, products.getIdentification().getError().getCode());
    }

    /**
     * Get visits by visitorId
     * This endpoint allows you to get a history of visits with all available information. Use the visitorId as a URL path parameter. This API method is scoped to a visitor, i.e. all returned information is by visitorId.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getVisitsTest() throws ApiException {
        final String PAGINATION_KEY = "1683900801733.Ogvu1j";
        final int LIMIT = 50;
        addMock("getVisits", MOCK_VISITOR_ID, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);

            assertEquals(4, queryParams.size());
            assertTrue(listContainsPair(queryParams, "request_id", MOCK_VISITOR_REQUEST_ID));
            assertTrue(listContainsPair(queryParams, "limit", String.valueOf(LIMIT)));
            assertTrue(listContainsPair(queryParams, "paginationKey", PAGINATION_KEY));

            return mockFileToResponse(200, invocation, "mocks/get_visitors_200_limit_500.json");
        });
        VisitorsGetResponse response = api.getVisits(MOCK_VISITOR_ID, MOCK_VISITOR_REQUEST_ID, null, LIMIT, PAGINATION_KEY, null);
        assertEquals(response.getVisitorId(), MOCK_VISITOR_ID);
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

        Webhook visit = mapper.readValue(getFileAsIOStream("mocks/webhook.json"), Webhook.class);

        assertEquals(MOCK_WEBHOOK_VISITOR_ID, visit.getVisitorId());
        assertEquals(MOCK_WEBHOOK_REQUEST_ID, visit.getRequestId());
    }

    @Test
    public void relatedVisitorsTest() throws ApiException {
        addMock("getRelatedVisitors", null, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(2, queryParams.size());
            assertTrue(listContainsPair(queryParams, "visitor_id", MOCK_VISITOR_ID));

            return mockFileToResponse(200, invocation, "mocks/related-visitors/get_related_visitors_200.json");
        });

        RelatedVisitorsResponse response = api.getRelatedVisitors(MOCK_VISITOR_ID);
        List<RelatedVisitor> relatedVisitorsList = response.getRelatedVisitors();

        assertEquals(relatedVisitorsList.size(), 2);
        assertEquals(relatedVisitorsList.get(0).getVisitorId(), "NtCUJGceWX9RpvSbhvOm");
        assertEquals(relatedVisitorsList.get(1).getVisitorId(), "25ee02iZwGxeyT0jMNkZ");
    }

    @Test
    public void searchEventsMinimumParamsTest() throws ApiException {
        int LIMIT = 1;
        addMock("searchEvents", null, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(2, queryParams.size());
            assertTrue(listContainsPair(queryParams, "limit", String.valueOf(LIMIT)));

            return mockFileToResponse(200, invocation, "mocks/get_event_search_200.json");
        });

        SearchEventsResponse response = api.searchEvents(LIMIT, null, null, null, null, null, null, null, null, null);
        List<SearchEventsResponseEventsInner> events = response.getEvents();

        assertEquals(events.size(), 1);
        Products products = events.get(0).getProducts();

        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getData());
        assertEquals("Ibk1527CUFmcnjLwIs4A9", products.getIdentification().getData().getVisitorId());

        assertFalse(products.getClonedApp().getData().getResult());
        assertFalse(products.getEmulator().getData().getResult());
        assertFalse(products.getFrida().getData().getResult());
        assertFalse(products.getJailbroken().getData().getResult());
        assertFalse(products.getIpBlocklist().getData().getResult());
        assertFalse(products.getProxy().getData().getResult());
        assertFalse(products.getTampering().getData().getResult());
        assertFalse(products.getTor().getData().getResult());
        assertFalse(products.getVpn().getData().getResult());
        assertFalse(products.getVirtualMachine().getData().getResult());
        assertFalse(products.getHighActivity().getData().getResult());
        assertFalse(products.getLocationSpoofing().getData().getResult());
        assertEquals(0, products.getFactoryReset().getData().getTimestamp());
        ProductRawDeviceAttributes signalResponseRawDeviceAttributes = products.getRawDeviceAttributes();
        assertEquals(127, signalResponseRawDeviceAttributes.getData().get("architecture").getValue());
        assertEquals(35.73832903057337, signalResponseRawDeviceAttributes.getData().get("audio").getValue());
        Map<String, Object> canvasAttribute = (Map<String, Object>) products.getRawDeviceAttributes().getData().get("canvas").getValue();
        assertEquals(true, canvasAttribute.get("Winding"));
        assertEquals("4dce9d6017c3e0c052a77252f29f2b1c", canvasAttribute.get("Geometry"));
        assertEquals("p3", signalResponseRawDeviceAttributes.getData().get("colorGamut").getValue());
        assertEquals(true, signalResponseRawDeviceAttributes.getData().get("cookiesEnabled").getValue());
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

        addMock("searchEvents", null, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(11, queryParams.size());
            assertTrue(listContainsPair(queryParams, "limit", String.valueOf(LIMIT)));
            assertTrue(listContainsPair(queryParams, "pagination_key", PAGINATION_KEY));
            assertTrue(listContainsPair(queryParams, "visitor_id", MOCK_VISITOR_ID));
            assertTrue(listContainsPair(queryParams, "bot", BOT));
            assertTrue(listContainsPair(queryParams, "ip_address", IP_ADDRESS));
            assertTrue(listContainsPair(queryParams, "linked_id", LINKED_ID));
            assertTrue(listContainsPair(queryParams, "start", String.valueOf(START)));
            assertTrue(listContainsPair(queryParams, "end", String.valueOf(END)));
            assertTrue(listContainsPair(queryParams, "reverse", String.valueOf(REVERSE)));
            assertTrue(listContainsPair(queryParams, "suspect", String.valueOf(SUSPECT)));

            return mockFileToResponse(200, invocation, "mocks/get_event_search_200.json");
        });

        SearchEventsResponse response = api.searchEvents(LIMIT, PAGINATION_KEY, MOCK_VISITOR_ID, BOT, IP_ADDRESS, LINKED_ID, START, END, REVERSE, SUSPECT);
        List<SearchEventsResponseEventsInner> events = response.getEvents();
        assertEquals(events.size(), 1);
    }

    @Test
    public void searchEvents400ErrorTest() throws ApiException, JsonProcessingException {
        int LIMIT = 1;
        addMock("searchEvents", null, invocation -> {
            List<Pair> queryParams = invocation.getArgument(3);
            assertEquals(2, queryParams.size());
            assertTrue(listContainsPair(queryParams, "limit", String.valueOf(LIMIT)));

            return mockFileToResponse(400, invocation, "mocks/errors/400_ip_address_invalid.json");
        });

        ApiException exception = assertThrows(ApiException.class,
                () -> api.searchEvents(LIMIT, null, null, null, null, null, null, null, null, null));

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
            assertEquals(2, queryParams.size());
            assertTrue(listContainsPair(queryParams, "limit", String.valueOf(LIMIT)));

            return mockFileToResponse(403, invocation, "mocks/errors/403_feature_not_enabled.json");
        });

        ApiException exception = assertThrows(ApiException.class,
                () -> api.searchEvents(LIMIT, null, null, null, null, null, null, null, null, null));

        assertEquals(403, exception.getCode());
        ErrorResponse response = MAPPER.readValue(exception.getResponseBody(), ErrorResponse.class);
        assertEquals(ErrorCode.FEATURE_NOT_ENABLED, response.getError().getCode());
        assertEquals("feature not enabled", response.getError().getMessage());
    }
}
