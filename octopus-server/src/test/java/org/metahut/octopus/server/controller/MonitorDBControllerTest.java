package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetricsResultConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.common.utils.JSONUtils;
import org.metahut.octopus.server.WebMvcApplicationTest;
import org.metahut.octopus.server.service.MonitorDBService;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
public class MonitorDBControllerTest extends WebMvcApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/monitorDB/";

    @MockBean
    private MonitorDBService monitorDBService;

    @Test
    public void customSQLQueryTest() throws Exception {
        List<Map<String, Object>> list = new ArrayList<>();
        given(this.monitorDBService.customSQLQuery(Mockito.any(String.class))).willReturn(list);

        String url = REST_FUNCTION_URL_PREFIX + "customSQLQuery";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("sql", "select * from tb_octopus_monitor_log"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String resoponse = mvcResult.getResponse().getContentAsString();
        ResultEntity<List> result = JSONUtils.parseObject(resoponse, new TypeReference<ResultEntity<List>>() {
        });
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertNotNull(result.getData());
    }

    @Test
    public void queryMonitorLogListPageTest() throws Exception {
        PageResponseDTO<MonitorLogResponseDTO> monitorLogResponseDTOPageResponseDTO = new PageResponseDTO<>();
        given(this.monitorDBService.queryMonitorLogListPage(Mockito.any(MonitorLogConditionsRequestDTO.class))).willReturn(monitorLogResponseDTOPageResponseDTO);
        String url = REST_FUNCTION_URL_PREFIX + "monitorLog/queryListPage";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("pageNo", "1")
                        .param("pageSize", "10"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String resoponse = mvcResult.getResponse().getContentAsString();
        ResultEntity<ResultEntity<PageResponseDTO<MonitorLogResponseDTO>>> result =
                JSONUtils.parseObject(resoponse, new TypeReference<ResultEntity<ResultEntity<PageResponseDTO<MonitorLogResponseDTO>>>>() {
                });
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertNotNull(result.getData());
    }

    @Test
    public void queryMetricsResultListPage() throws Exception {
        PageResponseDTO<MetricsResultResponseDTO> metricsResultResponseDTOPageResponseDTO = new PageResponseDTO<>();
        given(this.monitorDBService.queryMetricsResultListPage(Mockito.any(MetricsResultConditionsRequestDTO.class))).willReturn(metricsResultResponseDTOPageResponseDTO);
        String url = REST_FUNCTION_URL_PREFIX + "metricsResult/queryListPage";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("pageNo", "1")
                        .param("pageSize", "10"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String resoponse = mvcResult.getResponse().getContentAsString();
        ResultEntity<ResultEntity<PageResponseDTO<MetricsResultResponseDTO>>> result =
                JSONUtils.parseObject(resoponse, new TypeReference<ResultEntity<ResultEntity<PageResponseDTO<MetricsResultResponseDTO>>>>() {
                });

        Assertions.assertTrue(result.isSuccess());
        Assertions.assertNotNull(result.getData());
    }
}
