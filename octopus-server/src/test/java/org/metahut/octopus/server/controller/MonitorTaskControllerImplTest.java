package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.FlowDefinitionCreateRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.metrics.api.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class MonitorTaskControllerImplTest extends WebApplicationTest {

    private MonitorTaskResponseDTO create() {
        FlowDefinitionCreateRequestDTO createRequest = new FlowDefinitionCreateRequestDTO();
        createRequest.setEnv("dev");
        createRequest.setSourceCode("1");
        createRequest.setCrontab("0 0 7-23 * * ?");
        createRequest.setSchedulerCode("1");
        HttpEntity httpEntity = new HttpEntity(createRequest);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(this.base + "monitorTask/create", httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MonitorTaskResponseDTO> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MonitorTaskResponseDTO>>() {
        });
        Assertions.assertTrue(result.isSuccess());
        return result.getData();
    }

    @Test
    public void queryByIdTest() {
        MonitorTaskResponseDTO responseDTO = create();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.base + "monitorTask/queryById")
            .queryParam("id", responseDTO.getId());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

        ResultEntity<MonitorTaskResponseDTO> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MonitorTaskResponseDTO>>() {
        });
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertNotNull(result.getData());
        Assertions.assertEquals(result.getData().getId(), responseDTO.getId());
    }

    @Test
    public void queryListPageTest() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.base + "monitorTask/queryListPage")
            .queryParam("pageNo", 1)
            .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

        ResultEntity<MonitorTaskResponseDTO> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MonitorTaskResponseDTO>>() {
        });
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertNotNull(result.getData());
    }
}
