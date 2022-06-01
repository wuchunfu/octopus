package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.AlerterSourceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.dao.entity.AlerterSource;
import org.metahut.octopus.dao.repository.AlerterSourceRepository;
import org.metahut.octopus.scheduler.dolphinscheduler.JSONUtils;
import org.metahut.octopus.server.WebMvcApplicationTest;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AlerterSourceControllerTest extends WebMvcApplicationTest {

    private static final String REST_FUNCTION_URL_PREFIX = "/alerterSource/";

    @MockBean
    private AlerterSourceRepository alerterSourceRepository;

    @Test
    void testCreate() throws Exception {
        String url = REST_FUNCTION_URL_PREFIX + "create";
        String alertType = "DingTalk";
        AlerterSource alerterSource = new AlerterSource();
        alerterSource.setAlertType(alertType);
        given(this.alerterSourceRepository.save(Mockito.any())).willReturn(alerterSource);

        AlerterSourceCreateOrUpdateRequestDTO requestDTO = new AlerterSourceCreateOrUpdateRequestDTO();
        requestDTO.setAlertType(alertType);
        requestDTO.setName("dingTalk test");
        requestDTO.setParameter("{\"webhook\":\"1\", \"secret\":\"secret\"}");
        MvcResult mvcResult = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(requestDTO)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        ResultEntity<AlerterSourceResponseDTO> resultEntity = JSONUtils.parseObject(result, new TypeReference<ResultEntity<AlerterSourceResponseDTO>>() {
        });
        Assertions.assertTrue(resultEntity.isSuccess());

    }

}
