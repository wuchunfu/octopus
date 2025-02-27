package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleExistConditionDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceSingleCreateOrUpdateRequestDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "RULE_INSTANCE_TAG")
@RequestMapping("ruleInstance")
public interface RuleInstanceController {

    @ApiOperation(value = "queryListPage", notes = "RULE_INSTANCE_QUERY_PAGE_NOTES")
    @GetMapping("queryListPage")
    ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>> queryListPage(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO);

    @ApiOperation(value = "deleteById", notes = "RULE_INSTANCE_DELETE_BY_ID_NOTES")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "RULE_INSTANCE_ID", required = true, dataType = "Integer", example = "1")
    })
    @DeleteMapping("{id}")
    ResultEntity deleteById(@PathVariable(value = "id") Integer id);

    @ApiOperation(value = "create", notes = "RULE_INSTANCE_CREATE_NOTES")
    @PutMapping("create")
    ResultEntity<RuleInstanceResponseDTO> create(@RequestBody @Validated RuleInstanceSingleCreateOrUpdateRequestDTO requestDTO);

    @ApiOperation(value = "update", notes = "RULE_INSTANCE_UPDATE_NOTES")
    @PutMapping("update")
    ResultEntity<RuleInstanceResponseDTO> update(@RequestBody @Validated(RuleInstanceSingleCreateOrUpdateRequestDTO.Update
            .class) RuleInstanceSingleCreateOrUpdateRequestDTO requestDTO);

    @ApiOperation(value = "check", notes = "CHECK_RULE_WHETHER_OR_NOT_NOTS")
    @GetMapping("check")
    ResultEntity checkExistRule(@Validated RuleExistConditionDTO ruleExistConditionDTO);

    @ApiOperation(value = "queryRuleInstanceCount", notes = "QUERY_RULE_INSTANCE_COUNT_NOTS")
    @GetMapping("queryRuleInstanceCount")
    ResultEntity<Long> queryRuleInstanceCount(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO);
}
