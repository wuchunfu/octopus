package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.SelectItemResponseDTO;
import org.metahut.octopus.server.WebApplicationTest;
import org.metahut.octopus.server.utils.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

public class SelectItemControllerImplTest extends WebApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/selectItem/";

    @Test
    public void testQueryList() {
        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryList";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("componentNames", "METRICS_DIMENSION,SUBJECT_CATEGORY");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<Map<String, List<SelectItemResponseDTO>>> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<Map<String, List<SelectItemResponseDTO>>>>() {
        });
        Assertions.assertTrue(result.isSuccess());
    }

}
