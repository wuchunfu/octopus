package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.AlerterSourceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
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

import java.util.Collection;

@Api(tags = "ALERTER_SOURCE_TAG")
@RequestMapping("alerterSource")
public interface AlerterSourceController {

    @ApiOperation(value = "queryAllPluginTypes", notes = "ALERTER_PLUGIN_QUERY_ALL_TYPE_NOTES")
    @GetMapping("queryAllPluginTypes")
    ResultEntity<Collection<String>> queryAllPluginTypes();

    @ApiOperation(value = "queryListPage", notes = "ALERTER_SOURCE_QUERY_LIST_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity queryListPage(AlerterSourceConditionsRequestDTO requestDTO);

    @ApiOperation(value = "queryList", notes = "ALERTER_SOURCE_QUERY_LIST_NOTES")
    @GetMapping("queryList")
    ResultEntity queryList(AlerterSourceConditionsRequestDTO requestDTO);

    @ApiOperation(value = "create", notes = "ALERTER_SOURCE_CREATE_NOTES")
    @PostMapping("create")
    ResultEntity<AlerterSourceResponseDTO> create(@RequestBody AlerterSourceCreateOrUpdateRequestDTO requestDTO);

    @ApiOperation(value = "update", notes = "ALERTER_SOURCE_UPDATE_NOTES")
    @PutMapping("update")
    ResultEntity<AlerterSourceResponseDTO> update(@RequestBody AlerterSourceCreateOrUpdateRequestDTO requestDTO);

    @ApiOperation(value = "deleteById", notes = "DELETE_ALERTER_SOURCE_BY_ID_NOTES")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "ALERTER_SOURCE_ID", required = true, dataType = "Integer", example = "1")
    })
    @DeleteMapping("{id}")
    ResultEntity deleteById(@PathVariable(value = "id") Integer id);
}
