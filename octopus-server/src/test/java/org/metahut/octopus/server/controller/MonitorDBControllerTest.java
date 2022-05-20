package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.metrics.api.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Disabled
public class MonitorDBControllerTest extends WebApplicationTest {

    @Test
    public void customSQLQueryTest() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.base + "monitorDB/customSQLQuery")
            .queryParam("sql", "select * from tb_octopus_monitor_log");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<List> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<List>>() {
        });

        Assertions.assertTrue(result.isSuccess());
        Assertions.assertNotNull(result.getData());
    }
}
