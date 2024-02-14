package com.fingerprint.example;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;

public class FunctionalTests {
    public static void main(String... args) {
        EnvUtil envUtil = new EnvUtil();

        String FPJS_API_SECRET = envUtil.getEnv("FPJS_API_SECRET");
        String FPJS_VISITOR_ID = envUtil.getEnv("FPJS_VISITOR_ID");
        String FPJS_REQUEST_ID = envUtil.getEnv("FPJS_REQUEST_ID");
        String FPJS_API_REGION = envUtil.getEnv("FPJS_API_REGION");

        // Create a new instance of the API client
        ApiClient client = Configuration.getDefaultApiClient(FPJS_API_SECRET, FPJS_API_REGION != null ? FPJS_API_REGION : "us");
        FingerprintApi api = new FingerprintApi(client);


        // Get identification event
        try {
            final Object event = api.getEvent(FPJS_REQUEST_ID);
            System.out.println(event);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
            System.exit(1);
        }

        // Get visitor history
        try {
            final Object visits = api.getVisits(FPJS_VISITOR_ID, null, null, null, null, null);
            System.out.println(visits);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
            System.exit(1);
        }

        System.out.println("Checks Passed");
        System.exit(0);
    }
}
