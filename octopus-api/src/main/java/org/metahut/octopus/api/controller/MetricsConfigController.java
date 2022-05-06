package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MetricsConfigConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "METRICS_CONFIG_TAG")
@RequestMapping("metricsConfig")
public interface MetricsConfigController {

    @ApiOperation(value = "queryAll", notes = "QUERY_ALL_NOTES")
    @GetMapping("queryAll")
    ResultEntity queryAll();

    @ApiOperation(value = "queryListPage", notes = "QUERY_METRICS_CONFIG_LIST_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity queryListPage(@RequestBody PageRequestDTO<MetricsConfigConditionsRequestDTO> pageRequestDTO);

    @ApiOperation(value = "create", notes = "CREATE_METRICS_CONFIG_NOTES")
    @PostMapping("create")
    ResultEntity create(@RequestBody MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO);

    @ApiOperation(value = "update", notes = "UPDATE_METRICS_CONFIG_NOTES")
    @PutMapping("update")
    ResultEntity update(@RequestBody MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO);

    @ApiOperation(value = "deleteById", notes = "DELETE_METRICS_CONFIG_BY_ID_NOTES")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "METRICS_CONFIG_ID", required = true, dataType = "Integer", example = "1")
    })
    @DeleteMapping("{id}")
    ResultEntity deleteById(@PathVariable(value = "id") Integer id);
}
