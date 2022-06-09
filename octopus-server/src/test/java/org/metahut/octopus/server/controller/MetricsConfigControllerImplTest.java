package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.server.WebMvcApplicationTest;
import org.metahut.octopus.server.utils.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MetricsConfigControllerImplTest extends WebMvcApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/metricsConfig/";

    private MetricsConfigResponseDTO create(MetricsConfigCreateOrUpdateRequestDTO requestDTO) throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "create";

        requestDTO.setCode(100L);
        requestDTO.setSubjectCategory(SubjectCategoryEnum.TABLE);
        requestDTO.setMetricsParams("{\"executorScript\":\"test\",\"executorType\":\"Flink\"}");
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
        ResultEntity<MetricsResponseDTO> data = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetricsResponseDTO>>() {
        });
        Assertions.assertTrue(data.isSuccess());
        MetricsResponseDTO responseDTO = data.getData();
        Assertions.assertNotNull(responseDTO.getId());
        return responseDTO;
    }

    @Test
    public void testCreate() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count");
        metricsCreateOrUpdateRequestDTO.setName("c_count");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("Hive");
        create(requestDTO);
    }

    @Test
    public void testUpdate() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count1");
        metricsCreateOrUpdateRequestDTO.setName("c_count1");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO.setMetricsCode(metrics.getCode());
        requestDTO.setSourceCategory("Hive1");
        MetricsConfigResponseDTO createData = create(requestDTO);

        MetricsConfigCreateOrUpdateRequestDTO updateRequestDTO = JSONUtils.parseObject(JSONUtils.toJSONString(createData), MetricsConfigCreateOrUpdateRequestDTO.class);
        String updateStr = "HBase1";
        updateRequestDTO.setMetricsCode(createData.getMetrics().getCode());
        updateRequestDTO.setSourceCategory(updateStr);
        updateRequestDTO.setDescription(updateStr);

        String url = REST_FUNCTION_URL_PREFIX + "update";
        MvcResult mvcResult = mockMvc.perform(put(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(updateRequestDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();

        ResultEntity<MetricsConfigResponseDTO> update = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetricsConfigResponseDTO>>() {
        });
        Assertions.assertTrue(update.isSuccess());
        MetricsConfigResponseDTO data = update.getData();
        Assertions.assertEquals(updateStr, data.getSourceCategory());
    }

    @Test
    public void testQueryList() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count2");
        metricsCreateOrUpdateRequestDTO.setName("c_count2");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO1 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO1.setMetricsCode(metrics.getCode());
        requestDTO1.setSourceCategory("Hive2");
        create(requestDTO1);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO2 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO2.setMetricsCode(metrics.getCode());
        requestDTO2.setSourceCategory("HBase2");
        create(requestDTO2);

        String url = REST_FUNCTION_URL_PREFIX + "queryList";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("metricsCode", metrics.getCode()))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        ResultEntity<List<MetricsConfigResponseDTO>> result = JSONUtils.parseObject(response, new TypeReference<ResultEntity<List<MetricsConfigResponseDTO>>>() {
        });
        Assertions.assertTrue(result.isSuccess());
        List<MetricsConfigResponseDTO> data = result.getData();
        Assertions.assertTrue(data.size() > 0);
    }

    @Test
    public void testQueryListPage() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count3");
        metricsCreateOrUpdateRequestDTO.setName("c_count3");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO1 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO1.setMetricsCode(metrics.getCode());
        requestDTO1.setSourceCategory("Hive3");
        create(requestDTO1);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO2 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO2.setMetricsCode(metrics.getCode());
        requestDTO2.setSourceCategory("HBase3");
        create(requestDTO2);

        String url = REST_FUNCTION_URL_PREFIX + "queryListPage";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("pageNo", "1")
                        .param("pageSize", "10").param("metricsCode", metrics.getCode()))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        ResultEntity<PageResponseDTO<MetricsConfigResponseDTO>> result =
                JSONUtils.parseObject(response, new TypeReference<ResultEntity<PageResponseDTO<MetricsConfigResponseDTO>>>() {
                });
        Assertions.assertTrue(result.isSuccess());
        PageResponseDTO<MetricsConfigResponseDTO> data = result.getData();
        Assertions.assertEquals(2, data.getTotal());
    }

    @Test
    public void testDeleteById() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count4");
        metricsCreateOrUpdateRequestDTO.setName("c_count4");
        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);

        MetricsConfigCreateOrUpdateRequestDTO requestDTO1 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO1.setMetricsCode(metrics.getCode());
        requestDTO1.setSourceCategory("Hive4");
        MetricsConfigResponseDTO createData = create(requestDTO1);

        String url = REST_FUNCTION_URL_PREFIX + createData.getId();

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
    public void findByCode() throws Exception {
        MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO = new MetricsCreateOrUpdateRequestDTO();
        metricsCreateOrUpdateRequestDTO.setCode("c_count5");
        metricsCreateOrUpdateRequestDTO.setName("c_count5");

        MetricsResponseDTO metrics = createMetrics(metricsCreateOrUpdateRequestDTO);
        MetricsConfigCreateOrUpdateRequestDTO requestDTO1 = new MetricsConfigCreateOrUpdateRequestDTO();
        requestDTO1.setMetricsCode(metrics.getCode());
        requestDTO1.setSourceCategory("Hive5");
        MetricsConfigResponseDTO createData = create(requestDTO1);

        String url = REST_FUNCTION_URL_PREFIX + createData.getCode();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        ResultEntity<MetricsConfigResponseDTO> result =
                JSONUtils.parseObject(response, new TypeReference<ResultEntity<MetricsConfigResponseDTO>>() {
                });
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(result.getData().getCode(), createData.getCode());
    }
}
