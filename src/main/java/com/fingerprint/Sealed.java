package com.fingerprint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fingerprint.model.EventResponse;
import com.fingerprint.sdk.ApiClient;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class Sealed {
    private static final Logger log = Logger.getLogger(ApiClient.class.getName());

    public enum DecryptionAlgorithm {
        AES_256_GCM
    }

    public static class DecryptionKey {
        private final byte[] key;
        private final DecryptionAlgorithm algorithm;

        public DecryptionKey(byte[] key, DecryptionAlgorithm algorithm) {
            this.key = key;
            this.algorithm = algorithm;
        }
    }

    private static final byte[] SEAL_HEADER = new byte[]{(byte) 0x9E, (byte) 0x85, (byte) 0xDC, (byte) 0xED};
    private static final int NONCE_LENGTH = 12;
    private static final int AUTH_TAG_LENGTH = 16;

    public static byte[] unseal(byte[] sealed, DecryptionKey[] keys) throws IllegalArgumentException {
        if (!Arrays.equals(Arrays.copyOf(sealed, SEAL_HEADER.length), SEAL_HEADER)) {
            throw new IllegalArgumentException("Invalid sealed data header");
        }

        int index = 0;

        for (DecryptionKey key : keys) {
            switch (key.algorithm) {
                case AES_256_GCM:
                    try {
                        return decryptAes256Gcm(Arrays.copyOfRange(sealed, SEAL_HEADER.length, sealed.length), key.key);
                    } catch (Exception exception) {
                        log.warning(String.format("Failed to decrypt with key: %d error: %s", index, exception.getMessage()));
                    }

                    break;

                default:
                    throw new IllegalArgumentException("Invalid decryption algorithm");
            }

            index++;
        }

        throw new IllegalArgumentException("Invalid decryption keys");
    }

    /**
     * decrypts the sealed response with the provided keys.
     *
     * @param sealed Base64 encoded sealed data
     * @param keys  Decryption keys. The SDK will try to decrypt the result with each key until it succeeds.
     * @return EventResponse
     * @throws Exception if the sealed data is invalid or if the decryption keys are invalid
     */
    public static EventResponse unsealEventResponse(byte[] sealed, DecryptionKey[] keys) throws Exception {
        byte[] unsealed = unseal(sealed, keys);

        ObjectMapper mapper = ObjectMapperUtil.getObjectMapper();

        return mapper.readValue(unsealed, EventResponse.class);
    }

    private static byte[] decryptAes256Gcm(byte[] sealedData, byte[] decryptionKey) throws Exception {
        byte[] nonce = Arrays.copyOfRange(sealedData, 0, NONCE_LENGTH);
        byte[] ciphertext = Arrays.copyOfRange(sealedData, NONCE_LENGTH, sealedData.length);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec nonceSpec = new GCMParameterSpec(Byte.SIZE * AUTH_TAG_LENGTH, nonce);
        SecretKeySpec keySpec = new SecretKeySpec(decryptionKey, "AES");

        cipher.init(Cipher.DECRYPT_MODE, keySpec, nonceSpec);
        byte[] decryptedData = cipher.doFinal(ciphertext);

        // Decompressing the decrypted data
        return decompress(decryptedData);
    }

    private static byte[] decompress(byte[] data) throws IOException {
        Inflater inflater = new Inflater(true); // true for raw deflate data
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(data), inflater);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] temp = new byte[1024];
        while ((nRead = inflaterInputStream.read(temp, 0, temp.length)) != -1) {
            buffer.write(temp, 0, nRead);
        }

        return buffer.toByteArray();
    }
}

