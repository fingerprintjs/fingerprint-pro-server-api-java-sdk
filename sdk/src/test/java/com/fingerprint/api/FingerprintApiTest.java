package com.fingerprint.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fingerprint.model.*;
import com.fingerprint.sdk.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

    @BeforeAll
    public void before() throws ApiException, IOException {
        api = Mockito.mock(FingerprintApi.class);
        when(api.getEvent(MOCK_REQUEST_ID)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200.json"));
        when(api.getEvent(MOCK_REQUEST_WITH_EXTRA_FIELDS_ID)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_extra_fields.json"));
        when(api.getEvent(MOCK_REQUEST_WITH_ALL_FAILED_SIGNALS)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_all_errors.json"));
        when(api.getEvent(MOCK_REQUEST_BOTD_FAILED)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_botd_failed_error.json"));
        when(api.getEvent(MOCK_REQUEST_BOTD_MANY_REQUEST)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_botd_too_many_requests_error.json"));
        when(api.getEvent(MOCK_REQUEST_IDENTIFICATION_FAILED)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_identification_failed_error.json"));
        when(api.getEvent(MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_identification_too_many_requests_error.json"));

        when(api.getVisits(MOCK_VISITOR_ID, MOCK_VISITOR_REQUEST_ID, null, 50, "1683900801733.Ogvu1j", null)).thenReturn(fetchMockVisit());
    }

    private static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    private EventResponse fetchMockWithEventResponse(String fileName) throws IOException {
        return MAPPER.readValue(getFileAsIOStream(fileName), EventResponse.class);
    }

    private <T> T fetchMock(String filename, Class<T> type) throws IOException {
        return MAPPER.readValue(getFileAsIOStream(filename), type);
    }

    private Response fetchMockVisit() throws IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        return mapper.readValue(getFileAsIOStream("mocks/get_visits_200_limit_500.json"), Response.class);
    }

    /**
     * Get event by requestId
     * This endpoint allows you to get events with all the information from each activated product (Fingerprint Pro or Bot Detection). Use the requestId as a URL path :request_id parameter. This API method is scoped to a request, i.e. all returned information is by requestId.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getEventTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_ID);
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
        SignalResponseRawDeviceAttributes signalResponseRawDeviceAttributes = response.getProducts().getRawDeviceAttributes();
        assertEquals(127, signalResponseRawDeviceAttributes.getData().get("architecture").getValue());
        assertEquals(35.73832903057337, signalResponseRawDeviceAttributes.getData().get("audio").getValue());
        Map<String, Object> canvasAttribute = (Map<String, Object>) response.getProducts().getRawDeviceAttributes().getData().get("canvas").getValue();
        assertEquals(true, canvasAttribute.get("Winding"));
        assertEquals("4dce9d6017c3e0c052a77252f29f2b1c", canvasAttribute.get("Geometry"));
        assertEquals("p3", signalResponseRawDeviceAttributes.getData().get("colorGamut").getValue());
        assertEquals(true, signalResponseRawDeviceAttributes.getData().get("cookiesEnabled").getValue());
    }

    @Test
    public void updateOneFieldEventRequest() throws IOException {
        EventUpdateRequest request = fetchMock("mocks/update_event_one_field_request.json", EventUpdateRequest.class);
        assertDoesNotThrow(() -> api.updateEvent(MOCK_REQUEST_ID, request));
    }

    @Test
    public void updateMultipleFieldsEventRequest() throws IOException {
        EventUpdateRequest request = fetchMock("mocks/update_event_multiple_fields_request.json", EventUpdateRequest.class);
        assertDoesNotThrow(() -> api.updateEvent(MOCK_REQUEST_ID, request));
    }

    @Test
    public void deleteVisitorDataTest() {
        assertDoesNotThrow(() -> api.deleteVisitorData(MOCK_VISITOR_ID));
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
        EventResponse response = api.getEvent(MOCK_REQUEST_WITH_EXTRA_FIELDS_ID);
        ProductsResponse products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getData());
        assertEquals("Ibk1527CUFmcnjLwIs4A9", products.getIdentification().getData().getVisitorId());
    }

    @Test
    public void getEventWithAllFailedSignalsTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_WITH_ALL_FAILED_SIGNALS);
        ProductsResponse products = response.getProducts();

        assertNotNull(products);
        assertEquals(IdentificationError.CodeEnum.FAILED, products.getIdentification().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getBotd().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getIpInfo().getError().getCode());
        assertEquals(IdentificationError.CodeEnum.FAILED, products.getIncognito().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getRootApps().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getEmulator().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getIpBlocklist().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getTor().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getVpn().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getProxy().getError().getCode());
        assertEquals(IdentificationError.CodeEnum.FAILED, products.getTampering().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getClonedApp().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getFactoryReset().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getJailbroken().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getFrida().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getPrivacySettings().getError().getCode());
        assertEquals(ProductError.CodeEnum.FAILED, products.getVirtualMachine().getError().getCode());

        SignalResponseRawDeviceAttributes signalResponseRawDeviceAttributes = response.getProducts().getRawDeviceAttributes();
        assertEquals("Error", signalResponseRawDeviceAttributes.getData().get("audio").getError().getName());
        assertEquals("internal server error", signalResponseRawDeviceAttributes.getData().get("audio").getError().getMessage());
        assertEquals("Error", signalResponseRawDeviceAttributes.getData().get("canvas").getError().getName());
        assertEquals("internal server error", signalResponseRawDeviceAttributes.getData().get("canvas").getError().getMessage());
    }

    @Test
    public void getEventBotdFailedErrorTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_BOTD_FAILED);
        ProductsResponse products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getData());
        assertEquals("Ibk1527CUFmcnjLwIs4A9", products.getIdentification().getData().getVisitorId());

        assertNotNull(products.getBotd());
        assertNotNull(products.getBotd().getError());
        assertEquals(ProductError.CodeEnum.FAILED, products.getBotd().getError().getCode());
    }

    @Test
    public void getEventBotdManyRequestsErrorTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_BOTD_MANY_REQUEST);
        ProductsResponse products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getData());
        assertEquals("Ibk1527CUFmcnjLwIs4A9", response.getProducts().getIdentification().getData().getVisitorId());
        assertNotNull(products.getBotd());
        assertNotNull(products.getBotd().getError());
        assertEquals(ProductError.CodeEnum.TOO_MANY_REQUESTS, products.getBotd().getError().getCode());
    }

    @Test
    public void getEventIdentificationFailedErrorTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_IDENTIFICATION_FAILED);
        ProductsResponse products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getError());
        assertEquals(IdentificationError.CodeEnum.FAILED, products.getIdentification().getError().getCode());
        assertNotNull(products.getBotd());
        assertNotNull(products.getBotd().getData());
    }

    @Test
    public void getEventIdentificationManyRequestsErrorTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST);
        ProductsResponse products = response.getProducts();
        assertNotNull(products);
        assertNotNull(products.getIdentification());
        assertNotNull(products.getIdentification().getError());
        assertEquals(IdentificationError.CodeEnum._429_TOO_MANY_REQUESTS, products.getIdentification().getError().getCode());
        assertNotNull(products.getBotd());
        assertNotNull(products.getBotd().getData());
    }

    /**
     * Get visits by visitorId
     * This endpoint allows you to get a history of visits with all available information. Use the visitorId as a URL path parameter. This API method is scoped to a visitor, i.e. all returned information is by visitorId.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getVisitsTest() throws ApiException {
        Response response = api.getVisits(MOCK_VISITOR_ID, MOCK_VISITOR_REQUEST_ID, null, 50, "1683900801733.Ogvu1j", null);
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

        WebhookVisit visit =  mapper.readValue(getFileAsIOStream("mocks/webhook.json"), WebhookVisit.class);

        assertEquals(MOCK_WEBHOOK_VISITOR_ID, visit.getVisitorId());
        assertEquals(MOCK_WEBHOOK_REQUEST_ID, visit.getRequestId());
    }

}
