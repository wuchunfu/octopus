package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceSingleCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.SampleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.metrics.api.JSONUtils;
import org.metahut.octopus.server.WebApplicationTest;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;

public class RuleInstanceControllerImplTest extends WebApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/ruleInstance/";

    private RuleInstanceResponseDTO create(RuleInstanceSingleCreateOrUpdateRequestDTO requestDTO) {
        String url = REST_FUNCTION_URL_PREFIX + "create";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(requestDTO, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<RuleInstanceResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<RuleInstanceResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        RuleInstanceResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData);
        return createData;
    }

    private MetricsResponseDTO createMetrics(MetricsCreateOrUpdateRequestDTO requestDTO) {

        String url = "/metrics/create";
        requestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        MetricsResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        return createData;
    }

    private MetricsConfigResponseDTO createMetricsConfig(MetricsConfigCreateOrUpdateRequestDTO requestDTO) {
        String url = "/metricsConfig/create";
        requestDTO.setCode(100L);
        requestDTO.setMetricsParams("{\"executorScript\":\"test\",\"executorType\":\"Flink\"}");
        requestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MetricsConfigResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MetricsConfigResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        MetricsConfigResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        Assertions.assertNotNull(createData.getMetrics());
        return createData;
    }

    @Test
    public void testCreate() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count_instance6");
        metricsCreateOrUpdateRequestDTO.setName("c_count_instance");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("Hive");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(requestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO ruleInstanceSingleCreateOrUpdateRequestDTO = new RuleInstanceSingleCreateOrUpdateRequestDTO();
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckMethod("checkMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckType("checkType");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setComparisonMethod("comparisonMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setExpectedValue("expectedValue");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCode("subjectCode");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSampleCode(5714046032257L);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setDatasetCode("datasetCode0601");
        RuleInstanceResponseDTO ruleInstanceResponseDTOS = create(ruleInstanceSingleCreateOrUpdateRequestDTO);
    }

    @Test
    public void testUpdate() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count_instance8");
        metricsCreateOrUpdateRequestDTO.setName("c_count_instance");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("Hive");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(requestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO ruleInstanceSingleCreateOrUpdateRequestDTO = new RuleInstanceSingleCreateOrUpdateRequestDTO();
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckMethod("checkMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckType("checkType");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setComparisonMethod("comparisonMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setExpectedValue("expectedValue");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCode("subjectCode");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSampleCode(5714046032257L);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setDatasetCode("datasetCode0601");
        RuleInstanceResponseDTO ruleInstanceResponseDTOS = create(ruleInstanceSingleCreateOrUpdateRequestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO updateRequestDTO = JSONUtils.parseObject(JSONUtils.toJSONString(ruleInstanceResponseDTOS), RuleInstanceSingleCreateOrUpdateRequestDTO.class);
        String checkMethod = "checkMethod-update";
        updateRequestDTO.setCheckMethod(checkMethod);
        updateRequestDTO.setMetricsCode(metrics.getCode());
        updateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        updateRequestDTO.setSampleCode(5714046032257L);
        String url = REST_FUNCTION_URL_PREFIX + "update";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(updateRequestDTO, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<RuleInstanceResponseDTO> update = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<RuleInstanceResponseDTO>>() {
        });
        Assertions.assertTrue(update.isSuccess());
        RuleInstanceResponseDTO data = update.getData();
        Assertions.assertEquals(checkMethod, data.getCheckMethod());
    }

    @Test
    public void testDeleteById() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count_instance10");
        metricsCreateOrUpdateRequestDTO.setName("c_count_instance");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("Hive");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(requestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO ruleInstanceSingleCreateOrUpdateRequestDTO = new RuleInstanceSingleCreateOrUpdateRequestDTO();
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckMethod("checkMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckType("checkType");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setComparisonMethod("comparisonMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setExpectedValue("expectedValue");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCode("subjectCode");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSampleCode(5714046032257L);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setDatasetCode("datasetCode0601");
        RuleInstanceResponseDTO ruleInstanceResponseDTOS = create(ruleInstanceSingleCreateOrUpdateRequestDTO);

        String url = REST_FUNCTION_URL_PREFIX + ruleInstanceResponseDTOS.getId();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<ResultEntity> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, ResultEntity.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        Assertions.assertTrue(responseEntity.getBody().isSuccess());
    }

    @Test
    public void testQueryListPage() {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count_instance11");
        metricsCreateOrUpdateRequestDTO.setName("c_count_instance");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("Hive");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(requestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO ruleInstanceSingleCreateOrUpdateRequestDTO = new RuleInstanceSingleCreateOrUpdateRequestDTO();
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckMethod("checkMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckType("checkType");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setComparisonMethod("comparisonMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setExpectedValue("expectedValue");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCode("subjectCode");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSampleCode(5714046032257L);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setDatasetCode("datasetCode06");
        RuleInstanceResponseDTO ruleInstanceResponseDTOS = create(ruleInstanceSingleCreateOrUpdateRequestDTO);

        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryListPage";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("datasetCode", "datasetCode06")
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
