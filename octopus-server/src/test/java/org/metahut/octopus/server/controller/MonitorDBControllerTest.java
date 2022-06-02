package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.server.WebApplicationTest;
import org.metahut.octopus.server.utils.JSONUtils;

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

    @Test
    public void queryMonitorLogListPageTest() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.base + "monitorLog/queryListPage")
            .queryParam("pageNo", 1)
            .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<ResultEntity<PageResponseDTO<MonitorLogResponseDTO>>> result =
            JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<ResultEntity<PageResponseDTO<MonitorLogResponseDTO>>>>() {
            });

        Assertions.assertTrue(result.isSuccess());
        Assertions.assertNotNull(result.getData());
    }

    @Test
    public void queryMetricsResultListPage() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.base + "metricsResult/queryListPage")
            .queryParam("pageNo", 1)
            .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<ResultEntity<PageResponseDTO<MetricsResultResponseDTO>>> result =
            JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<ResultEntity<PageResponseDTO<MetricsResultResponseDTO>>>>() {
            });

        Assertions.assertTrue(result.isSuccess());
        Assertions.assertNotNull(result.getData());
    }
}
