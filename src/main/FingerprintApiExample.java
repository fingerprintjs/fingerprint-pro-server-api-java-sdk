package main;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.models.EventResponse;
import com.fingerprint.models.Response;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import com.fingerprint.sdk.Region;

public class FingerprintApiExample {
    // Fingerprint Pro Secret API Key
    private static final String FPJS_API_SECRET = "Fingerprint Pro Secret API Key";

    // A mandatory visitorId of a specific visitor
    private static final String FPJS_VISITOR_ID = "visitorId";

    // An optional requestId made by a specific visitor
    private static final String FPJS_REQUEST_ID = "requestId";

    // An optional linkedId of the visit
    private static final String FPJS_LINKED_ID = "linkedId";

    // An optional parameter limiting scanned results
    private static final Integer LIMIT = 10;

    // An optional parameter used to paginate results, see lastTimestamp
    private static final Integer BEFORE = 1;


    public static void main(String... args) {
        // Create a new api client instance from Configuration with your Fingerprint Pro Server API Key and your Fingerprint Pro Server API Region.
        /*
          You can specify a region on getDefaultApiClient function's second parameter
          If you leave the second parameter empty, then Region.GLOBAL will be used as a default region
          Options for regions are:
          Region.GLOBAL
          Region.EUROPE
          Region.ASIA
         */
        ApiClient client = Configuration.getDefaultApiClient(FPJS_API_SECRET, Region.EUROPE);
        FingerprintApi api = new FingerprintApi(client);

        // Get an event with a given requestId
        try {
            // Fetch the event with a given requestId
            EventResponse response = api.getEvent(FPJS_REQUEST_ID);
            System.out.println(response.getProducts().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }

        // Get a specific visitor's all visits
        try {
            // Fetch all visits with a given visitorId, with a page limit
            Response response = api.getVisits(FPJS_VISITOR_ID, null, null, LIMIT, null);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }

        // Get a specific visitor's all visits with a linkedId
        try {
            // Fetch all visits with a given visitorId, with a page limit, skipping the first visit
            Response response = api.getVisits(FPJS_VISITOR_ID, null, FPJS_LINKED_ID, LIMIT, BEFORE);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }

        // Use all the parameters on getVisits
        try {
            // Fetch the visitor's all visits with a given requestId and linkedId with a page limit while skipping the first visit
            Response response = api.getVisits(FPJS_VISITOR_ID, FPJS_REQUEST_ID, FPJS_LINKED_ID, LIMIT, BEFORE);
            System.out.println(response.getVisits().toString());
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
        }
    }
}
