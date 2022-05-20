package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.RuleTemplateController;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleTemplateConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;
import org.metahut.octopus.server.service.RuleTemplateService;
import org.metahut.octopus.server.utils.SnowflakeIdGenerator;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RuleTemplateControllerImpl implements RuleTemplateController {

    private final RuleTemplateService ruleTemplateService;

    public RuleTemplateControllerImpl(RuleTemplateService ruleTemplateService) {
        this.ruleTemplateService = ruleTemplateService;
    }

    @Override
    public ResultEntity<PageResponseDTO<RuleTemplateResponseDTO>> queryListPage(RuleTemplateConditionRequestDTO ruleTemplateRequestDTO) {
        return ResultEntity.success(ruleTemplateService.queryListPage(ruleTemplateRequestDTO));
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        ruleTemplateService.deleteById(id);
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<RuleTemplateResponseDTO> create(RuleTemplateCreateOrUpdateRequestDTO ruleTemplateRequest) {
        ruleTemplateRequest.setCode(SnowflakeIdGenerator.getInstance().nextId());
        return ResultEntity.success(ruleTemplateService.createOrUpdate(ruleTemplateRequest));
    }

    @Override
    public ResultEntity<RuleTemplateResponseDTO> update(RuleTemplateCreateOrUpdateRequestDTO ruleTemplateRequest) {
        return ResultEntity.success(ruleTemplateService.createOrUpdate(ruleTemplateRequest));
    }

    @Override
    public ResultEntity<List<RuleTemplateResponseDTO>> queryList(RuleTemplateConditionRequestDTO ruleTemplateRequest) {
        return ResultEntity.success(ruleTemplateService.findList(ruleTemplateRequest));
    }

}
