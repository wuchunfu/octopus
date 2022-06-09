package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.scheduler.dolphinscheduler.JSONUtils;
import org.metahut.octopus.server.WebMvcApplicationTest;
import org.metahut.octopus.server.service.MetaService;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

public class MetaControllerImplTest extends WebMvcApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/meta/";

    @MockBean
    private MetaService metaService;

    @Test
    public void queryDatasourceTypeListPage() throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "queryDatasourceTypeListPage";
        MetaDatasourceResponseDTO responseDTO = new MetaDatasourceResponseDTO();
        responseDTO.setType("Hive");
        responseDTO.setCode("1");
        responseDTO.setName("HIVE-IDC");
        BDDMockito.given(this.metaService.queryDatasourceTypeListPage(Mockito.argThat(request -> "Hive".equals(request.getName()))))
            .willReturn(PageResponseDTO.of(1, 100, 1L, Arrays.asList(responseDTO)));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("name", "Hive"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<MetaDatasourceResponseDTO> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetaDatasourceResponseDTO>>() {
        });
        Assertions.assertTrue(resultEntity.isSuccess());
        Assertions.assertNotNull(resultEntity.getData());
    }

    @Test
    public void queryDatasourceListPage() throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "queryDatasourceListPage";

        MetaDatasourceResponseDTO responseDTO = new MetaDatasourceResponseDTO();
        responseDTO.setType("Hive");
        responseDTO.setCode("1");
        responseDTO.setName("HIVE-IDC");

        BDDMockito.given(this.metaService.queryDatasourceListPage(Mockito.argThat(request -> "Hive".equals(request.getDataSourceType()))))
            .willReturn(PageResponseDTO.of(1, 100, 1L, Arrays.asList(responseDTO)));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("dataSourceType", "Hive"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<MetaDatasourceResponseDTO> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetaDatasourceResponseDTO>>() {
        });
        Assertions.assertTrue(resultEntity.isSuccess());
        Assertions.assertNotNull(resultEntity.getData());
    }

    @Test
    public void queryDatabaseListPage() throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "queryDatabaseListPage";

        MetaDatabaseResponseDTO responseDTO = new MetaDatabaseResponseDTO();
        responseDTO.setCode("1");
        responseDTO.setName("dwd");

        BDDMockito.given(this.metaService.queryDatabaseListPage(Mockito.any()))
            .willReturn(PageResponseDTO.of(1, 100, 1L, Arrays.asList(responseDTO)));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("dataSourceType", "Hive")
                .param("name", "dwd"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<MetaDatabaseResponseDTO> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetaDatabaseResponseDTO>>() {
        });
        Assertions.assertTrue(resultEntity.isSuccess());
        Assertions.assertNotNull(resultEntity.getData());
    }

    @Test
    public void queryDatasetListPage() throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "queryDatasetList";

        MetaDatasetResponseDTO responseDTO = new MetaDatasetResponseDTO();
        responseDTO.setCode("1");
        responseDTO.setName("dwd_xxx");
        BDDMockito.given(this.metaService.queryDatasetList(Mockito.any()))
            .willReturn(PageResponseDTO.of(1, 100, 1L, Arrays.asList(responseDTO)));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("dataSourceType", "Hive"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<MetaDatasetResponseDTO> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<MetaDatasetResponseDTO>>() {
        });
        Assertions.assertTrue(resultEntity.isSuccess());
        Assertions.assertNotNull(resultEntity.getData());
    }
}
