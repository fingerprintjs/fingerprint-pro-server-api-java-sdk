package com.fingerprint.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fingerprint.model.*;
import com.fingerprint.sdk.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.openapitools.jackson.nullable.JsonNullableModule;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * API tests for FingerprintApi
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FingerprintApiTest {
    private FingerprintApi api;
    private final String MOCK_REQUEST_ID = "0KSh65EnVoB85JBmloQK";
    private final String MOCK_REQUEST_WITH_EXTRA_FIELDS_ID = "EXTRA_FIELDS";
    private final String MOCK_REQUEST_WITH_ALL_FAILED_SIGNALS = "ALL_FAILED_SIGNALS";
    private final String MOCK_REQUEST_BOTD_FAILED = "MOCK_REQUEST_BOTD_FAILED";
    private final String MOCK_REQUEST_BOTD_MANY_REQUEST = "MOCK_REQUEST_BOTD_MANY_REQUEST";
    private final String MOCK_REQUEST_IDENTIFICATION_FAILED = "MOCK_REQUEST_IDENTIFICATION_FAILED";
    private final String MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST = "MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST";
    private final String MOCK_VISITOR_ID = "AcxioeQKffpXF8iGQK3P";
    private final String MOCK_VISITOR_REQUEST_ID = "1655373780901.HhjRFX";


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
// TODO: Find the way to test SDK correctly for this scenario
//        when(api.getEvent(MOCK_REQUEST_WITH_EXTRA_FIELDS_ID)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_extra_fields.json"));
        when(api.getEvent(MOCK_REQUEST_WITH_ALL_FAILED_SIGNALS)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_all_errors.json"));
        when(api.getEvent(MOCK_REQUEST_BOTD_FAILED)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_botd_failed_error.json"));
        when(api.getEvent(MOCK_REQUEST_BOTD_MANY_REQUEST)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_botd_too_many_requests_error.json"));
        when(api.getEvent(MOCK_REQUEST_IDENTIFICATION_FAILED)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_identification_failed_error.json"));
        when(api.getEvent(MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST)).thenReturn(fetchMockWithEventResponse("mocks/get_event_200_identification_too_many_requests_error.json"));

        when(api.getVisits(MOCK_VISITOR_ID, MOCK_VISITOR_REQUEST_ID, null, 50, "1683900801733.Ogvu1j", null)).thenReturn(fetchMockVisit());
    }

    private EventResponse fetchMockWithEventResponse(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        JsonNullableModule jnm = new JsonNullableModule();
        mapper.registerModule(jnm);

        return mapper.readValue(getFileAsIOStream(fileName), EventResponse.class);
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
        assert response.getProducts() != null;
        assert response.getProducts().getIdentification() != null;
        assert response.getProducts().getIdentification().getData() != null;
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
        LinkedHashMap canvasAttribute = (LinkedHashMap)response.getProducts().getRawDeviceAttributes().getData().get("canvas").getValue();
        assertEquals(true, canvasAttribute.get("Winding"));
        assertEquals("4dce9d6017c3e0c052a77252f29f2b1c", canvasAttribute.get("Geometry"));
        assertEquals("srgb", signalResponseRawDeviceAttributes.getData().get("colorGamut").getValue());
        assertEquals(true, signalResponseRawDeviceAttributes.getData().get("cookiesEnabled").getValue());
    }

    /**
     * TODO: Find the way to test SDK correctly for this scenario
     * Get event by requestId
     * This endpoint allows you to get events with all the information from each activated product (Fingerprint Pro or Bot Detection). Use the requestId as a URL path :request_id parameter. This API method is scoped to a request, i.e. all returned information is by requestId.
     * Answer will contain fields of additional products that don't described in schema
     *
     * @throws ApiException if the Api call fails
     */
//    @Test
//    public void getEventWithExtraFieldsTest() throws ApiException {
//        EventResponse response = api.getEvent(MOCK_REQUEST_WITH_EXTRA_FIELDS_ID);
//        assert response.getProducts() != null;
//        assert response.getProducts().getIdentification() != null;
//        assert response.getProducts().getIdentification().getData() != null;
//        assertEquals(response.getProducts().getIdentification().getData().getVisitorId(), "Ibk1527CUFmcnjLwIs4A9");
//    }

    @Test
    public void getEventWithAllFailedSignalsTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_WITH_ALL_FAILED_SIGNALS);
        assert response.getProducts() != null;
        assert response.getProducts().getIdentification().getError().getCode() == IdentificationError.CodeEnum.FAILED;
        assert response.getProducts().getBotd().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getIpInfo().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getIncognito().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getRootApps().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getEmulator().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getIpBlocklist().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getTor().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getVpn().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getProxy().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getTampering().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getClonedApp().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getFactoryReset().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getJailbroken().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getFrida().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getPrivacySettings().getError().getCode() == ProductError.CodeEnum.FAILED;
        assert response.getProducts().getVirtualMachine().getError().getCode() == ProductError.CodeEnum.FAILED;

        SignalResponseRawDeviceAttributes signalResponseRawDeviceAttributes = response.getProducts().getRawDeviceAttributes();
        assertEquals("Error", signalResponseRawDeviceAttributes.getData().get("audio").getError().getName());
        assertEquals("internal server error", signalResponseRawDeviceAttributes.getData().get("audio").getError().getMessage());
        assertEquals("Error", signalResponseRawDeviceAttributes.getData().get("canvas").getError().getName());
        assertEquals("internal server error", signalResponseRawDeviceAttributes.getData().get("canvas").getError().getMessage());
    }

    @Test
    public void getEventBotdFailedErrorTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_BOTD_FAILED);
        assert response.getProducts() != null;
        assert response.getProducts().getIdentification() != null;
        assert response.getProducts().getIdentification().getData() != null;
        assertEquals(response.getProducts().getIdentification().getData().getVisitorId(), "Ibk1527CUFmcnjLwIs4A9");
        assert response.getProducts().getBotd().getData() == null;
        assert response.getProducts().getBotd().getError() != null;
        assert response.getProducts().getBotd().getError().getCode() == ProductError.CodeEnum.FAILED;
    }

    @Test
    public void getEventBotdManyRequestsErrorTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_BOTD_MANY_REQUEST);
        assert response.getProducts() != null;
        assert response.getProducts().getIdentification() != null;
        assert response.getProducts().getIdentification().getData() != null;
        assertEquals(response.getProducts().getIdentification().getData().getVisitorId(), "Ibk1527CUFmcnjLwIs4A9");
        assert response.getProducts().getBotd().getData() == null;
        assert response.getProducts().getBotd().getError() != null;
        assert response.getProducts().getBotd().getError().getCode() == ProductError.CodeEnum.TOOMANYREQUESTS;
    }

    @Test
    public void getEventIdentificationFailedErrorTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_IDENTIFICATION_FAILED);
        assert response.getProducts() != null;
        assert response.getProducts().getIdentification() != null;
        assert response.getProducts().getIdentification().getData() == null;
        assert response.getProducts().getIdentification().getError() != null;
        assert response.getProducts().getIdentification().getError().getCode() == IdentificationError.CodeEnum.FAILED;
        assert response.getProducts().getBotd().getData() != null;
        assert response.getProducts().getBotd().getError() == null;
    }

    @Test
    public void getEventIdentificationManyRequestsErrorTest() throws ApiException {
        EventResponse response = api.getEvent(MOCK_REQUEST_IDENTIFICATION_MANY_REQUEST);
        assert response.getProducts() != null;
        assert response.getProducts().getIdentification() != null;
        assert response.getProducts().getIdentification().getData() == null;
        assert response.getProducts().getIdentification().getError() != null;
        assert response.getProducts().getIdentification().getError().getCode() == IdentificationError.CodeEnum._429_TOO_MANY_REQUESTS;
        assert response.getProducts().getBotd().getData() != null;
        assert response.getProducts().getBotd().getError() == null;
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

}
