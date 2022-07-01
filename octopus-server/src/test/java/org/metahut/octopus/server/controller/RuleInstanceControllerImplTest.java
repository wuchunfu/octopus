package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceSingleCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.SampleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.utils.JSONUtils;
import org.metahut.octopus.server.WebMvcApplicationTest;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RuleInstanceControllerImplTest extends WebMvcApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/ruleInstance/";

    private MetricsResponseDTO createMetrics(MetricsCreateOrUpdateRequestDTO requestDTO) throws Exception {
        requestDTO.setCode("c_count_instance" + RANDOM.nextInt(1000));
        requestDTO.setName("c_count_instance" + RANDOM.nextInt(1000));
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

    private RuleInstanceResponseDTO create(RuleInstanceSingleCreateOrUpdateRequestDTO requestDTO) throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "create";
        MvcResult mvcResult = mockMvc.perform(put(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(requestDTO)))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<RuleInstanceResponseDTO> create = JSONUtils.parseObject(result, new TypeReference<ResultEntity<RuleInstanceResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        RuleInstanceResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData);
        return createData;
    }

    @Test
    public void testCreate() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("count" + RANDOM.nextInt(1000));
        metricsCreateOrUpdateRequestDTO.setName("count" + RANDOM.nextInt(1000));
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        metricsConfigCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        metricsConfigCreateOrUpdateRequestDTO.setSourceCategory("Hive");
        metricsConfigCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        metricsConfigCreateOrUpdateRequestDTO.setMetricsParams("{\"subjectCategory\": \"\",\"subjectCode\":  \"\", \"metricsCode\": \"c_count_instance18\", \"filter\":\"\"}");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(metricsConfigCreateOrUpdateRequestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO ruleInstanceSingleCreateOrUpdateRequestDTO = new RuleInstanceSingleCreateOrUpdateRequestDTO();
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckMethod("checkMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckType("checkType");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setComparisonMethod("comparisonMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setExpectedValue(Arrays.asList("10"));
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCode("subjectCode");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setDatasetCode("dataset26");

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setCode(5857119121793L + RANDOM.nextInt(1000));
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("executorType");
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("dataset" + RANDOM.nextInt(1000));
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("90");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);

        RuleInstanceResponseDTO ruleInstanceResponseDTOS = create(ruleInstanceSingleCreateOrUpdateRequestDTO);
    }

    @Test
    public void testUpdate() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("count" + RANDOM.nextInt(1000));
        metricsCreateOrUpdateRequestDTO.setName("count" + RANDOM.nextInt(1000));
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        metricsConfigCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        metricsConfigCreateOrUpdateRequestDTO.setSourceCategory("Hive");
        metricsConfigCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        metricsConfigCreateOrUpdateRequestDTO.setMetricsParams("{\"subjectCategory\": \"\",\"subjectCode\":  \"\", \"metricsCode\": \"c_count_instance18\", \"filter\":\"\"}");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(metricsConfigCreateOrUpdateRequestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO ruleInstanceSingleCreateOrUpdateRequestDTO = new RuleInstanceSingleCreateOrUpdateRequestDTO();
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckMethod("checkMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckType("checkType");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setComparisonMethod("comparisonMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setExpectedValue(Arrays.asList("10"));
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCode("subjectCode");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setDatasetCode("datasetCode0610");

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("BATCH");
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("datasetCode0610");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("20");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);

        RuleInstanceResponseDTO ruleInstanceResponseDTOS = create(ruleInstanceSingleCreateOrUpdateRequestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO updateRequestDTO = JSONUtils.parseObject(JSONUtils.toJSONString(ruleInstanceResponseDTOS), RuleInstanceSingleCreateOrUpdateRequestDTO.class);
        String checkMethod = "checkMethod-update";
        updateRequestDTO.setCheckMethod(checkMethod);
        updateRequestDTO.setMetricsCode(metrics.getCode());
        updateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        updateRequestDTO.getSampleInstance().setParameter("100");

        String url = REST_FUNCTION_URL_PREFIX + "update";
        MvcResult mvcResult = mockMvc.perform(put(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(updateRequestDTO)))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<RuleInstanceResponseDTO> update = JSONUtils.parseObject(result, new TypeReference<ResultEntity<RuleInstanceResponseDTO>>() {
        });
        Assertions.assertTrue(update.isSuccess());
        RuleInstanceResponseDTO data = update.getData();
        Assertions.assertEquals(checkMethod, data.getCheckMethod());
    }

    @Test
    public void testDeleteById() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("count" + RANDOM.nextInt(1000));
        metricsCreateOrUpdateRequestDTO.setName("count" + RANDOM.nextInt(1000));
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        metricsConfigCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        metricsConfigCreateOrUpdateRequestDTO.setSourceCategory("Hive");
        metricsConfigCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        metricsConfigCreateOrUpdateRequestDTO.setMetricsParams("{\"subjectCategory\": \"\",\"subjectCode\":  \"\", \"metricsCode\": \"c_count_instance18\", \"filter\":\"\"}");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(metricsConfigCreateOrUpdateRequestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO ruleInstanceSingleCreateOrUpdateRequestDTO = new RuleInstanceSingleCreateOrUpdateRequestDTO();
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckMethod("checkMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckType("checkType");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setComparisonMethod("comparisonMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setExpectedValue(Arrays.asList("10"));
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCode("subjectCode");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setDatasetCode("datasetCode0606");

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setCode(5714046032257L);
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("BATCH");
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("datasetCode0606");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("20");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);

        RuleInstanceResponseDTO ruleInstanceResponseDTOS = create(ruleInstanceSingleCreateOrUpdateRequestDTO);

        String url = REST_FUNCTION_URL_PREFIX + ruleInstanceResponseDTOS.getId();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<ResultEntity> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<ResultEntity>>() {
        });
        Assertions.assertEquals(200, resultEntity.getCode());
    }

    @Test
    public void testQueryListPage() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("count" + RANDOM.nextInt(1000));
        metricsCreateOrUpdateRequestDTO.setName("count" + RANDOM.nextInt(1000));
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        metricsConfigCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        metricsConfigCreateOrUpdateRequestDTO.setSourceCategory("Hive");
        metricsConfigCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        metricsConfigCreateOrUpdateRequestDTO.setMetricsParams("{\"subjectCategory\": \"\",\"subjectCode\":  \"\", \"metricsCode\": \"c_count_instance18\", \"filter\":\"\"}");
        MetricsConfigResponseDTO metricsConfig = createMetricsConfig(metricsConfigCreateOrUpdateRequestDTO);

        RuleInstanceSingleCreateOrUpdateRequestDTO ruleInstanceSingleCreateOrUpdateRequestDTO = new RuleInstanceSingleCreateOrUpdateRequestDTO();
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckMethod("checkMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setCheckType("checkType");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setComparisonMethod("comparisonMethod");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setExpectedValue(Arrays.asList("10"));
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCode("subjectCode");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsCode(metrics.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setMetricsConfigCode(metricsConfig.getCode());
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        ruleInstanceSingleCreateOrUpdateRequestDTO.setDatasetCode("datasetCode0609");

        SampleInstanceCreateOrUpdateRequestDTO sampleInstanceCreateOrUpdateRequestDTO = new SampleInstanceCreateOrUpdateRequestDTO();
        sampleInstanceCreateOrUpdateRequestDTO.setExecutorType("BATCH");
        sampleInstanceCreateOrUpdateRequestDTO.setDatasetCode("datasetCode0609");
        sampleInstanceCreateOrUpdateRequestDTO.setParameter("20");
        ruleInstanceSingleCreateOrUpdateRequestDTO.setSampleInstance(sampleInstanceCreateOrUpdateRequestDTO);

        RuleInstanceResponseDTO ruleInstanceResponseDTOS = create(ruleInstanceSingleCreateOrUpdateRequestDTO);

        String url = REST_FUNCTION_URL_PREFIX + "queryListPage";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("pageNo", "1")
                        .param("pageSize", "10").param("datasetCode", "datasetCode0609"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>>>() {
        });
        Assertions.assertTrue(resultEntity.isSuccess());
        PageResponseDTO<RuleInstanceResponseDTO> data = resultEntity.getData();
        Assertions.assertEquals(1, data.getTotal());
    }

    @Test
    public void testCheck() throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "check";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .param("metricsCode", "sum67-update")
                .param("subjectCodes", "dataset76")
                .param("subjectCategory", "TABLE"))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void testQueryRuleInstanceCount() throws Exception {
        testCreate();
        String url = REST_FUNCTION_URL_PREFIX + "queryRuleInstanceCount";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .param("SubjectCategoryEnum", "TABLE"))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<Long> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<Long>>() {
        });
        Assertions.assertTrue(resultEntity.isSuccess());
        Assertions.assertTrue(resultEntity.getData() > 0);
    }
}
