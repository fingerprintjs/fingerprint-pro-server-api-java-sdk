package com.fingerprint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fingerprint.model.EventResponse;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class Sealed {
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

        @Override
        public String toString() {
            return "DecryptionKey{" +
                    "key=" + Base64.getEncoder().encodeToString(key) +
                    ", algorithm=" + algorithm +
                    '}';
        }
    }

    public static class UnsealAggregateException extends Exception {
        public UnsealAggregateException() {
            super("Failed to unseal with all decryption keys");
        }
    }

    public static class InvalidSealedDataException extends IllegalArgumentException {
        public InvalidSealedDataException() {
            super("Invalid sealed data");
        }
    }

    public static class InvalidSealedDataHeaderException extends IllegalArgumentException {
        public InvalidSealedDataHeaderException() {
            super("Invalid sealed data header");
        }
    }

    public static class UnsealException extends Exception {
        public final String decryptionKeyDescription;

        public UnsealException(String message, Throwable cause, DecryptionKey decryptionKey) {
            super(message, cause);
            this.decryptionKeyDescription = decryptionKey.toString();
        }

        @Override
        public String toString() {
            return "UnsealException{" +
                    "decryptionKey=" + decryptionKeyDescription +
                    ", message=" + getMessage() +
                    ", cause=" + getCause() +
                    '}';
        }
    }

    private static final byte[] SEAL_HEADER = new byte[]{(byte) 0x9E, (byte) 0x85, (byte) 0xDC, (byte) 0xED};
    private static final int NONCE_LENGTH = 12;
    private static final int AUTH_TAG_LENGTH = 16;

    public static byte[] unseal(byte[] sealed, DecryptionKey[] keys) throws IllegalArgumentException, UnsealAggregateException {
        if (!Arrays.equals(Arrays.copyOf(sealed, SEAL_HEADER.length), SEAL_HEADER)) {
            throw new InvalidSealedDataHeaderException();
        }

        UnsealAggregateException aggregateException = new UnsealAggregateException();

        for (DecryptionKey key : keys) {
            switch (key.algorithm) {
                case AES_256_GCM:
                    try {
                        return decryptAes256Gcm(Arrays.copyOfRange(sealed, SEAL_HEADER.length, sealed.length), key.key);
                    } catch (Exception exception) {
                        aggregateException.addSuppressed(
                                new UnsealException(
                                        "Failed to decrypt",
                                        exception,
                                        key
                                )
                        );
                    }

                    break;

                default:
                    throw new IllegalArgumentException("Invalid decryption algorithm");
            }
        }

        throw aggregateException;
    }

    /**
     * decrypts the sealed response with the provided keys.
     *
     * @param sealed Base64 encoded sealed data
     * @param keys   Decryption keys. The SDK will try to decrypt the result with each key until it succeeds.
     * @return EventResponse
     */
    public static EventResponse unsealEventResponse(byte[] sealed, DecryptionKey[] keys) throws IllegalArgumentException, UnsealAggregateException, IOException {
        byte[] unsealed = unseal(sealed, keys);

        ObjectMapper mapper = ObjectMapperUtil.getObjectMapper();

        EventResponse value = mapper.readValue(unsealed, EventResponse.class);

        if (value.getProducts() == null) {
            throw new InvalidSealedDataException();
        }

        return value;
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

