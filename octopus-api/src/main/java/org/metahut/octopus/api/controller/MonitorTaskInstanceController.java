package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MonitorTaskInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "MONITOR_TASK_INSTANCE_TAG")
@RequestMapping("monitorTaskInstance")
@Validated
public interface MonitorTaskInstanceController {

    @ApiOperation(value = "queryListPage", notes = "MONITOR_TASK_INSTANCE_QUERY_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity<PageResponseDTO<MonitorTaskInstanceResponseDTO>> queryListPage(MonitorTaskInstanceConditionsRequestDTO requestDTO);
}
