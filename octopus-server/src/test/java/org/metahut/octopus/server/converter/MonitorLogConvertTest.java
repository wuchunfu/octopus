package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.monitordb.api.MonitorLogRequest;
import org.metahut.octopus.server.WebApplicationTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import java.util.StringJoiner;

public class MonitorLogConvertTest extends WebApplicationTest {

    @Autowired
    private ConversionService conversionService;

    @Test
    public void testMonitorLogConditionsToDBRequest() {
        String metricsCode = "count";
        MonitorLogConditionsRequestDTO requestDTO = new MonitorLogConditionsRequestDTO();
        requestDTO.setError(true);
        requestDTO.setMetricsCode(metricsCode);
        MonitorLogRequest convert = conversionService.convert(requestDTO, MonitorLogRequest.class);
        Assertions.assertNotNull(convert);
        Assertions.assertEquals(metricsCode, convert.getMetricsCode());
    }

    @Test
    public void testStringJoin() {
        String str = null;
        StringJoiner joiner = new StringJoiner("_");
        joiner.add("1");
        joiner.add(str);
        joiner.add("2");
        Assertions.assertEquals("1_null_2", joiner.toString());
    }
}
