package com.fingerprint.sdk;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class WebhookValidation {

    /**
     * Verifies the HMAC signature extracted from the "fpjs-event-signature" header of the incoming request.
     * This is a part of the webhook signing process, which is available only for enterprise customers.
     * @param header The value of the "fpjs-event-signature" header
     * @param data The raw data of the incoming request
     * @param secret The secret key used to sign the request
     * @return true if the signature is valid
     * @throws NoSuchAlgorithmException in case HMAC-SHA-256 isn't available
     * @throws IllegalArgumentException if an invalid key is provided
     */
    public static boolean isValidWebhookSignature(String header, byte[] data, String secret) throws NoSuchAlgorithmException {
        String[] signatures = header.split(",");
        for (String signature : signatures) {
            String[] parts = signature.split("=");
            if (parts.length == 2) {
                final String version = parts[0];
                final String hash = parts[1];
                if (version.equals("v1") && isValidHmacSignature(hash, data, secret)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final String ALGORITHM = "HmacSHA256";

    private static boolean isValidHmacSignature(String signature, byte[] data, String secret) throws NoSuchAlgorithmException {
        SecretKeySpec spec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Mac mac = Mac.getInstance(ALGORITHM);
        try {
            mac.init(spec);
            byte[] computed = mac.doFinal(data);
            String computedHash = Hex.encodeHexString(computed).replace("-", "").toLowerCase();
            return computedHash.equals(signature);
        } catch (InvalidKeyException e) {
            return false;
        }
    }

}
