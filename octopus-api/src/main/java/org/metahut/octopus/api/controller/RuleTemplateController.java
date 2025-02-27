package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleTemplateConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;

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

@Api(tags = "RULE_TEMPLATE_TAG")
@RequestMapping("ruleTemplate")
@Validated
public interface RuleTemplateController {

    @ApiOperation(value = "queryListPage", notes = "QUERY_RULE_TEMPLATE_PAGE_NOTES")
    @GetMapping("/queryListPage")
    ResultEntity<PageResponseDTO<RuleTemplateResponseDTO>> queryListPage(RuleTemplateConditionRequestDTO ruleTemplateRequest);

    @ApiOperation(value = "deleteById", notes = "DELETE_RULE_TEMPLATE_NOTES")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "RULE_TEMPLATE_ID", required = true, dataType = "Integer", example = "1")
    })
    @DeleteMapping("{id}")
    ResultEntity deleteById(@PathVariable(value = "id") Integer id);

    @ApiOperation(value = "create", notes = "CREATE_RULE_TEMPLATE_NOTES")
    @PostMapping
    ResultEntity<RuleTemplateResponseDTO> create(@RequestBody @Validated RuleTemplateCreateOrUpdateRequestDTO ruleTemplateRequest);

    @ApiOperation(value = "update", notes = "UPDATE_RULE_TEMPLATE_NOTES")
    @PutMapping
    ResultEntity<RuleTemplateResponseDTO> update(@RequestBody @Validated RuleTemplateCreateOrUpdateRequestDTO ruleTemplateRequest);

    @ApiOperation(value = "queryList", notes = "QUERY_LIST_NOTES")
    @GetMapping("/queryList")
    ResultEntity<List<RuleTemplateResponseDTO>> queryList(RuleTemplateConditionRequestDTO ruleTemplateRequest);
}
