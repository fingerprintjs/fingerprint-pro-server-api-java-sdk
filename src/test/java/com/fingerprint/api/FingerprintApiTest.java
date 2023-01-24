package com.fingerprint.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fingerprint.sdk.*;
import com.fingerprint.model.EventResponse;
import com.fingerprint.model.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * API tests for FingerprintApi
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FingerprintApiTest {
    private FingerprintApi api;
    private final String MOCK_REQUEST_ID = "0KSh65EnVoB85JBmloQK";
    private final String MOCK_VISITOR_ID = "AcxioeQKffpXF8iGQK3P";
    private final String MOCK_VISITOR_REQUEST_ID = "1655373780901.HhjRFX";


    @BeforeAll
    public void before() throws ApiException, IOException {
        api = Mockito.mock(FingerprintApi.class);
        when(api.getEvent(MOCK_REQUEST_ID)).thenReturn(fetchMockEvent());
        when(api.getVisits(MOCK_VISITOR_ID, MOCK_VISITOR_REQUEST_ID, null, 50, 0)).thenReturn(fetchMockVisit());
    }

    private EventResponse fetchMockEvent() throws IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        return mapper.readValue(new FileReader("./mocks/get_event.json"), EventResponse.class);
    }

    private Response fetchMockVisit() throws IOException {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        return mapper.readValue(new FileReader("./mocks/visits_limit_500.json"), Response.class);
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
        assertEquals(response.getProducts().getIdentification().getData().getVisitorId(), "Ibk1527CUFmcnjLwIs4A9");
    }

    /**
     * Get visits by visitorId
     * This endpoint allows you to get a history of visits with all available information. Use the visitorId as a URL path parameter. This API method is scoped to a visitor, i.e. all returned information is by visitorId.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getVisitsTest() throws ApiException {
        Response response = api.getVisits(MOCK_VISITOR_ID, MOCK_VISITOR_REQUEST_ID, null, 50, 0);
        assertEquals(response.getVisitorId(), MOCK_VISITOR_ID);
    }

}
