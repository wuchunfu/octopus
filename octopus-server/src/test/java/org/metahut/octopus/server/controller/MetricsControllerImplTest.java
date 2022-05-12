package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public class MetricsControllerImplTest extends WebApplicationTest {

    @Test
    public void testCreate() {
        String url = "/metrics/create";
        MetricsCreateOrUpdateRequestDTO requestDTO = new MetricsCreateOrUpdateRequestDTO();
        requestDTO.setCode("count");
        requestDTO.setName("count");

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = template.postForEntity(url, httpEntity, String.class);
        Assertions.assertNotNull(responseEntity.getBody());
    }

}
