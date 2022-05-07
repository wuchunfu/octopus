package org.metahut.octopus.api.controller;

import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleTemplateRequestDTO;

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

@Api(tags = "RULE_TEMPLATE_TAG")
@RequestMapping("ruleTemplate")
public interface RuleTemplateController {

    @ApiOperation(value = "queryRuleTemplatePage", notes = "QUERY_RULE_TEMPLATE_PAGE_NOTES")
    @GetMapping("/queryListPage")
    ResultEntity queryRuleTemplatePage(RuleTemplateRequestDTO ruleTemplateRequestDTO);

    @ApiOperation(value = "deleteRuleTemplate", notes = "DELETE_RULE_TEMPLATE_NOTES")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "RULE_TEMPLATE_ID", required = true, dataType = "Integer", example = "1")
    })
    @DeleteMapping("/{id}")
    ResultEntity  deleteRuleTemplate(@PathVariable(value = "id") Integer id);

    @ApiOperation(value = "createRuleTemplate", notes = "CREATE_RULE_TEMPLATE_NOTES")
    @PostMapping
    ResultEntity createRuleTemplate(@RequestBody RuleTemplateRequestDTO ruleTemplateRequest);

    @ApiOperation(value = "updateRuleTemplate", notes = "UPDATE_RULE_TEMPLATE_NOTES")
    @PutMapping("/{code}")
    ResultEntity updateRuleTemplate(@RequestBody RuleTemplateRequestDTO ruleTemplateRequest);
}
