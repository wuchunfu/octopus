package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MetricsResultConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Api(tags = "MONITOR_DB_TAG")
@RequestMapping("monitorDB")
public interface MonitorDBController {

    @ApiOperation(value = "customSQLQuery", notes = "MONITOR_DB_CUSTOM_SQL_QUERY_NOTES")
    @GetMapping("customSQLQuery")
    ResultEntity<List<Map<String, Object>>> customSQLQuery(String sql);

    @ApiOperation(value = "queryMonitorLogListPage", notes = "MONITOR_LOG_QUERY_LIST_PAGE_NOTES")
    @GetMapping("monitorLog/queryListPage")
    ResultEntity<PageResponseDTO<MonitorLogResponseDTO>> queryMonitorLogListPage(MonitorLogConditionsRequestDTO requestDTO);

    @ApiOperation(value = "queryMetricsResultListPage", notes = "METRICS_RESULT_QUERY_LIST_PAGE_NOTES")
    @GetMapping("metricsResult/queryListPage")
    ResultEntity<PageResponseDTO<MetricsResultResponseDTO>> queryMetricsResultListPage(MetricsResultConditionsRequestDTO requestDTO);

}
