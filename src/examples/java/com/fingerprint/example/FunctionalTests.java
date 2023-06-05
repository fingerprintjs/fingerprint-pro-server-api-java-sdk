package com.fingerprint.example;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;

public class FunctionalTests {
    public static void main(String... args) {
        final String FPJS_API_SECRET = System.getenv("FPJS_API_SECRET");
        final String FPJS_VISITOR_ID = System.getenv("FPJS_VISITOR_ID");
        final String FPJS_REQUEST_ID = System.getenv("FPJS_REQUEST_ID");
        final String FPJS_API_REGION = System.getenv("FPJS_API_REGION");

        ApiClient client = Configuration.getDefaultApiClient(FPJS_API_SECRET, FPJS_API_REGION != null ? FPJS_API_REGION : "eu");
        FingerprintApi api = new FingerprintApi(client);

        try {
            api.getEvent(FPJS_REQUEST_ID);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
            System.exit(1);
        }

        try {
            api.getVisits(FPJS_VISITOR_ID, null, null, null, null, null);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
            System.exit(1);
        }

        System.out.println("Checks Passed");
        System.exit(0);
    }
}
