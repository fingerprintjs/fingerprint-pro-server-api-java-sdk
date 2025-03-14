package com.fingerprint.example;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.EventsGetResponse;
import com.fingerprint.model.EventsUpdateRequest;
import com.fingerprint.model.SearchEventsResponse;
import com.fingerprint.model.VisitorsGetResponse;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

public class FunctionalTests {
    public static void main(String... args) {
        String FPJS_API_SECRET = System.getenv("FPJS_API_SECRET");
        String FPJS_VISITOR_ID = System.getenv("FPJS_VISITOR_ID");
        String FPJS_REQUEST_ID = System.getenv("FPJS_REQUEST_ID");
        String FPJS_API_REGION = System.getenv("FPJS_API_REGION");
        String FPJS_REQUEST_ID_TO_UPDATE = System.getenv("FPJS_REQUEST_ID_TO_UPDATE");
        String FPJS_VISITOR_ID_TO_DELETE = System.getenv("FPJS_VISITOR_ID_TO_DELETE");

        // Create a new instance of the API client
        ApiClient client = Configuration.getDefaultApiClient(FPJS_API_SECRET, FPJS_API_REGION != null ? FPJS_API_REGION : "us");
        FingerprintApi api = new FingerprintApi(client);


        // Get identification event
        try {
            final EventsGetResponse event = api.getEvent(FPJS_REQUEST_ID);
            System.out.println(event);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
            System.exit(1);
        }

        // Get visitor history
        try {
            final VisitorsGetResponse visits = api.getVisits(FPJS_VISITOR_ID, null, null, null, null, null);
            System.out.println(visits);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
            System.exit(1);
        }

        // Search events
        try {
            final SearchEventsResponse events = api.searchEvents(2, new FingerprintApi.SearchEventsOptionalParams().setBot("bad"));
            System.out.println(events.getEvents());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.searchEvents:" + e.getMessage());
            System.exit(1);
        }

        // Update identification event

        if (FPJS_REQUEST_ID_TO_UPDATE != null) {
            try {
                final HashMap<String, Object> tags = new HashMap() {{
                    put("timestamp", new Timestamp(new Date().getTime()));
                }};
                api.updateEvent(FPJS_REQUEST_ID_TO_UPDATE, new EventsUpdateRequest().tag(tags));
            } catch (ApiException e) {
                System.err.println("Exception when calling FingerprintApi.updateEvent:" + e.getMessage());
                System.exit(1);
            }
        }

        // Delete visitor data

        if (FPJS_VISITOR_ID_TO_DELETE != null) {
            try {
                api.deleteVisitorData(FPJS_VISITOR_ID_TO_DELETE);
            } catch (ApiException e) {
                System.err.println("Exception when calling FingerprintApi.deleteVisitor:" + e.getMessage());
                System.exit(1);
            }
        }

        System.out.println("Checks Passed");
        System.exit(0);
    }
}
