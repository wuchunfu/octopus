package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.server.WebMvcApplicationTest;
import org.metahut.octopus.server.alerter.AlerterPluginHelper;
import org.metahut.octopus.server.utils.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MetricsControllerImplTest extends WebMvcApplicationTest {

    @MockBean
    private AlerterPluginHelper alerterPluginHelper;
    
    private static final String REST_FUNCTION_URL_PREFIX = "/metrics/";

    protected MetricsResponseDTO create(MetricsCreateOrUpdateRequestDTO requestDTO) throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "create";
        requestDTO.setMetricsDimension(MetricsDimensionEnum.INTEGRALITY);

        MvcResult mvcResult = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(org.metahut.octopus.scheduler.dolphinscheduler.JSONUtils.toJSONString(requestDTO)))
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
        MetricsCreateOrUpdateRequestDTO requestDTO = new MetricsCreateOrUpdateRequestDTO();
        requestDTO.setCode("count");
        requestDTO.setName("count");
        create(requestDTO);
    }

    @Test
    public void testUpdate() throws Exception {
        MetricsCreateOrUpdateRequestDTO requestDTO = new MetricsCreateOrUpdateRequestDTO();
        requestDTO.setCode("null_value");
        requestDTO.setName("null_value");
        requestDTO.setCategory("single");
        MetricsResponseDTO createData = create(requestDTO);

        MetricsCreateOrUpdateRequestDTO updateRequestDTO = JSONUtils.parseObject(JSONUtils.toJSONString(createData), MetricsCreateOrUpdateRequestDTO.class);
        String updateName = "new null_value metrics";
        updateRequestDTO.setName(updateName);
        updateRequestDTO.setCode(updateName);
        updateRequestDTO.setDescription(updateName);
        updateRequestDTO.setCategory(null);

        String url = REST_FUNCTION_URL_PREFIX + "update";
        MvcResult mvcResult = mockMvc.perform(put(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(updateRequestDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<MetricsResponseDTO> update = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetricsResponseDTO>>() {
        });
        Assertions.assertTrue(update.isSuccess());
        MetricsResponseDTO data = update.getData();
        Assertions.assertEquals(updateName, data.getName());
    }

    @Test
    public void testQueryList() throws Exception {

        MetricsCreateOrUpdateRequestDTO requestDTO1 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO1.setCode("null_value1");
        requestDTO1.setName("null_value");
        requestDTO1.setCategory("single");
        create(requestDTO1);

        MetricsCreateOrUpdateRequestDTO requestDTO2 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO2.setCode("m_count1");
        requestDTO2.setName("m_count1");
        requestDTO2.setCategory("single");
        MetricsResponseDTO createData2 = create(requestDTO2);

        String url = REST_FUNCTION_URL_PREFIX + "queryList";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("code", "m_count1")
                        .param("name", "m_count1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<List<MetricsResponseDTO>> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<List<MetricsResponseDTO>>>() {
        });
        Assertions.assertTrue(resultEntity.isSuccess());
        List<MetricsResponseDTO> data = resultEntity.getData();
        Assertions.assertEquals(1, data.size());
        Assertions.assertEquals(createData2.getId(), data.get(0).getId());
    }

    @Test
    public void testQueryListPage() throws Exception {
        MetricsCreateOrUpdateRequestDTO requestDTO1 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO1.setCode("null_value2");
        requestDTO1.setName("null_value");
        requestDTO1.setCategory("single");
        create(requestDTO1);

        MetricsCreateOrUpdateRequestDTO requestDTO2 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO2.setCode("m_count2");
        requestDTO2.setName("m_count2");
        requestDTO2.setCategory("single");
        MetricsResponseDTO createData2 = create(requestDTO2);

        String url = REST_FUNCTION_URL_PREFIX + "queryListPage";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("pageNo", "1")
                        .param("pageSize", "10").param("code", "m_count2"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<PageResponseDTO<MetricsResponseDTO>> pageResult = JSONUtils.parseObject(result, new TypeReference<ResultEntity<PageResponseDTO<MetricsResponseDTO>>>() {
        });
        Assertions.assertTrue(pageResult.isSuccess());
        PageResponseDTO<MetricsResponseDTO> data = pageResult.getData();
        Assertions.assertEquals(1, data.getTotal());
        Assertions.assertEquals(createData2.getId(), data.getData().get(0).getId());
    }

    @Test
    public void deleteById() throws Exception {
        MetricsCreateOrUpdateRequestDTO requestDTO1 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO1.setCode("null_value3");
        requestDTO1.setName("null_value");
        requestDTO1.setCategory("single");
        MetricsResponseDTO metricsResponseDTO = create(requestDTO1);

        String url = REST_FUNCTION_URL_PREFIX + metricsResponseDTO.getId();
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
        MetricsCreateOrUpdateRequestDTO requestDTO1 = new MetricsCreateOrUpdateRequestDTO();
        requestDTO1.setCode("null_value4");
        requestDTO1.setName("null_value");
        requestDTO1.setCategory("single");
        MetricsResponseDTO metricsResponseDTO = create(requestDTO1);

        String url = REST_FUNCTION_URL_PREFIX + metricsResponseDTO.getCode();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();

        ResultEntity<MetricsResponseDTO> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetricsResponseDTO>>() {
        });
        Assertions.assertTrue(resultEntity.isSuccess());
        Assertions.assertEquals(resultEntity.getData().getCode(), requestDTO1.getCode());
    }
}
