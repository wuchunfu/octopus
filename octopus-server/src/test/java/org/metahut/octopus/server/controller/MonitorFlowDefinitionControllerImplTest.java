package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
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
import org.metahut.octopus.api.dto.SourceAlertRelationCreateOrUpdateRequestDTO;
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

import java.util.ArrayList;
import java.util.List;

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

    private AlerterInstanceResponseDTO createAlertInstance(AlerterInstanceCreateOrUpdateRequestDTO requestDTO) {
        String url = "/alerter/create";

        HttpEntity httpEntity = new HttpEntity(requestDTO);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<AlerterInstanceResponseDTO> create = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<AlerterInstanceResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        AlerterInstanceResponseDTO createData = create.getData();
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

        // create alerter instance
        AlerterInstanceCreateOrUpdateRequestDTO alerterInstanceCreateOrUpdateRequestDTO = new AlerterInstanceCreateOrUpdateRequestDTO();
        alerterInstanceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterInstanceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterInstanceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterInstanceResponseDTO alertInstance = createAlertInstance(alerterInstanceCreateOrUpdateRequestDTO);

        String sourceCode = "X01";
        MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO = new MonitorFlowDefinitionCreateOrUpdateRequestDTO();
        requestDTO.setDatasetCode(sourceCode);
        requestDTO.setCrontab("0 0 1 * * ?");

        // create source alerter instance relation
        List<SourceAlertRelationCreateOrUpdateRequestDTO> sourceAlertRelations = new ArrayList<>();
        SourceAlertRelationCreateOrUpdateRequestDTO sourceAlertRelationCreateOrUpdateRequestDTO = new SourceAlertRelationCreateOrUpdateRequestDTO();
        sourceAlertRelationCreateOrUpdateRequestDTO.setDatasetCode(sourceCode);
        sourceAlertRelationCreateOrUpdateRequestDTO.setAlertInstanceCode(alertInstance.getCode());
        sourceAlertRelations.add(sourceAlertRelationCreateOrUpdateRequestDTO);
        requestDTO.setSourceAlertRelations(sourceAlertRelations);

        List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstanceCreateOrUpdateRequestDTOS = new ArrayList<>();
        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO1 = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO1.setCheckType("数值型");
        ruleInstanceCreateOrUpdateRequestDTOS.add(ruleInstanceCreateOrUpdateRequestDTO1);
        requestDTO.setRuleInstances(ruleInstanceCreateOrUpdateRequestDTOS);

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("100");
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode(sourceCode);
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);

        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);
    }

    @Test
    public void testUpdate() {
        AlerterInstanceCreateOrUpdateRequestDTO alerterInstanceCreateOrUpdateRequestDTO = new AlerterInstanceCreateOrUpdateRequestDTO();
        alerterInstanceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterInstanceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterInstanceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterInstanceResponseDTO alertInstance = createAlertInstance(alerterInstanceCreateOrUpdateRequestDTO);

        String sourceCode = "X02";
        MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO = new MonitorFlowDefinitionCreateOrUpdateRequestDTO();
        requestDTO.setDatasetCode(sourceCode);
        requestDTO.setCrontab("0 0 1 * * ?");

        List<SourceAlertRelationCreateOrUpdateRequestDTO> sourceAlertRelations = new ArrayList<>();
        SourceAlertRelationCreateOrUpdateRequestDTO sourceAlertRelationCreateOrUpdateRequestDTO = new SourceAlertRelationCreateOrUpdateRequestDTO();
        sourceAlertRelationCreateOrUpdateRequestDTO.setDatasetCode(sourceCode);
        sourceAlertRelationCreateOrUpdateRequestDTO.setAlertInstanceCode(alertInstance.getCode());
        sourceAlertRelations.add(sourceAlertRelationCreateOrUpdateRequestDTO);
        requestDTO.setSourceAlertRelations(sourceAlertRelations);

        List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstanceCreateOrUpdateRequestDTOS = new ArrayList<>();
        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO1 = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO1.setCheckType("数值型");
        ruleInstanceCreateOrUpdateRequestDTOS.add(ruleInstanceCreateOrUpdateRequestDTO1);
        requestDTO.setRuleInstances(ruleInstanceCreateOrUpdateRequestDTOS);

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("100");
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode(sourceCode);
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);

        MonitorFlowDefinitionCreateOrUpdateRequestDTO updateDTO = JSONUtils.parseObject(JSONUtils.toJSONString(monitorFlowDefinitionResponseDTO), MonitorFlowDefinitionCreateOrUpdateRequestDTO.class);
        updateDTO.setDatasetCode(sourceCode);
        String sampleValue = "90";
        updateDTO.getSampleInstance().setParameter(sampleValue);
        String url = REST_FUNCTION_URL_PREFIX + "update";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(updateDTO, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<MonitorFlowDefinitionResponseDTO> update = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<MonitorFlowDefinitionResponseDTO>>() {});
        Assertions.assertTrue(update.isSuccess());
        MonitorFlowDefinitionResponseDTO data = update.getData();
        Assertions.assertEquals(sampleValue, data.getSampleInstance().getParameter());
    }

    @Test
    public void testQuery() {
        AlerterInstanceCreateOrUpdateRequestDTO alerterInstanceCreateOrUpdateRequestDTO = new AlerterInstanceCreateOrUpdateRequestDTO();
        alerterInstanceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterInstanceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterInstanceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterInstanceResponseDTO alertInstance = createAlertInstance(alerterInstanceCreateOrUpdateRequestDTO);

        String sourceCode = "X03";
        MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO = new MonitorFlowDefinitionCreateOrUpdateRequestDTO();
        requestDTO.setDatasetCode(sourceCode);
        requestDTO.setCrontab("0 0 1 * * ?");

        List<SourceAlertRelationCreateOrUpdateRequestDTO> sourceAlertRelations = new ArrayList<>();
        SourceAlertRelationCreateOrUpdateRequestDTO sourceAlertRelationCreateOrUpdateRequestDTO = new SourceAlertRelationCreateOrUpdateRequestDTO();
        sourceAlertRelationCreateOrUpdateRequestDTO.setDatasetCode(sourceCode);
        sourceAlertRelationCreateOrUpdateRequestDTO.setAlertInstanceCode(alertInstance.getCode());
        sourceAlertRelations.add(sourceAlertRelationCreateOrUpdateRequestDTO);
        requestDTO.setSourceAlertRelations(sourceAlertRelations);

        List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstanceCreateOrUpdateRequestDTOS = new ArrayList<>();
        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO1 = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO1.setCheckType("数值型");
        ruleInstanceCreateOrUpdateRequestDTOS.add(ruleInstanceCreateOrUpdateRequestDTO1);
        requestDTO.setRuleInstances(ruleInstanceCreateOrUpdateRequestDTOS);

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("100");
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode(sourceCode);
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);

        String url = this.base + REST_FUNCTION_URL_PREFIX + "queryListPage";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("datasetCode", sourceCode)
                .queryParam("pageNo", 1)
                .queryParam("pageSize", 10);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        ResultEntity<PageResponseDTO<MonitorFlowDefinitionResponseDTO>> result = JSONUtils.parseObject(responseEntity.getBody(), new TypeReference<ResultEntity<PageResponseDTO<MonitorFlowDefinitionResponseDTO>>>() {
        });
        Assertions.assertTrue(result.isSuccess());
        PageResponseDTO<MonitorFlowDefinitionResponseDTO> data = result.getData();
        Assertions.assertEquals(1, data.getTotal());
    }

    @Test
    public void deleteById() {
        AlerterInstanceCreateOrUpdateRequestDTO alerterInstanceCreateOrUpdateRequestDTO = new AlerterInstanceCreateOrUpdateRequestDTO();
        alerterInstanceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterInstanceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterInstanceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterInstanceResponseDTO alertInstance = createAlertInstance(alerterInstanceCreateOrUpdateRequestDTO);

        String sourceCode = "X04";
        MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO = new MonitorFlowDefinitionCreateOrUpdateRequestDTO();
        requestDTO.setDatasetCode(sourceCode);
        requestDTO.setCrontab("0 0 1 * * ?");

        List<SourceAlertRelationCreateOrUpdateRequestDTO> sourceAlertRelations = new ArrayList<>();
        SourceAlertRelationCreateOrUpdateRequestDTO sourceAlertRelationCreateOrUpdateRequestDTO = new SourceAlertRelationCreateOrUpdateRequestDTO();
        sourceAlertRelationCreateOrUpdateRequestDTO.setDatasetCode(sourceCode);
        sourceAlertRelationCreateOrUpdateRequestDTO.setAlertInstanceCode(alertInstance.getCode());
        sourceAlertRelations.add(sourceAlertRelationCreateOrUpdateRequestDTO);
        requestDTO.setSourceAlertRelations(sourceAlertRelations);

        List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstanceCreateOrUpdateRequestDTOS = new ArrayList<>();
        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO1 = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO1.setCheckType("数值型");
        ruleInstanceCreateOrUpdateRequestDTOS.add(ruleInstanceCreateOrUpdateRequestDTO1);
        requestDTO.setRuleInstances(ruleInstanceCreateOrUpdateRequestDTOS);

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("100");
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode(sourceCode);
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
