package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.RuleInstanceController;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;

public class RuleInstanceControllerImpl implements RuleInstanceController {
    @Override
    public ResultEntity<RuleInstanceResponseDTO> createRuleInstance(RuleInstanceRequestDTO ruleInstanceRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity deleteRuleInstance(Integer id) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<RuleInstanceResponseDTO> updateRuleInstance(RuleInstanceRequestDTO ruleInstanceRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>> queryRuleInstancePage(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO) {
        return ResultEntity.success();
    }
}
