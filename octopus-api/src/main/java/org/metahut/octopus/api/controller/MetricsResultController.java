package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MetricsResultConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResultResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(tags = "METRICS_RESULT_TAG")
@RequestMapping("monitorResult")
public interface MetricsResultController {

    @ApiOperation(value = "queryAll", notes = "QUERY_ALL_NOTES")
    @GetMapping("queryAll")
    ResultEntity<List<MetricsResultResponseDTO>> queryAll(MetricsResultConditionsRequestDTO request);

    @ApiOperation(value = "queryListPage", notes = "QUERY_LIST_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity<PageResponseDTO<MetricsResultResponseDTO>> queryListPage(MetricsResultConditionsRequestDTO request);

}
