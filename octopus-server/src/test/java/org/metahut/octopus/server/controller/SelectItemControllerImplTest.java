package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.SelectItemResponseDTO;
import org.metahut.octopus.server.WebMvcApplicationTest;
import org.metahut.octopus.server.utils.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SelectItemControllerImplTest extends WebMvcApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/selectItem/";

    @Test
    public void testQueryList() throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "queryList";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .param("componentNames", "METRICS_DIMENSION,SUBJECT_CATEGORY"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        ResultEntity<Map<String, List<SelectItemResponseDTO>>> result = JSONUtils.parseObject(response, new TypeReference<ResultEntity<Map<String, List<SelectItemResponseDTO>>>>() {
        });
        Assertions.assertTrue(result.isSuccess());
    }

}
