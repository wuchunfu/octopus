package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.metrics.api.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class RuleInstanceControllerImplTest  extends WebApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/rule/";

    private List<RuleInstanceResponseDTO> create(List<RuleInstanceCreateOrUpdateRequestDTO> requestDTO) {
        String url = REST_FUNCTION_URL_PREFIX + "batchCreate";
        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<List<RuleInstanceResponseDTO>> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<List<RuleInstanceResponseDTO>>>() {});
        Assertions.assertTrue(create.isSuccess());
        List<RuleInstanceResponseDTO> createData = create.getData();
        Assertions.assertNotNull(createData);
        return createData;
    }

    private MetricsResponseDTO createMetrics(MetricsCreateOrUpdateRequestDTO requestDTO) {

        String url = "/metrics/create";

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsResponseDTO>>() {});
        Assertions.assertTrue(create.isSuccess());
        MetricsResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        return createData;
    }

    private MetricsConfigResponseDTO createMetricsConfig(MetricsConfigCreateOrUpdateRequestDTO requestDTO) {
        String url = "/metricsConfig/create";

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsConfigResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsConfigResponseDTO>>() {});
        Assertions.assertTrue(create.isSuccess());
        MetricsConfigResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        Assertions.assertNotNull(createData.getMetrics());
        return createData;
    }


    @Test
    public void testCreate() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count_instance");
        metricsCreateOrUpdateRequestDTO.setName("c_count_instance");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("Hive");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(requestDTO);

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSourceCode("sourceCode_create");
        ruleInstanceCreateOrUpdateRequestDTO.setCrontab("/5*****");
        ruleInstanceCreateOrUpdateRequestDTO.setSamplevlue("60");
        ArrayList<RuleInstanceCreateOrUpdateRequestDTO> list = new ArrayList<RuleInstanceCreateOrUpdateRequestDTO>();
        list.add(ruleInstanceCreateOrUpdateRequestDTO);
        create(list);
    }

    @Test
    public void testUpdate() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count2_instance");
        metricsCreateOrUpdateRequestDTO.setName("c_count2_instance");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("table");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(requestDTO);

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSourceCode("sourceCode_update");
        ruleInstanceCreateOrUpdateRequestDTO.setCrontab("/5*****");
        ruleInstanceCreateOrUpdateRequestDTO.setSamplevlue("60");
        ArrayList<RuleInstanceCreateOrUpdateRequestDTO> list = new ArrayList<RuleInstanceCreateOrUpdateRequestDTO>();
        list.add(ruleInstanceCreateOrUpdateRequestDTO);
        List<RuleInstanceResponseDTO> createData = create(list);

        RuleInstanceCreateOrUpdateRequestDTO updateRequestDTO = JSONUtils.parseObject(JSONUtils.toJSONString(createData.get(0)), RuleInstanceCreateOrUpdateRequestDTO.class);
        String sampleValue = "100";
        updateRequestDTO.setSamplevlue(sampleValue);
        updateRequestDTO.setSourceCode(createData.get(0).getFlowDefinition().getSourceCode());
        updateRequestDTO.setMetricsCode(metrics.getCode());
        String url = REST_FUNCTION_URL_PREFIX + "update";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(updateRequestDTO, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<RuleInstanceResponseDTO> update = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<RuleInstanceResponseDTO>>() {});
        Assertions.assertTrue(update.isSuccess());
        RuleInstanceResponseDTO data = update.getData();
        Assertions.assertEquals(sampleValue, data.getSampleInstance().getParams());
    }

    @Test
    public void testDeleteById() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count6_instance");
        metricsCreateOrUpdateRequestDTO.setName("c_count6_instance");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("table");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(requestDTO);

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSourceCode("sourceCode_delete");
        ruleInstanceCreateOrUpdateRequestDTO.setCrontab("/5*****");
        ruleInstanceCreateOrUpdateRequestDTO.setSamplevlue("60");
        ArrayList<RuleInstanceCreateOrUpdateRequestDTO> list = new ArrayList<RuleInstanceCreateOrUpdateRequestDTO>();
        list.add(ruleInstanceCreateOrUpdateRequestDTO);
        List<RuleInstanceResponseDTO> createData = create(list);

        String url = REST_FUNCTION_URL_PREFIX + createData.get(0).getId();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<ResultEntity> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, ResultEntity.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        Assertions.assertTrue(responseEntity.getBody().isSuccess());
    }

    @Test
    public void testQueryListPage() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count4_instance");
        metricsCreateOrUpdateRequestDTO.setName("c_count4_instance");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("table");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(requestDTO);

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSourceCode("sourceCode_query");
        ruleInstanceCreateOrUpdateRequestDTO.setCrontab("/5*****");
        ruleInstanceCreateOrUpdateRequestDTO.setSamplevlue("60");
        ArrayList<RuleInstanceCreateOrUpdateRequestDTO> list = new ArrayList<RuleInstanceCreateOrUpdateRequestDTO>();
        list.add(ruleInstanceCreateOrUpdateRequestDTO);
        List<RuleInstanceResponseDTO> createData = create(list);

        RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO = new RuleInstanceConditionRequestDTO();
        ruleInstanceConditionRequestDTO.setSourceCode("sourceCode_query");
        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryListPage";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("metricsCode", metrics.getCode())
                .queryParam("pageNo", 1)
                .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>>>() {
        });
        Assertions.assertTrue(result.isSuccess());
        PageResponseDTO<RuleInstanceResponseDTO> data = result.getData();
        Assertions.assertEquals(1, data.getTotal());
    }
}
