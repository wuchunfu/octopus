package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.RuleInstanceController;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleExistConditionDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceSingleCreateOrUpdateRequestDTO;
import org.metahut.octopus.server.service.RuleInstanceService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleInstanceControllerImpl implements RuleInstanceController {

    private final RuleInstanceService ruleInstanceService;

    public RuleInstanceControllerImpl(RuleInstanceService ruleInstanceService) {
        this.ruleInstanceService = ruleInstanceService;
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        ruleInstanceService.deleteById(id);
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<RuleInstanceResponseDTO> create(RuleInstanceSingleCreateOrUpdateRequestDTO requestDTO) {
        return ResultEntity.success(ruleInstanceService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity<RuleInstanceResponseDTO> update(RuleInstanceSingleCreateOrUpdateRequestDTO requestDTO) {
        return ResultEntity.success(ruleInstanceService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity checkExistRule(RuleExistConditionDTO ruleExistConditionDTO) {
        ruleInstanceService.checkExistRule(ruleExistConditionDTO);
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>> queryListPage(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO) {
        return ResultEntity.success(ruleInstanceService.queryListPage(ruleInstanceConditionRequestDTO));
    }

    @Override
    public ResultEntity<Long> queryRuleInstanceCount(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO) {
        return ResultEntity.success(ruleInstanceService.count(ruleInstanceConditionRequestDTO));
    }
}
