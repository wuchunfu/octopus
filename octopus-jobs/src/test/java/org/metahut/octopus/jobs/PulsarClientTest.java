package org.metahut.octopus.jobs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class PulsarClientTest {

    public static final String metricsMessageFile = "";

    public static final ObjectMapper objectMapper = new ObjectMapper();

    static Stream<String> metricsDataProvider() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(PulsarClientTest.class.getResourceAsStream(metricsMessageFile)));
        return bufferedReader.lines();
        // return objectMapper.readValue(PulsarClientTest.class.getResourceAsStream(metricsMessageFile), String.class);
    }

    @ParameterizedTest
    @MethodSource("metricsDataProvider")
    public void sendMetricMessagesTest(String message) {

    }

}
