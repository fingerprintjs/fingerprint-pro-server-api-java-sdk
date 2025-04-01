package com.fingerprint.example;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.*;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;

public class FunctionalTests {
    public static void main(String... args) {
        String FPJS_API_SECRET = System.getenv("FPJS_API_SECRET");
        String FPJS_API_REGION = System.getenv("FPJS_API_REGION");
        String FPJS_REQUEST_ID_TO_UPDATE = System.getenv("FPJS_REQUEST_ID_TO_UPDATE");
        String FPJS_VISITOR_ID_TO_DELETE = System.getenv("FPJS_VISITOR_ID_TO_DELETE");
        String FPJS_VISITOR_ID = "";
        String FPJS_REQUEST_ID = "";

        // Create a new instance of the API client
        ApiClient client = Configuration.getDefaultApiClient(FPJS_API_SECRET, FPJS_API_REGION != null ? FPJS_API_REGION : "us");
        FingerprintApi api = new FingerprintApi(client);

        long end = Instant.now().toEpochMilli();
        long start = Instant.now().minus(90L, ChronoUnit.DAYS).toEpochMilli();

        // Search events
        try {
            final SearchEventsResponse events = api.searchEvents(2, new FingerprintApi.SearchEventsOptionalParams()
                    .setStart(start)
                    .setEnd(end)
            );
            if (events.getEvents().isEmpty()) {
                System.err.println("FingerprintApi.searchEvents: is empty");
                System.exit(1);
            }
            Identification firstEventIdentificationData = events.getEvents().get(0).getProducts().getIdentification().getData();
            FPJS_VISITOR_ID = firstEventIdentificationData.getVisitorId();
            FPJS_REQUEST_ID = firstEventIdentificationData.getRequestId();
            System.out.println(events.getEvents());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.searchEvents:" + e.getMessage());
            System.exit(1);
        }

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

        // Check that old events are still match expected format
        try {
            final SearchEventsResponse oldEvents = api.searchEvents(2, new FingerprintApi.SearchEventsOptionalParams()
                    .setStart(start)
                    .setEnd(end)
                    .setReverse(true)
            );
            if (oldEvents.getEvents().isEmpty()) {
                System.err.println("FingerprintApi.searchEvents: is empty for old events");
                System.exit(1);
            }
            Identification oldEventIdentificationData = oldEvents.getEvents().get(0).getProducts().getIdentification().getData();
            String FPJS_OLD_VISITOR_ID = oldEventIdentificationData.getVisitorId();
            String FPJS_OLD_REQUEST_ID = oldEventIdentificationData.getRequestId();

            if (FPJS_VISITOR_ID.equals(FPJS_OLD_VISITOR_ID) || FPJS_REQUEST_ID.equals(FPJS_OLD_REQUEST_ID)) {
                System.err.println("Old events are identical to new");
                System.exit(1);
            }

            api.getEvent(FPJS_OLD_REQUEST_ID);
            api.getVisits(FPJS_OLD_VISITOR_ID, null, null, null, null, null);
            System.out.println("Old events are good");
        } catch (ApiException e) {
            System.err.println("Exception when trying to read old data:" + e.getMessage());
            System.exit(1);
        }

        System.out.println("Checks Passed");
        System.exit(0);
    }
}
