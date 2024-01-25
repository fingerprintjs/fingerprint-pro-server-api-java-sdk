package com.fingerprint;

import com.fingerprint.model.EventResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SealedTest {
    @Test
    public void unsealEventResponseTest() throws Exception {
        byte[] sealedResult = Base64.getDecoder().decode("noXc7SXO+mqeAGrvBMgObi/S0fXTpP3zupk8qFqsO/1zdtWCD169iLA3VkkZh9ICHpZ0oWRzqG0M9/TnCeKFohgBLqDp6O0zEfXOv6i5q++aucItznQdLwrKLP+O0blfb4dWVI8/aSbd4ELAZuJJxj9bCoVZ1vk+ShbUXCRZTD30OIEAr3eiG9aw00y1UZIqMgX6CkFlU9L9OnKLsNsyomPIaRHTmgVTI5kNhrnVNyNsnzt9rY7fUD52DQxJILVPrUJ1Q+qW7VyNslzGYBPG0DyYlKbRAomKJDQIkdj/Uwa6bhSTq4XYNVvbk5AJ/dGwvsVdOnkMT2Ipd67KwbKfw5bqQj/cw6bj8Cp2FD4Dy4Ud4daBpPRsCyxBM2jOjVz1B/lAyrOp8BweXOXYugwdPyEn38MBZ5oL4D38jIwR/QiVnMHpERh93jtgwh9Abza6i4/zZaDAbPhtZLXSM5ztdctv8bAb63CppLU541Kf4OaLO3QLvfLRXK2n8bwEwzVAqQ22dyzt6/vPiRbZ5akh8JB6QFXG0QJF9DejsIspKF3JvOKjG2edmC9o+GfL3hwDBiihYXCGY9lElZICAdt+7rZm5UxMx7STrVKy81xcvfaIp1BwGh/HyMsJnkE8IczzRFpLlHGYuNDxdLoBjiifrmHvOCUDcV8UvhSV+UAZtAVejdNGo5G/bz0NF21HUO4pVRPu6RqZIs/aX4hlm6iO/0Ru00ct8pfadUIgRcephTuFC2fHyZxNBC6NApRtLSNLfzYTTo/uSjgcu6rLWiNo5G7yfrM45RXjalFEFzk75Z/fu9lCJJa5uLFgDNKlU+IaFjArfXJCll3apbZp4/LNKiU35ZlB7ZmjDTrji1wLep8iRVVEGht/DW00MTok7Zn7Fv+MlxgWmbZB3BuezwTmXb/fNw==");
        byte[] key = Base64.getDecoder().decode("p2PA7MGy5tx56cnyJaFZMr96BCFwZeHjZV2EqMvTq53=");

        EventResponse expectedResponse = ObjectMapperUtil.getObjectMapper().readValue("{\"products\":{\"identification\":{\"data\":{\"visitorId\":\"2ZEDCZEfOfXjEmMuE3tq\",\"requestId\":\"1703067132750.Z5hutJ\",\"browserDetails\":{\"browserName\":\"Safari\",\"browserMajorVersion\":\"17\",\"browserFullVersion\":\"17.3\",\"os\":\"Mac OS X\",\"osVersion\":\"10.15.7\",\"device\":\"Other\",\"userAgent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.3 Safari/605.1.15\"},\"incognito\":false,\"ip\":\"::1\",\"ipLocation\":{\"accuracyRadius\":1000,\"latitude\":59.3241,\"longitude\":18.0517,\"postalCode\":\"100 05\",\"timezone\":\"Europe/Stockholm\",\"city\":{\"name\":\"Stockholm\"},\"country\":{\"code\":\"SE\",\"name\":\"Sweden\"},\"continent\":{\"code\":\"EU\",\"name\":\"Europe\"},\"subdivisions\":[{\"isoCode\":\"AB\",\"name\":\"Stockholm County\"}]},\"timestamp\":1703067136286,\"time\":\"2023-12-20T10:12:16Z\",\"url\":\"http://localhost:8080/\",\"tag\":{\"foo\":\"bar\"},\"confidence\":{\"score\":1},\"visitorFound\":true,\"firstSeenAt\":{\"global\":\"2023-12-15T12:13:55.103Z\",\"subscription\":\"2023-12-15T12:13:55.103Z\"},\"lastSeenAt\":{\"global\":\"2023-12-19T11:39:51.52Z\",\"subscription\":\"2023-12-19T11:39:51.52Z\"}}},\"botd\":{\"data\":{\"bot\":{\"result\":\"notDetected\"},\"meta\":{\"foo\":\"bar\"},\"url\":\"http://localhost:8080/\",\"ip\":\"::1\",\"time\":\"2023-12-20T10:12:13.894Z\",\"userAgent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.3 Safari/605.1.15\",\"requestId\":\"1703067132750.Z5hutJ\"}}}}", EventResponse.class);

        EventResponse eventResponse = Sealed.unsealEventResponse(
                sealedResult,
                new Sealed.DecryptionKey[]{
                        new Sealed.DecryptionKey(
                                //Invalid key
                                Base64.getDecoder().decode("p2PA7MGy5tx56cnyJaFZMr96BCFwZeHjZV2EqMvTq54="),
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        ),
                        new Sealed.DecryptionKey(
                                key,
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        )
                }
        );

        assert eventResponse.equals(expectedResponse);
    }

    @Test
    public void unsealEventResponseWithInvalidHeaderTest() throws Exception {
        byte[] sealedResult = Base64.getDecoder().decode("noXc7xXO+mqeAGrvBMgObi/S0fXTpP3zupk8qFqsO/1zdtWCD169iLA3VkkZh9ICHpZ0oWRzqG0M9/TnCeKFohgBLqDp6O0zEfXOv6i5q++aucItznQdLwrKLP+O0blfb4dWVI8/aSbd4ELAZuJJxj9bCoVZ1vk+ShbUXCRZTD30OIEAr3eiG9aw00y1UZIqMgX6CkFlU9L9OnKLsNsyomPIaRHTmgVTI5kNhrnVNyNsnzt9rY7fUD52DQxJILVPrUJ1Q+qW7VyNslzGYBPG0DyYlKbRAomKJDQIkdj/Uwa6bhSTq4XYNVvbk5AJ/dGwvsVdOnkMT2Ipd67KwbKfw5bqQj/cw6bj8Cp2FD4Dy4Ud4daBpPRsCyxBM2jOjVz1B/lAyrOp8BweXOXYugwdPyEn38MBZ5oL4D38jIwR/QiVnMHpERh93jtgwh9Abza6i4/zZaDAbPhtZLXSM5ztdctv8bAb63CppLU541Kf4OaLO3QLvfLRXK2n8bwEwzVAqQ22dyzt6/vPiRbZ5akh8JB6QFXG0QJF9DejsIspKF3JvOKjG2edmC9o+GfL3hwDBiihYXCGY9lElZICAdt+7rZm5UxMx7STrVKy81xcvfaIp1BwGh/HyMsJnkE8IczzRFpLlHGYuNDxdLoBjiifrmHvOCUDcV8UvhSV+UAZtAVejdNGo5G/bz0NF21HUO4pVRPu6RqZIs/aX4hlm6iO/0Ru00ct8pfadUIgRcephTuFC2fHyZxNBC6NApRtLSNLfzYTTo/uSjgcu6rLWiNo5G7yfrM45RXjalFEFzk75Z/fu9lCJJa5uLFgDNxlU+IaFjArfXJCll3apbZp4/LNKiU35ZlB7ZmjDTrji1wLep8iRVVEGht/DW00MTok7Zn7Fv+MlxgWmbZB3BuezwTmXb/fNw==");
        byte[] key = Base64.getDecoder().decode("p2PA7MGy5tx56cnyJaFZMr96BCFwZeHjZV2EqMvTq53=");

        Exception thrown = assertThrows(Exception.class, () -> Sealed.unsealEventResponse(
                sealedResult,
                new Sealed.DecryptionKey[]{
                        new Sealed.DecryptionKey(
                                //Invalid key
                                Base64.getDecoder().decode("p2PA7MGy5tx56cnyJaFZMr96BCFwZeHjZV2EqMvTq54="),
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        ),
                        new Sealed.DecryptionKey(
                                //Invalid key
                                Base64.getDecoder().decode("aW52YWxpZA=="),
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        ),
                        new Sealed.DecryptionKey(
                                key,
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        )
                }
        ));

        assertEquals("Invalid sealed data header", thrown.getMessage());
    }

    @Test
    public void unsealEventResponseWithInvalidKeysTest() throws Exception {
        byte[] sealedResult = Base64.getDecoder().decode("noXc7SXO+mqeAGrvBMgObi/S0fXTpP3zupk8qFqsO/1zdtWCD169iLA3VkkZh9ICHpZ0oWRzqG0M9/TnCeKFohgBLqDp6O0zEfXOv6i5q++aucItznQdLwrKLP+O0blfb4dWVI8/aSbd4ELAZuJJxj9bCoVZ1vk+ShbUXCRZTD30OIEAr3eiG9aw00y1UZIqMgX6CkFlU9L9OnKLsNsyomPIaRHTmgVTI5kNhrnVNyNsnzt9rY7fUD52DQxJILVPrUJ1Q+qW7VyNslzGYBPG0DyYlKbRAomKJDQIkdj/Uwa6bhSTq4XYNVvbk5AJ/dGwvsVdOnkMT2Ipd67KwbKfw5bqQj/cw6bj8Cp2FD4Dy4Ud4daBpPRsCyxBM2jOjVz1B/lAyrOp8BweXOXYugwdPyEn38MBZ5oL4D38jIwR/QiVnMHpERh93jtgwh9Abza6i4/zZaDAbPhtZLXSM5ztdctv8bAb63CppLU541Kf4OaLO3QLvfLRXK2n8bwEwzVAqQ22dyzt6/vPiRbZ5akh8JB6QFXG0QJF9DejsIspKF3JvOKjG2edmC9o+GfL3hwDBiihYXCGY9lElZICAdt+7rZm5UxMx7STrVKy81xcvfaIp1BwGh/HyMsJnkE8IczzRFpLlHGYuNDxdLoBjiifrmHvOCUDcV8UvhSV+UAZtAVejdNGo5G/bz0NF21HUO4pVRPu6RqZIs/aX4hlm6iO/0Ru00ct8pfadUIgRcephTuFC2fHyZxNBC6NApRtLSNLfzYTTo/uSjgcu6rLWiNo5G7yfrM45RXjalFEFzk75Z/fu9lCJJa5uLFgDNKlU+IaFjArfXJCll3apbZp4/LNKiU35ZlB7ZmjDTrji1wLep8iRVVEGht/DW00MTok7Zn7Fv+MlxgWmbZB3BuezwTmXb/fNw==");

        Exception thrown = assertThrows(Exception.class, () -> Sealed.unsealEventResponse(
                sealedResult,
                new Sealed.DecryptionKey[]{
                        new Sealed.DecryptionKey(
                                //Invalid key
                                Base64.getDecoder().decode("p2PA7MGy5tx56cnyJaFZMr96BCFwZeHjZV2EqMvTq54="),
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        ),
                        new Sealed.DecryptionKey(
                                Base64.getDecoder().decode("p2PA7MGy5tx56cnyJacZMr96BCFwZeHjZV2EqMvTq54="),
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        ),
                        new Sealed.DecryptionKey(
                                Base64.getDecoder().decode("aW52YWxpZA=="),
                                Sealed.DecryptionAlgorithm.AES_256_GCM
                        )
                }
        ));

        assertEquals("Invalid decryption keys", thrown.getMessage());
    }
}
