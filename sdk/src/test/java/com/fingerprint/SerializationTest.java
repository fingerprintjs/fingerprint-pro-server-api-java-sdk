package com.fingerprint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fingerprint.model.EventResponse;
import com.fingerprint.model.RawDeviceAttributesResultValue;
import com.fingerprint.model.SignalResponseRawDeviceAttributes;
import com.fingerprint.sdk.ApiException;
import com.fingerprint.sdk.JSON;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SerializationTest {

    private InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }

    @Test
    public void serializeRawDeviceAttributesTest() throws IOException {
        ObjectMapper sdkObjectMapper = JSON.getDefault().getMapper();
        EventResponse eventResponse = sdkObjectMapper.readValue(getFileAsIOStream("mocks/get_event_200.json"), EventResponse.class);

        SignalResponseRawDeviceAttributes signalResponseRawDeviceAttributes = eventResponse.getProducts().getRawDeviceAttributes();
        String sdkResult = sdkObjectMapper.writeValueAsString(signalResponseRawDeviceAttributes);

        ObjectMapper springLikeObjectMapper = getMapper();
        String springResult = springLikeObjectMapper.writeValueAsString(signalResponseRawDeviceAttributes);

        assertTrue(sdkResult.contains("\"architecture\":{\"value\":127}"));
        assertTrue(springResult.contains("\"architecture\":{\"error\":null,\"value\":127}"));
    }
}
