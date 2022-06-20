package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleTemplateCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;
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

public class RuleTemplateControllerImplTest extends WebMvcApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/ruleTemplate/";

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

    private RuleTemplateResponseDTO create(RuleTemplateCreateOrUpdateRequestDTO requestDTO) throws Exception {
        String url = REST_FUNCTION_URL_PREFIX;
        MvcResult mvcResult = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(requestDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<RuleTemplateResponseDTO> create = JSONUtils.parseObject(result, new TypeReference<ResultEntity<RuleTemplateResponseDTO>>() {
        });
        Assertions.assertTrue(create.isSuccess());
        RuleTemplateResponseDTO createData = create.getData();
        Assertions.assertNotNull(createData.getId());
        Assertions.assertNotNull(createData.getMetrics());
        return createData;
    }

    @Test
    public void testCreate() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("count1");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("count1");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateCreateOrUpdateRequestDTO request = new RuleTemplateCreateOrUpdateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        request.setSubjectCategory(SubjectCategoryEnum.TABLE);
        request.setCheckMethod("checkMethod");
        request.setCheckType("checkType");
        request.setComparisonMethod("ComparisonMethod");
        request.setComparisonUnit("ComparisonUnit");
        request.setExpectedValue(Arrays.asList("20"));
        RuleTemplateResponseDTO ruleTemplateResponseDTO = create(request);
    }

    @Test
    public void testDeleteById() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("r_t_count1");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("count2");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateCreateOrUpdateRequestDTO request = new RuleTemplateCreateOrUpdateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        request.setSubjectCategory(SubjectCategoryEnum.TABLE);
        request.setCheckMethod("checkMethod");
        request.setCheckType("checkType");
        request.setComparisonMethod("ComparisonMethod");
        request.setComparisonUnit("ComparisonUnit");
        request.setExpectedValue(Arrays.asList("30"));
        RuleTemplateResponseDTO ruleTemplateResponseDTO = create(request);

        String url = REST_FUNCTION_URL_PREFIX + ruleTemplateResponseDTO.getId();
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
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("count3");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("count3");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateCreateOrUpdateRequestDTO request = new RuleTemplateCreateOrUpdateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        request.setSubjectCategory(SubjectCategoryEnum.TABLE);
        request.setCheckMethod("checkMethod");
        request.setCheckType("checkType");
        request.setComparisonMethod("ComparisonMethod");
        request.setComparisonUnit("ComparisonUnit");
        request.setExpectedValue(Arrays.asList("10", "20"));
        RuleTemplateResponseDTO ruleTemplateResponseDTO = create(request);

        String url = REST_FUNCTION_URL_PREFIX + "queryListPage";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("pageNo", "1")
                        .param("pageSize", "10").param("metricsCode", metrics.getCode()))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<PageResponseDTO<RuleTemplateResponseDTO>> responseDTO = JSONUtils.parseObject(result, new TypeReference<ResultEntity<PageResponseDTO<RuleTemplateResponseDTO>>>() {
        });
        Assertions.assertTrue(responseDTO.isSuccess());
        PageResponseDTO<RuleTemplateResponseDTO> data = responseDTO.getData();
        Assertions.assertEquals(1, data.getTotal());
    }

    @Test
    public void testUpdate() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCategory("category");
        metricsCreateOrUpdateRequestDTO.setCode("count5");
        metricsCreateOrUpdateRequestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTO.setName("count5");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        RuleTemplateCreateOrUpdateRequestDTO request = new RuleTemplateCreateOrUpdateRequestDTO();
        request.setMetricsCode(metrics.getCode());
        request.setSubjectCategory(SubjectCategoryEnum.TABLE);
        request.setCheckMethod("checkMethod");
        request.setCheckType("checkType");
        request.setComparisonMethod("ComparisonMethod");
        request.setComparisonUnit("ComparisonUnit");
        request.setExpectedValue(Arrays.asList("10", "20"));
        RuleTemplateResponseDTO ruleTemplateResponseDTO = create(request);

        RuleTemplateCreateOrUpdateRequestDTO requestUpdateDTO = JSONUtils.parseObject(JSONUtils.toJSONString(ruleTemplateResponseDTO), RuleTemplateCreateOrUpdateRequestDTO.class);
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTOUpdate = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTOUpdate.setCategory("category");
        metricsCreateOrUpdateRequestDTOUpdate.setCode("count-update");
        metricsCreateOrUpdateRequestDTOUpdate.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);
        metricsCreateOrUpdateRequestDTOUpdate.setName("count-update");
        MetricsResponseDTO metricsUpdate = createMetrics(metricsCreateOrUpdateRequestDTOUpdate);
        requestUpdateDTO.setMetricsCode(metricsUpdate.getCode());
        requestUpdateDTO.setCheckType("checkType-update");

        String url = REST_FUNCTION_URL_PREFIX;
        MvcResult mvcResult = mockMvc.perform(put(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(requestUpdateDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<RuleTemplateResponseDTO> update = JSONUtils.parseObject(result, new TypeReference<ResultEntity<RuleTemplateResponseDTO>>() {
        });
        Assertions.assertTrue(update.isSuccess());
        RuleTemplateResponseDTO data = update.getData();
        Assertions.assertEquals("checkType-update", data.getCheckType());
    }
}

