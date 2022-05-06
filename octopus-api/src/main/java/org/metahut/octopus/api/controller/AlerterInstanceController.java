package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceCreateRequestDTO;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Api(tags = "ALERTER_TAG")
@RequestMapping("alerter")
public interface AlerterInstanceController {

    @ApiOperation(value = "queryAllPluginTypes", notes = "QUERY_ALERTER_PLUGIN_ALL_TYPE_NOTES")
    @GetMapping("queryAllPluginTypes")
    ResultEntity<Collection<String>> queryAllPluginTypes();

    @ApiOperation(value = "queryListPage", notes = "QUERY_ALERTER_INSTANCE_LIST_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity queryListPage(@RequestBody PageRequestDTO<AlerterInstanceConditionsRequestDTO> pageRequestDTO);

    @ApiOperation(value = "queryList", notes = "QUERY_ALERTER_INSTANCE_LIST_NOTES")
    @GetMapping("queryList")
    ResultEntity queryList(@RequestBody AlerterInstanceConditionsRequestDTO alerterInstanceConditionsRequestDTO);

    @ApiOperation(value = "create", notes = "CREATE_ALERTER_INSTANCE_NOTES")
    @PostMapping("create")
    ResultEntity create(@RequestBody AlerterInstanceCreateRequestDTO alerterInstanceCreateRequestDTO);

    @ApiOperation(value = "deleteById", notes = "DELETE_ALERTER_INSTANCE_BY_ID_NOTES")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "ALERTER_INSTANCE_ID", required = true, dataType = "Integer", example = "1")
    })
    @DeleteMapping("{id}")
    ResultEntity deleteById(@PathVariable(value = "id") Integer id);
}
