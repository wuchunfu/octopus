package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
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

@Api(tags = "ALERTER_TAG")
@RequestMapping("alerter")
public interface AlerterInstanceController {

    @ApiOperation(value = "queryAllPluginTypes", notes = "ALERTER_PLUGIN_QUERY_ALL_TYPE_NOTES")
    @GetMapping("queryAllPluginTypes")
    ResultEntity<Collection<String>> queryAllPluginTypes();

    @ApiOperation(value = "queryListPage", notes = "ALERTER_INSTANCE_QUERY_LIST_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity queryListPage(AlerterInstanceConditionsRequestDTO requestDTO);

    @ApiOperation(value = "queryList", notes = "ALERTER_INSTANCE_QUERY_LIST_NOTES")
    @GetMapping("queryList")
    ResultEntity queryList(AlerterInstanceConditionsRequestDTO requestDTO);

    @ApiOperation(value = "create", notes = "ALERTER_INSTANCE_CREATE_NOTES")
    @PostMapping("create")
    ResultEntity<AlerterInstanceResponseDTO> create(@RequestBody AlerterInstanceCreateOrUpdateRequestDTO requestDTO);

    @ApiOperation(value = "update", notes = "ALERTER_INSTANCE_UPDATE_NOTES")
    @PutMapping("update")
    ResultEntity<AlerterInstanceResponseDTO> update(@RequestBody AlerterInstanceCreateOrUpdateRequestDTO requestDTO);

    @ApiOperation(value = "deleteById", notes = "DELETE_ALERTER_INSTANCE_BY_ID_NOTES")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "ALERTER_INSTANCE_ID", required = true, dataType = "Integer", example = "1")
    })
    @DeleteMapping("{id}")
    ResultEntity deleteById(@PathVariable(value = "id") Integer id);
}
