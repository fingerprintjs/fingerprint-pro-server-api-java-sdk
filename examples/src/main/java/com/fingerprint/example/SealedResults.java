package com.fingerprint.example;

import com.fingerprint.Sealed;
import com.fingerprint.model.Event;

import java.util.Base64;

public class SealedResults {
    public static void main(String... args) throws Exception {
        String SEALED_RESULT = System.getenv("BASE64_SEALED_RESULT");
        String SEALED_KEY = System.getenv("BASE64_KEY");

        final Event event = Sealed.unsealEventResponse(
                Base64.getDecoder().decode(SEALED_RESULT),
                new Sealed.DecryptionKey[]{
                        new Sealed.DecryptionKey(
                                Base64.getDecoder().decode(SEALED_KEY),
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        )
                }
        );

        System.out.println(event);
        System.exit(0);
    }
}
