package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.SampleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.common.enums.RuleStateEnum;
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

import java.util.Arrays;

public class MonitorFlowDefinitionControllerImplTest extends WebApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/monitorFlowDefinition/";

    /**
     * create metrics
     *
     * @param requestDTO
     * @return
     */
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

    private AlerterSourceResponseDTO createAlertInstance(AlerterSourceCreateOrUpdateRequestDTO requestDTO) {
        String url = "/alerterSource/create";

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<AlerterSourceResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<AlerterSourceResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        AlerterSourceResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        return createData;
    }

    private MonitorFlowDefinitionResponseDTO create(MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO) {

        String url = REST_FUNCTION_URL_PREFIX + "create";
        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MonitorFlowDefinitionResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MonitorFlowDefinitionResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        MonitorFlowDefinitionResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        return createData;

    }

    @Test
    public void create() {
        AlerterSourceCreateOrUpdateRequestDTO alerterSourceCreateOrUpdateRequestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        alerterSourceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterSourceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterSourceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterSourceResponseDTO alertInstance = createAlertInstance(alerterSourceCreateOrUpdateRequestDTO);

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("sum");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("test");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        metricsConfigCreateOrUpdateRequestDTO.setDescription("test");
        metricsConfigCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        metricsConfigCreateOrUpdateRequestDTO.setMetricsParams("{\"subjectCategory\": \"\",\"subjectCode\":  \"\", \"metricsCode\": \"sum\", \"filter\":\"\"}");
        metricsConfigCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        metricsConfigCreateOrUpdateRequestDTO.setSourceCategory("sourceCategory");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(metricsConfigCreateOrUpdateRequestDTO);

        MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO = new MonitorFlowDefinitionCreateOrUpdateRequestDTO();

        AlerterInstanceCreateOrUpdateRequestDTO alerterInstanceCreateOrUpdateRequestDTO = new AlerterInstanceCreateOrUpdateRequestDTO();
        alerterInstanceCreateOrUpdateRequestDTO.setAlerterSourceCode(alertInstance.getCode());
        alerterInstanceCreateOrUpdateRequestDTO.setParameter("phone");
        requestDTO.setAlerterInstances(Arrays.asList(alerterInstanceCreateOrUpdateRequestDTO));
        requestDTO.setCrontab("crontab");
        requestDTO.setDatasetCode("dataset");

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSample(true);
        ruleInstanceCreateOrUpdateRequestDTO.setState(RuleStateEnum.OFFLINE);
        ruleInstanceCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setRuleInstances(Arrays.asList(ruleInstanceCreateOrUpdateRequestDTO));

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset");
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);
    }

    @Test
    public void testUpdate() {
        AlerterSourceCreateOrUpdateRequestDTO alerterSourceCreateOrUpdateRequestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        alerterSourceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterSourceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterSourceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterSourceResponseDTO alertInstance = createAlertInstance(alerterSourceCreateOrUpdateRequestDTO);

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("sum4");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("test");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        metricsConfigCreateOrUpdateRequestDTO.setDescription("test");
        metricsConfigCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        metricsConfigCreateOrUpdateRequestDTO.setMetricsParams("{\"subjectCategory\": \"\",\"subjectCode\":  \"\", \"metricsCode\": \"sum\", \"filter\":\"\"}");
        metricsConfigCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        metricsConfigCreateOrUpdateRequestDTO.setSourceCategory("sourceCategory");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(metricsConfigCreateOrUpdateRequestDTO);

        MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO = new MonitorFlowDefinitionCreateOrUpdateRequestDTO();

        AlerterInstanceCreateOrUpdateRequestDTO alerterInstanceCreateOrUpdateRequestDTO = new AlerterInstanceCreateOrUpdateRequestDTO();
        alerterInstanceCreateOrUpdateRequestDTO.setAlerterSourceCode(alertInstance.getCode());
        alerterInstanceCreateOrUpdateRequestDTO.setParameter("phone");
        requestDTO.setAlerterInstances(Arrays.asList(alerterInstanceCreateOrUpdateRequestDTO));
        requestDTO.setCrontab("crontab");
        requestDTO.setDatasetCode("dataset4");

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSample(true);
        ruleInstanceCreateOrUpdateRequestDTO.setState(RuleStateEnum.OFFLINE);
        ruleInstanceCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setRuleInstances(Arrays.asList(ruleInstanceCreateOrUpdateRequestDTO));

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset4");
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);

        MonitorFlowDefinitionCreateOrUpdateRequestDTO updateDTO = JSONUtils.parseObject(JSONUtils.toJSONString(monitorFlowDefinitionResponseDTO), MonitorFlowDefinitionCreateOrUpdateRequestDTO.class);
        updateDTO.setDatasetCode("dataset4");
        updateDTO.getAlerterInstances().forEach(i -> {
            i.setAlerterSourceCode(alertInstance.getCode());
            i.setParameter("phone");
        });
        updateDTO.getRuleInstances().forEach(i -> {
            i.setMetricsCode(metrics.getCode());
            i.setMetricsConfigCode(metricsConfig.getCode());
            i.setSample(true);
            i.setState(RuleStateEnum.OFFLINE);
            i.setSubjectCategory(SubjectCategoryEnum.TABLE);
        });
        String sampleValue = "100";
        updateDTO.getSampleInstance().setParameter(sampleValue);
        String url = REST_FUNCTION_URL_PREFIX + "update";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(updateDTO, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MonitorFlowDefinitionResponseDTO> update = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MonitorFlowDefinitionResponseDTO>>() {
        });
        Assertions.assertTrue(update.isSuccess());
        MonitorFlowDefinitionResponseDTO data = update.getData();
        Assertions.assertEquals(sampleValue, data.getSampleInstance().getParameter());
    }

    @Test
    public void testQuery() {
        AlerterSourceCreateOrUpdateRequestDTO alerterSourceCreateOrUpdateRequestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        alerterSourceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterSourceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterSourceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterSourceResponseDTO alertInstance = createAlertInstance(alerterSourceCreateOrUpdateRequestDTO);

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("sum5");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("test");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        metricsConfigCreateOrUpdateRequestDTO.setDescription("test");
        metricsConfigCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        metricsConfigCreateOrUpdateRequestDTO.setMetricsParams("{\"subjectCategory\": \"\",\"subjectCode\":  \"\", \"metricsCode\": \"sum\", \"filter\":\"\"}");
        metricsConfigCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        metricsConfigCreateOrUpdateRequestDTO.setSourceCategory("sourceCategory");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(metricsConfigCreateOrUpdateRequestDTO);

        MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO = new MonitorFlowDefinitionCreateOrUpdateRequestDTO();

        AlerterInstanceCreateOrUpdateRequestDTO alerterInstanceCreateOrUpdateRequestDTO = new AlerterInstanceCreateOrUpdateRequestDTO();
        alerterInstanceCreateOrUpdateRequestDTO.setAlerterSourceCode(alertInstance.getCode());
        alerterInstanceCreateOrUpdateRequestDTO.setParameter("phone");
        requestDTO.setAlerterInstances(Arrays.asList(alerterInstanceCreateOrUpdateRequestDTO));
        requestDTO.setCrontab("crontab");
        requestDTO.setDatasetCode("dataset5");

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSample(true);
        ruleInstanceCreateOrUpdateRequestDTO.setState(RuleStateEnum.OFFLINE);
        ruleInstanceCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setRuleInstances(Arrays.asList(ruleInstanceCreateOrUpdateRequestDTO));

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset5");
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);

        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryListPage";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("datasetCode", "dataset5")
            .queryParam("pageNo", 1)
            .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<PageResponseDTO<MonitorFlowDefinitionResponseDTO>> result = JSONUtils.parseObject(responseEntity.getBody(),
            new TypeReference<ResultEntity<PageResponseDTO<MonitorFlowDefinitionResponseDTO>>>() {
            });
        Assertions.assertTrue(result.isSuccess());
        PageResponseDTO<MonitorFlowDefinitionResponseDTO> data = result.getData();
        Assertions.assertEquals(1, data.getTotal());
    }

    @Test
    public void deleteById() {
        AlerterSourceCreateOrUpdateRequestDTO alerterSourceCreateOrUpdateRequestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        alerterSourceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterSourceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterSourceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterSourceResponseDTO alertInstance = createAlertInstance(alerterSourceCreateOrUpdateRequestDTO);

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("sum6");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("test");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        metricsConfigCreateOrUpdateRequestDTO.setDescription("test");
        metricsConfigCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        metricsConfigCreateOrUpdateRequestDTO.setMetricsParams("{\"subjectCategory\": \"\",\"subjectCode\":  \"\", \"metricsCode\": \"sum\", \"filter\":\"\"}");
        metricsConfigCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        metricsConfigCreateOrUpdateRequestDTO.setSourceCategory("sourceCategory");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(metricsConfigCreateOrUpdateRequestDTO);

        MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO = new MonitorFlowDefinitionCreateOrUpdateRequestDTO();

        AlerterInstanceCreateOrUpdateRequestDTO alerterInstanceCreateOrUpdateRequestDTO = new AlerterInstanceCreateOrUpdateRequestDTO();
        alerterInstanceCreateOrUpdateRequestDTO.setAlerterSourceCode(alertInstance.getCode());
        alerterInstanceCreateOrUpdateRequestDTO.setParameter("phone");
        requestDTO.setAlerterInstances(Arrays.asList(alerterInstanceCreateOrUpdateRequestDTO));
        requestDTO.setCrontab("crontab");
        requestDTO.setDatasetCode("dataset6");

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSample(true);
        ruleInstanceCreateOrUpdateRequestDTO.setState(RuleStateEnum.OFFLINE);
        ruleInstanceCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setRuleInstances(Arrays.asList(ruleInstanceCreateOrUpdateRequestDTO));

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset6");
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);

        String url = REST_FUNCTION_URL_PREFIX + monitorFlowDefinitionResponseDTO.getId();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<ResultEntity> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, ResultEntity.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        Assertions.assertTrue(responseEntity.getBody().isSuccess());
    }
}
