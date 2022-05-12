package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.RuleInstanceController;
import org.metahut.octopus.api.dto.AlertGroupResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.PrepTimeRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.SampleInstanceResponseDTO;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RuleInstanceControllerImpl implements RuleInstanceController {
    @Override
    public ResultEntity batchCreateRuleInstance(List<RuleInstanceRequestDTO> ruleInstanceRequestDTOs) {
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

    @Override
    public ResultEntity<SampleInstanceResponseDTO> querySampleInstanceList(Integer code) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity queryPartitionExpression(Integer code) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<AlertGroupResponseDTO> queryAlertGroup() {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity prepRun(RuleInstanceRequestDTO ruleInstanceRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity getPrepTime(PrepTimeRequestDTO prepTimeRequestDTO) {
        return ResultEntity.success();
    }
}
