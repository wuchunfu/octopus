package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(tags = "MONITOR_LOG_TAG")
@RequestMapping("monitorLog")
public interface MonitorLogController {

    @ApiOperation(value = "queryAll", notes = "QUERY_ALL_NOTES")
    @GetMapping("queryAll")
    ResultEntity<List<MonitorLogResponseDTO>> queryAll(MonitorLogConditionsRequestDTO request);

    @ApiOperation(value = "queryListPage", notes = "QUERY_LIST_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity<PageResponseDTO<MonitorLogResponseDTO>> queryListPage(MonitorLogConditionsRequestDTO request);

    @ApiOperation(value = "queryById", notes = "QUERY_BY_ID_NOTES")
    @GetMapping("queryById")
    ResultEntity<MonitorLogResponseDTO> queryById(Integer id);

}
