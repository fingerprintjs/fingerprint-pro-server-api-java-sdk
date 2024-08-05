package com.fingerprint;

import com.fingerprint.sdk.Webhook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebhookTest {

    private static final String validHeader = "v1=1b2c16b75bd2a870c114153ccda5bcfca63314bc722fa160d690de133ccbb9db";
    private static final String secret = "secret";
    private static final byte[] data = "data".getBytes(StandardCharsets.UTF_8);

    @Test
    public void validHeaderTest() throws NoSuchAlgorithmException {
        boolean result = Webhook.isValidWebhookSignature(validHeader, data, secret);
        Assertions.assertTrue(result);
    }

    @Test
    public void invalidHeaderTest() throws NoSuchAlgorithmException {
        boolean result = Webhook.isValidWebhookSignature("v2=wrong", data, secret);
        assert !result;
    }

    @Test
    public void headerWithoutVersionTest() throws NoSuchAlgorithmException {
        boolean result = Webhook.isValidWebhookSignature("secretonly", data, secret);
        assert !result;
    }

    @Test
    public void emptySecretTest() throws NoSuchAlgorithmException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Webhook.isValidWebhookSignature("v1=value", data, "");
        });
    }

    @Test
    public void emptyDataTest() throws NoSuchAlgorithmException {
        boolean result = Webhook.isValidWebhookSignature(validHeader, "".getBytes(), secret);
        assert !result;
    }

}
