package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
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
import org.metahut.octopus.api.dto.UserResponseDTO;
import org.metahut.octopus.common.entity.DateTimeFieldConfig;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.common.enums.RuleStateEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.enums.WindowType;
import org.metahut.octopus.common.enums.WindowUnit;
import org.metahut.octopus.common.utils.JSONUtils;
import org.metahut.octopus.server.WebMvcApplicationTest;
import org.metahut.octopus.server.service.MetaService;
import org.metahut.octopus.server.service.SchedulerService;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MonitorFlowDefinitionControllerImplTest extends WebMvcApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/monitorFlowDefinition/";

    @MockBean
    private SchedulerService schedulerService;

    @MockBean
    private MetaService metaService;

    /**
     * create metrics
     *
     * @param requestDTO
     * @return
     */
    private MetricsResponseDTO createMetrics(MetricsCreateOrUpdateRequestDTO requestDTO) throws Exception {
        String url = "/metrics/create";
        requestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        MvcResult mvcResult = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(requestDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<MetricsResponseDTO> create = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetricsResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        MetricsResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        return createData;
    }

    private MetricsConfigResponseDTO createMetricsConfig(MetricsConfigCreateOrUpdateRequestDTO requestDTO) throws Exception {
        String url = "/metricsConfig/create";
        MvcResult mvcResult = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(requestDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<MetricsConfigResponseDTO> create = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetricsConfigResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        MetricsConfigResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        Assertions.assertNotNull(createData.getMetrics());
        return createData;
    }

    private AlerterSourceResponseDTO createAlertInstance(AlerterSourceCreateOrUpdateRequestDTO requestDTO) throws Exception {
        String url = "/alerterSource/create";
        MvcResult mvcResult = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(requestDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<AlerterSourceResponseDTO> create = JSONUtils.parseObject(result, new TypeReference<ResultEntity<AlerterSourceResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        AlerterSourceResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        return createData;
    }

    private MonitorFlowDefinitionResponseDTO create(MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO) throws Exception {
        if (StringUtils.isEmpty(requestDTO.getDatasourceCode())) {
            requestDTO.setDatasourceCode("123321");
        }
        MetaDatasourceResponseDTO metaDatasourceResponseDTO = new MetaDatasourceResponseDTO();
        metaDatasourceResponseDTO.setCode("123");
        MetaDatasetResponseDTO metaDatasetResponseDTO = new MetaDatasetResponseDTO();
        metaDatasetResponseDTO.setDatasource(metaDatasourceResponseDTO);
        given(this.metaService.queryDatasetByCode(Mockito.any(String.class))).willReturn(metaDatasetResponseDTO);

        String schedulerCode = "456";
        given(this.schedulerService.createMetricsProductionTaskAndAddSchedule(Mockito.any(String.class), Mockito.any(Long.class), Mockito.any(String.class)))
                .willReturn(schedulerCode);

        String url = REST_FUNCTION_URL_PREFIX + "create";
        MvcResult mvcResult = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(requestDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<MonitorFlowDefinitionResponseDTO> create = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MonitorFlowDefinitionResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        MonitorFlowDefinitionResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        return createData;
    }

    private List<MonitorFlowDefinitionResponseDTO> batchCreate(List<MonitorFlowDefinitionCreateOrUpdateRequestDTO> requestDTOs) throws Exception {
        MetaDatasourceResponseDTO metaDatasourceResponseDTO = new MetaDatasourceResponseDTO();
        metaDatasourceResponseDTO.setCode("123");
        MetaDatasetResponseDTO metaDatasetResponseDTO = new MetaDatasetResponseDTO();
        metaDatasetResponseDTO.setDatasource(metaDatasourceResponseDTO);
        given(this.metaService.queryDatasetByCode(Mockito.any(String.class))).willReturn(metaDatasetResponseDTO);

        String schedulerCode = "456";
        given(this.schedulerService.createMetricsProductionTaskAndAddSchedule(Mockito.any(String.class), Mockito.any(Long.class), Mockito.any(String.class)))
                .willReturn(schedulerCode);

        String url = REST_FUNCTION_URL_PREFIX + "batchCreate";
        MvcResult mvcResult = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(requestDTOs)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<List<MonitorFlowDefinitionResponseDTO>> create = JSONUtils.parseObject(result, new TypeReference<ResultEntity<List<MonitorFlowDefinitionResponseDTO>>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        List<MonitorFlowDefinitionResponseDTO> createData = create.getData();
        Assertions.assertNotNull(createData);
        return createData;
    }

    @Test
    public void create() throws Exception {
        AlerterSourceCreateOrUpdateRequestDTO alerterSourceCreateOrUpdateRequestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        alerterSourceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterSourceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterSourceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterSourceResponseDTO alertInstance = createAlertInstance(alerterSourceCreateOrUpdateRequestDTO);

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("sum66");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("test66");
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
        alerterInstanceCreateOrUpdateRequestDTO.setAlerterType("DingTalk");
        UserResponseDTO user = new UserResponseDTO();
        user.setId(1);
        user.setCode(1L);
        user.setName("xiaoliang.wang");
        user.setCnName("wxl");
        user.setEmail("xiaoliang.wang@zhaopin.com");
        user.setPhoneNumber("15210284595");
        alerterInstanceCreateOrUpdateRequestDTO.setUsers(Arrays.asList(user));
        requestDTO.setAlerterInstances(Arrays.asList(alerterInstanceCreateOrUpdateRequestDTO));
        requestDTO.setCrontab("crontab");
        requestDTO.setDatasetCode("dataset66");
        requestDTO.setDatabaseCode("databaseCode");

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSample(true);
        ruleInstanceCreateOrUpdateRequestDTO.setState(RuleStateEnum.OFFLINE);
        ruleInstanceCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setRuleInstances(Arrays.asList(ruleInstanceCreateOrUpdateRequestDTO));

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset66");
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);

        DateTimeFieldConfig dateTimeFieldConfig = new DateTimeFieldConfig();
        dateTimeFieldConfig.setName("dt");
        dateTimeFieldConfig.setFormat("yyyy-MM-dd");

        requestDTO.setWindowSize("20");
        requestDTO.setWindowType(WindowType.TUMBLE);
        requestDTO.setWindowUnit(WindowUnit.MINUTE);
        requestDTO.setDateTimeFields(Arrays.asList(dateTimeFieldConfig));
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);
    }

    @Test
    public void batchCreate() throws Exception {
        AlerterSourceCreateOrUpdateRequestDTO alerterSourceCreateOrUpdateRequestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        alerterSourceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterSourceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterSourceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterSourceResponseDTO alertInstance = createAlertInstance(alerterSourceCreateOrUpdateRequestDTO);

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("sum67");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("test1-67");
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
        requestDTO.setDatasetCode("dataset67");
        requestDTO.setDatabaseCode("databaseCode");

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSample(true);
        ruleInstanceCreateOrUpdateRequestDTO.setState(RuleStateEnum.OFFLINE);
        ruleInstanceCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setRuleInstances(Arrays.asList(ruleInstanceCreateOrUpdateRequestDTO));

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset67");
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);

        DateTimeFieldConfig dateTimeFieldConfig = new DateTimeFieldConfig();
        dateTimeFieldConfig.setName("dt");
        dateTimeFieldConfig.setFormat("yyyy-MM-dd");

        requestDTO.setWindowSize("20");
        requestDTO.setWindowType(WindowType.TUMBLE);
        requestDTO.setWindowUnit(WindowUnit.MINUTE);
        requestDTO.setDateTimeFields(Arrays.asList(dateTimeFieldConfig));
        List<MonitorFlowDefinitionResponseDTO> monitorFlowDefinitionResponseDTO = batchCreate(Arrays.asList(requestDTO));
    }

    @Test
    public void testUpdate() throws Exception {
        AlerterSourceCreateOrUpdateRequestDTO alerterSourceCreateOrUpdateRequestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        alerterSourceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterSourceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterSourceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterSourceResponseDTO alertInstance = createAlertInstance(alerterSourceCreateOrUpdateRequestDTO);

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("sum76");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("test2");
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
        requestDTO.setDatasetCode("dataset76");
        requestDTO.setDatabaseCode("databaseCode");
        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSample(true);
        ruleInstanceCreateOrUpdateRequestDTO.setState(RuleStateEnum.OFFLINE);
        ruleInstanceCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setRuleInstances(Arrays.asList(ruleInstanceCreateOrUpdateRequestDTO));

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset76");
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);

        MonitorFlowDefinitionCreateOrUpdateRequestDTO updateDTO = JSONUtils.parseObject(JSONUtils.toJSONString(monitorFlowDefinitionResponseDTO), MonitorFlowDefinitionCreateOrUpdateRequestDTO.class);

        updateDTO.getAlerterInstances().forEach(i -> {
            i.setAlerterSourceCode(alertInstance.getCode());
            i.setParameter("phone");
        });
        requestDTO.setDatasetCode("dataset76");

        updateDTO.getRuleInstances().forEach(i -> {
            i.setMetricsCode(metrics.getCode());
            i.setMetricsConfigCode(metricsConfig.getCode());
            i.setSample(true);
            i.setDatasetCode("dataset76");
            i.setState(RuleStateEnum.OFFLINE);
            i.setSubjectCategory(SubjectCategoryEnum.FIELD);
        });

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTOUpdate = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTOUpdate.setCategory("category");
        metricsCreateOrUpdateRequestDTOUpdate.setCode("sum67-update");
        metricsCreateOrUpdateRequestDTOUpdate.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTOUpdate.setName("test67");
        MetricsResponseDTO metricsUpdate = createMetrics(metricsCreateOrUpdateRequestDTOUpdate);

        MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTOUpdate = new MetricsConfigCreateOrUpdateRequestDTO();
        metricsConfigCreateOrUpdateRequestDTOUpdate.setDescription("test");
        metricsConfigCreateOrUpdateRequestDTOUpdate.setMetricsCode(metricsUpdate.getCode());
        metricsConfigCreateOrUpdateRequestDTOUpdate.setMetricsParams("{\"subjectCategory\": \"\",\"subjectCode\":  \"\", \"metricsCode\": \"sum\", \"filter\":\"\"}");
        metricsConfigCreateOrUpdateRequestDTOUpdate.setSubjectCategory(SubjectCategoryEnum.TABLE);
        metricsConfigCreateOrUpdateRequestDTOUpdate.setSourceCategory("sourceCategory");
        MetricsConfigResponseDTO metricsConfigUpdate = createMetricsConfig(metricsConfigCreateOrUpdateRequestDTOUpdate);

        RuleInstanceCreateOrUpdateRequestDTO ruleUpdate = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleUpdate.setMetricsCode(metricsUpdate.getCode());
        ruleUpdate.setMetricsConfigCode(metricsConfigUpdate.getCode());
        ruleUpdate.setSample(true);
        ruleUpdate.setState(RuleStateEnum.OFFLINE);
        ruleUpdate.setDatasetCode("dataset76");
        ruleUpdate.setSubjectCategory(SubjectCategoryEnum.TABLE);
        updateDTO.getRuleInstances().add(ruleUpdate);
        updateDTO.setSchedulerCode("466");

        String sampleValue = "100";
        updateDTO.getSampleInstance().setParameter(sampleValue);
        updateDTO.setSchedulerCode("schedulerCod");
        List<RuleInstanceCreateOrUpdateRequestDTO> rules = updateDTO.getRuleInstances().stream().filter(i -> Objects.isNull(i.getId())).collect(Collectors.toList());

        AlerterInstanceCreateOrUpdateRequestDTO alerterInstanceCreateOrUpdateRequestDTOUpdate = new AlerterInstanceCreateOrUpdateRequestDTO();
        alerterInstanceCreateOrUpdateRequestDTOUpdate.setAlerterSourceCode(alertInstance.getCode());
        alerterInstanceCreateOrUpdateRequestDTOUpdate.setParameter("phone");
        updateDTO.getAlerterInstances().clear();
        updateDTO.getAlerterInstances().add(alerterInstanceCreateOrUpdateRequestDTOUpdate);
        updateDTO.setRuleInstances(rules);
        updateDTO.setDatasetCode("dataset76");
        updateDTO.setDatabaseCode("databaseCode");
        String url = REST_FUNCTION_URL_PREFIX + "update";
        MvcResult mvcResult = mockMvc.perform(put(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(updateDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<MonitorFlowDefinitionResponseDTO> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MonitorFlowDefinitionResponseDTO>>() {
        });
        MonitorFlowDefinitionResponseDTO data = resultEntity.getData();
        Assertions.assertEquals(sampleValue, data.getSampleInstance().getParameter());
    }

    @Test
    public void testQuery() throws Exception {
        AlerterSourceCreateOrUpdateRequestDTO alerterSourceCreateOrUpdateRequestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        alerterSourceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterSourceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterSourceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterSourceResponseDTO alertInstance = createAlertInstance(alerterSourceCreateOrUpdateRequestDTO);

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("sum86");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("test3");
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
        requestDTO.setDatasetCode("dataset86");
        requestDTO.setDatabaseCode("databaseCode");

        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSample(true);
        ruleInstanceCreateOrUpdateRequestDTO.setState(RuleStateEnum.OFFLINE);
        ruleInstanceCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setRuleInstances(Arrays.asList(ruleInstanceCreateOrUpdateRequestDTO));

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset86");
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);
        requestDTO.setDatasourceCode("datesourceCode");
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);

        String url = REST_FUNCTION_URL_PREFIX + "queryListPage";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("pageNo", "1")
                .param("pageSize", "10").param("datasourceCode", "datesourceCode"))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<PageResponseDTO<MonitorFlowDefinitionResponseDTO>> resultEntity =
                JSONUtils.parseObject(result, new TypeReference<ResultEntity<PageResponseDTO<MonitorFlowDefinitionResponseDTO>>>() {
                });
        Assertions.assertEquals(1, resultEntity.getData().getTotal());
    }

    @Test
    public void deleteById() throws Exception {
        AlerterSourceCreateOrUpdateRequestDTO alerterSourceCreateOrUpdateRequestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        alerterSourceCreateOrUpdateRequestDTO.setAlertType("DingTalk");
        alerterSourceCreateOrUpdateRequestDTO.setName("dingTalk test");
        alerterSourceCreateOrUpdateRequestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        AlerterSourceResponseDTO alertInstance = createAlertInstance(alerterSourceCreateOrUpdateRequestDTO);

        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("sum96");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("test4");
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
        requestDTO.setDatasetCode("dataset96");
        requestDTO.setDatabaseCode("databaseCode");
        
        RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO = new RuleInstanceCreateOrUpdateRequestDTO();
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceCreateOrUpdateRequestDTO.setSample(true);
        ruleInstanceCreateOrUpdateRequestDTO.setState(RuleStateEnum.OFFLINE);
        ruleInstanceCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setRuleInstances(Arrays.asList(ruleInstanceCreateOrUpdateRequestDTO));

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset96");
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        requestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);
        MonitorFlowDefinitionResponseDTO monitorFlowDefinitionResponseDTO = create(requestDTO);

        String url = REST_FUNCTION_URL_PREFIX + monitorFlowDefinitionResponseDTO.getId();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<ResultEntity> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<ResultEntity>>() {
        });
        Assertions.assertEquals(200, resultEntity.getCode());
    }
}
