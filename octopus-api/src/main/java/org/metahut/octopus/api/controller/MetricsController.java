package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(tags = "METRICS_TAG")
@RequestMapping("metrics")
@Validated
public interface MetricsController {

    @ApiOperation(value = "findByCode", notes = "QUERY_METRICS_BY_CODE_NOTES")
    @GetMapping("{code}")
    ResultEntity<MetricsResponseDTO> findByCode(@PathVariable String code);

    @ApiOperation(value = "queryList", notes = "QUERY_METRICS_LIST_NOTES")
    @GetMapping("queryList")
    ResultEntity<List<MetricsResponseDTO>> queryList(MetricsConditionsRequestDTO requestDTO);

    @ApiOperation(value = "queryListPage", notes = "QUERY_METRICS_LIST_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity<PageResponseDTO<MetricsResponseDTO>> queryListPage(MetricsConditionsRequestDTO metricsConditionsRequestDTO);

    @ApiOperation(value = "create", notes = "CREATE_METRICS_NOTES")
    @PostMapping("create")
    ResultEntity<MetricsResponseDTO> create(@RequestBody @Validated MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO);

    @ApiOperation(value = "update", notes = "UPDATE_METRICS_NOTES")
    @PutMapping("update")
    ResultEntity<MetricsResponseDTO> update(@RequestBody @Validated({MetricsCreateOrUpdateRequestDTO.Update.class}) MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO);

    @ApiOperation(value = "deleteById", notes = "DELETE_METRICS_BY_ID_NOTES")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "METRICS_ID", required = true, dataType = "Integer", example = "1")
    })
    @DeleteMapping("{id}")
    ResultEntity deleteById(@PathVariable(value = "id") Integer id);
}
