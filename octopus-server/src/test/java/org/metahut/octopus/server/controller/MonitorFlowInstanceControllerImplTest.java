package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MonitorFlowInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.metrics.api.JSONUtils;
import org.metahut.octopus.server.WebApplicationTest;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class MonitorFlowInstanceControllerImplTest extends WebApplicationTest {

    @Test
    public void queryListPageTest() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.base + "monitorFlowInstance/queryListPage")
            .queryParam("pageNo", 1)
            .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

        ResultEntity<PageResponseDTO<MonitorFlowInstanceResponseDTO>> result =
            JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<PageResponseDTO<MonitorFlowInstanceResponseDTO>>>() {
            });

        Assertions.assertTrue(result.isSuccess());
        //Assertions.assertNotNull(result.getData());
    }
}
