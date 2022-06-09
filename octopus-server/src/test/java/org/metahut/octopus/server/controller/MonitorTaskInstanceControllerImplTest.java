package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.dto.MonitorTaskInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.scheduler.api.PageResponse;
import org.metahut.octopus.scheduler.api.entity.TaskInstance;
import org.metahut.octopus.scheduler.api.parameters.TaskInstanceRequestParameter;
import org.metahut.octopus.server.WebMvcApplicationTest;
import org.metahut.octopus.server.service.SchedulerService;
import org.metahut.octopus.server.utils.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MonitorTaskInstanceControllerImplTest extends WebMvcApplicationTest {

    @MockBean
    private SchedulerService schedulerService;

    @Test
    public void queryListPageTest() throws Exception {
        String url = "/monitorTaskInstance/queryListPage";
        PageResponse<TaskInstance> taskInstancePageResponse = new PageResponse<>();
        given(this.schedulerService.queryTaskInstanceListPage(Mockito.any(TaskInstanceRequestParameter.class))).willReturn(taskInstancePageResponse);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).param("pageNo", "1")
                        .param("pageSize", "10"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        ResultEntity<PageResponseDTO<MonitorTaskInstanceResponseDTO>> result =
                JSONUtils.parseObject(response, new TypeReference<ResultEntity<PageResponseDTO<MonitorTaskInstanceResponseDTO>>>() {
                });

        Assertions.assertTrue(result.isSuccess());
        //Assertions.assertNotNull(result.getData());
    }
}
