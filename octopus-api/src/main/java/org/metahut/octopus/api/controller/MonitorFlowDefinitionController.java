package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.MonitorFlowDefinitionConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "MONITOR_FLOW_DEFINITION_TAG")
@RequestMapping("monitorFlowDefinition")
@Validated
public interface MonitorFlowDefinitionController {

    @ApiOperation(value = "queryListPage", notes = "MONITOR_FLOW_DEFINITION_QUERY_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity<PageResponseDTO<MonitorFlowDefinitionResponseDTO>> queryListPage(MonitorFlowDefinitionConditionsRequestDTO requestDTO);

    @ApiOperation(value = "deleteById", notes = "MONITOR_FLOW_DEFINITION_DELETE_BY_ID_NOTES")
    @DeleteMapping("{id}")
    ResultEntity deleteById(@PathVariable(value = "id") Integer id);

    @ApiOperation(value = "create", notes = "MONITOR_FLOW_DEFINITION_CREATE_NOTES")
    @PostMapping("create")
    ResultEntity<MonitorFlowDefinitionResponseDTO> create(@RequestBody @Validated MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO);

    @ApiOperation(value = "update", notes = "MONITOR_FLOW_DEFINITION_UPDATE_NOTES")
    @PutMapping("update")
    ResultEntity<MonitorFlowDefinitionResponseDTO> update(@RequestBody @Validated(MonitorFlowDefinitionCreateOrUpdateRequestDTO.Update.class) MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO);

    @ApiOperation(value = "testRun", notes = "MONITOR_FLOW_DEFINITION_TEST_RUN_NOTES")
    @GetMapping("testRun/{code}")
    ResultEntity testRun(@PathVariable(value = "code") Long code);

}
