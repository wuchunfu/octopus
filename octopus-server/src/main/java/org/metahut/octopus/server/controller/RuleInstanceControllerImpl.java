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
import org.metahut.octopus.server.service.RuleInstanceService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RuleInstanceControllerImpl implements RuleInstanceController {

    private final RuleInstanceService ruleInstanceService;

    public RuleInstanceControllerImpl(RuleInstanceService ruleInstanceService) {
        this.ruleInstanceService = ruleInstanceService;
    }

    @Override
    public ResultEntity batchCreateRuleInstance(List<RuleInstanceRequestDTO> ruleInstanceRequestDTOs) {
        return ResultEntity.success(ruleInstanceService.createOrUpdate(ruleInstanceRequestDTOs));
    }

    @Override
    public ResultEntity deleteRuleInstance(Integer id) {
        ruleInstanceService.deleteById(id);
        return ResultEntity.success();
    }

    @Override
    public ResultEntity updateRuleInstance(List<RuleInstanceRequestDTO> ruleInstanceRequestDTO) {
        return ResultEntity.success(ruleInstanceService.createOrUpdate(ruleInstanceRequestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>> queryRuleInstancePage(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO) {
        return ResultEntity.success(ruleInstanceService.queryListPage(ruleInstanceConditionRequestDTO));
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
