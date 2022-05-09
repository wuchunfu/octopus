package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MonitorTaskConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "MONITOR_TASK_TAG")
@RequestMapping("monitorTask")
public interface MonitorTaskController {

    @ApiOperation(value = "queryListPage", notes = "QUERY_LIST_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity<PageResponseDTO<MonitorTaskResponseDTO>> queryListPage(@RequestBody MonitorTaskConditionsRequestDTO requestDTO);

    @ApiOperation(value = "queryById", notes = "QUERY_BY_ID_NOTES")
    @GetMapping("queryById")
    ResultEntity<MonitorTaskResponseDTO> queryById(Integer id);

}
