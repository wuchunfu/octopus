package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.AlertGroupResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.PrepTimeRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.SampleInstanceResponseDTO;

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

@Api(tags = "RULE_TAG")
@RequestMapping("rule")
public interface RuleInstanceController {

    @ApiOperation(value = "createRuleInstance", notes = "CREATE_RULE_INSTANCE_NOTES")
    @PostMapping
    ResultEntity<RuleInstanceResponseDTO> createRuleInstance(@RequestBody RuleInstanceRequestDTO ruleInstanceRequestDTO);

    @ApiOperation(value = "deleteRuleInstance", notes = "DELETE_RULE_INSTANCE_NOTES")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "RULE_INSTANCE_ID", required = true, dataType = "Integer", example = "1")
    })
    @DeleteMapping("/{id}")
    ResultEntity deleteRuleInstance(@PathVariable(value = "id") Integer id);

    @ApiOperation(value = "updateRuleInstance", notes = "UPDATE_RULE_INSTANCE_NOTES")
    @PutMapping("/{code}")
    ResultEntity<RuleInstanceResponseDTO> updateRuleInstance(@RequestBody RuleInstanceRequestDTO ruleInstanceRequestDTO);

    @ApiOperation(value = "queryRuleInstancePage", notes = "QUERY_RULE_INSTANCE_PAGE_NOTES")
    @GetMapping("/queryListPage")
    ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>> queryRuleInstancePage(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO);

    @ApiOperation(value = "querySampleInstance", notes = "QUERY_SAMPLE_INSTANCE_NOTES")
    @GetMapping("/sampleInstance/{code}")
    ResultEntity<SampleInstanceResponseDTO> querySampleInstanceList(@PathVariable Integer code);

    @ApiOperation(value = "queryPartitionExpression", notes = "QUERY_PARTITION_EXPRESSION_NOTES")
    @GetMapping("/partition/{code}")
    ResultEntity queryPartitionExpression(@PathVariable Integer code);

    @ApiOperation(value = "queryAlertGroup", notes = "QUERY_ALERT_GROUP_NOTES")
    @GetMapping("/alertGroup")
    ResultEntity<AlertGroupResponseDTO> queryAlertGroup();

    @ApiOperation(value = "prepRun", notes = "PREP_RUN_NOTES")
    @PutMapping("/prepRun")
    ResultEntity prepRun(@RequestBody RuleInstanceRequestDTO ruleInstanceRequestDTO);

    @ApiOperation(value = "getPrepTime", notes = "GET_PREP_TIME_NOTES")
    @GetMapping
    ResultEntity getPrepTime(@RequestBody PrepTimeRequestDTO prepTimeRequestDTO);

}
