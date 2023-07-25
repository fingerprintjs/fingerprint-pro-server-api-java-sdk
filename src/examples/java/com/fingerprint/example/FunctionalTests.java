package com.fingerprint.example;

import com.fingerprint.api.FingerprintApi;
import com.fingerprint.sdk.ApiClient;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

public class FunctionalTests {
    public static void main(String... args) {
        Dotenv dotenv = Dotenv.configure().load();

        String FPJS_API_SECRET = System.getenv("FPJS_API_SECRET");
        if (FPJS_API_SECRET == null) {
            FPJS_API_SECRET = dotenv.get("FPJS_API_SECRET");
        }

        String FPJS_VISITOR_ID = System.getenv("FPJS_VISITOR_ID");
        if (FPJS_VISITOR_ID == null) {
            FPJS_VISITOR_ID = dotenv.get("FPJS_VISITOR_ID");
        }

        String FPJS_REQUEST_ID = System.getenv("FPJS_REQUEST_ID");
        if (FPJS_REQUEST_ID == null) {
            FPJS_REQUEST_ID = dotenv.get("FPJS_REQUEST_ID");
        }

        String FPJS_API_REGION = System.getenv("FPJS_API_REGION");
        if (FPJS_API_REGION == null) {
            FPJS_API_REGION = dotenv.get("FPJS_API_REGION");
        }

      

        ApiClient client = Configuration.getDefaultApiClient(FPJS_API_SECRET, FPJS_API_REGION != null ? FPJS_API_REGION : "eu");
        FingerprintApi api = new FingerprintApi(client);

        try {
            final Object event = api.getEvent(FPJS_REQUEST_ID);
            System.out.println(event);
        } catch (ApiException e) {
            System.err.println("Exception when calling FingerprintApi.getEvent:" + e.getMessage());
            System.exit(1);
        }

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
