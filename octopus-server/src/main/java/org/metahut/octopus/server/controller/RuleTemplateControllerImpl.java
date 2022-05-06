package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.RuleTemplateController;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleTemplateRequestDTO;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleTemplateControllerImpl implements RuleTemplateController {

    private final RuleTemplateController ruleTemplateController;

    public RuleTemplateControllerImpl(RuleTemplateController ruleTemplateController) {
        this.ruleTemplateController = ruleTemplateController;
    }

    @Override
    public ResultEntity queryRuleTemplatePage(PageRequestDTO<RuleTemplateRequestDTO> ruleTemplateRequest) {
        return ResultEntity.success(ruleTemplateController.queryRuleTemplatePage(ruleTemplateRequest));
    }

    @Override
    public ResultEntity deleteRuleTemplate(Integer id) {
        return ResultEntity.success(ruleTemplateController.deleteRuleTemplate(id));
    }

    @Override
    public ResultEntity createRuleTemplate(RuleTemplateRequestDTO ruleTemplateRequest) {
        return ResultEntity.success(ruleTemplateController.createRuleTemplate(ruleTemplateRequest));
    }

    @Override
    public ResultEntity updateRuleTemplate(RuleTemplateRequestDTO ruleTemplateRequest) {
        return ResultEntity.success(ruleTemplateController.updateRuleTemplate(ruleTemplateRequest));
    }
}
