package com.fingerprint.example;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.model.*;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class FunctionalTests {

    public static void main(String... args) {
        final String apiSecret = System.getenv("FPJS_API_SECRET");
        if (apiSecret == null || apiSecret.isBlank()) {
            System.err.println("Missing required environment variable: FPJS_API_SECRET");
            System.exit(1);
        }

        final String regionEnv = System.getenv("FPJS_API_REGION");
        final String region = regionEnv != null ? regionEnv.toLowerCase(Locale.getDefault()).trim() : "us";

        final FingerprintApi api = new FingerprintApi(Configuration.getDefaultApiClient(apiSecret, region));

        long end = Instant.now().toEpochMilli();
        long start = Instant.now().minus(90L, ChronoUnit.DAYS).toEpochMilli();

        String visitorId = "";
        String requestId = "";

        // Search events
        try {
            final SearchEventsResponse events = api.searchEvents(2, new FingerprintApi.SearchEventsOptionalParams()
                    .setStart(start)
                    .setEnd(end)
            );
            assert events.getEvents() != null;
            if (events.getEvents().isEmpty()) {
                System.err.println("FingerprintApi.searchEvents: is empty");
                System.exit(1);
            }
            final ProductIdentification productIdentification = events.getEvents().get(0).getProducts().getIdentification();
            assert productIdentification != null;
            Identification firstEventIdentificationData = productIdentification.getData();
            assert firstEventIdentificationData != null;
            visitorId = firstEventIdentificationData.getVisitorId();
            requestId = firstEventIdentificationData.getRequestId();
            System.out.println(events.getEvents());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.searchEvents:" + e.getMessage());
            System.exit(1);
        }

        // Get identification event
        try {
            final EventsGetResponse event = api.getEvent(requestId);
            System.out.println(event);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
            System.exit(1);
        }

        // Get visitor history
        try {
            final VisitorsGetResponse visits = api.getVisits(visitorId, null, null, null, null, null);
            System.out.println(visits);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
            System.exit(1);
        }

        // Update identification event
        final String requestIdToUpdate = System.getenv("FPJS_REQUEST_ID_TO_UPDATE");
        if (requestIdToUpdate != null) {
            try {
                final HashMap<String, Object> tags = new HashMap() {{
                    put("timestamp", new Timestamp(new Date().getTime()));
                }};
                api.updateEvent(requestIdToUpdate, new EventsUpdateRequest().tag(tags));
            } catch (ApiException e) {
                System.err.println("Exception when calling FingerprintApi.updateEvent:" + e.getMessage());
                System.exit(1);
            }
        }

        // Delete visitor data
        final String visitorIdToDelete = System.getenv("FPJS_VISITOR_ID_TO_DELETE");
        if (visitorIdToDelete != null) {
            try {
                api.deleteVisitorData(visitorIdToDelete);
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
            assert oldEvents.getEvents() != null;
            if (oldEvents.getEvents().isEmpty()) {
                System.err.println("FingerprintApi.searchEvents: is empty for old events");
                System.exit(1);
            }
            final ProductIdentification productIdentification = oldEvents.getEvents().get(0).getProducts().getIdentification();
            assert productIdentification != null;
            Identification oldEventIdentificationData = productIdentification.getData();
            assert oldEventIdentificationData != null;
            String oldVisitorId = oldEventIdentificationData.getVisitorId();
            String oldRequestId = oldEventIdentificationData.getRequestId();

            if (requestId.equals(oldRequestId)) {
                System.err.println("Old events are identical to new");
                System.exit(1);
            }

            api.getEvent(oldRequestId);
            api.getVisits(oldVisitorId, null, null, null, null, null);
            System.out.println("Old events are good");
        } catch (ApiException e) {
            System.err.println("Exception when trying to read old data:" + e.getMessage());
            System.exit(1);
        }

        System.out.println("Checks Passed");
        System.exit(0);
    }
}
