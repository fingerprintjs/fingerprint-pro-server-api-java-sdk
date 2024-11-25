package com.fingerprint.example;

import com.fingerprint.sdk.WebhookValidation;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class WebhookSignatureSample {

    public static void main(String... args) {
        final String header = "v1=1b2c16b75bd2a870c114153ccda5bcfca63314bc722fa160d690de133ccbb9db";
        final String secret = "secret";
        final byte[] data = "data".getBytes(StandardCharsets.UTF_8);

        try {
            boolean isSignatureValid = WebhookValidation.isSignatureValid(header, data, secret);
            if (isSignatureValid) {
                System.out.println("Webhook signature is valid");
            } else {
                System.out.println("Webhook signature is not valid");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
