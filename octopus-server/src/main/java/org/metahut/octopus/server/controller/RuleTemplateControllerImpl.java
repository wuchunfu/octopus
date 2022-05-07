package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.RuleTemplateController;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleTemplateRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;
import org.metahut.octopus.api.dto.response.PageResponseDTO;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RuleTemplateControllerImpl implements RuleTemplateController {

    @Override
    public ResultEntity<PageResponseDTO<RuleTemplateResponseDTO>> queryRuleTemplatePage(PageRequestDTO<RuleTemplateRequestDTO> ruleTemplateRequest) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<Boolean> deleteRuleTemplate(Integer id) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<RuleTemplateResponseDTO> createRuleTemplate(RuleTemplateRequestDTO ruleTemplateRequest) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<RuleTemplateResponseDTO> updateRuleTemplate(RuleTemplateRequestDTO ruleTemplateRequest) {
        return ResultEntity.success();
    }
}
