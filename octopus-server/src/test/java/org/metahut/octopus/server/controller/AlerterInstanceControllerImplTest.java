package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.metrics.api.JSONUtils;
import org.metahut.octopus.server.WebApplicationTest;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public class AlerterInstanceControllerImplTest extends WebApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/alerter/";

    protected AlerterInstanceResponseDTO create(AlerterInstanceCreateOrUpdateRequestDTO requestDTO) {
        String url = REST_FUNCTION_URL_PREFIX + "create";

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<AlerterInstanceResponseDTO> data = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<AlerterInstanceResponseDTO>>() {
        });
        Assertions.assertTrue(data.isSuccess());
        AlerterInstanceResponseDTO responseDTO = data.getData();
        Assertions.assertNotNull(responseDTO.getId());
        return responseDTO;
    }

    @Test
    public void testCreate() {
        AlerterInstanceCreateOrUpdateRequestDTO requestDTO = new AlerterInstanceCreateOrUpdateRequestDTO();
        requestDTO.setAlertType("DingTalk");
        requestDTO.setName("dingTalk test");
        requestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        create(requestDTO);
    }

}
