package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.RuleInstanceController;
import org.metahut.octopus.api.dto.AlertGroupResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.PrepTimeRequestDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.SampleInstanceResponseDTO;
import org.metahut.octopus.server.service.RuleInstanceService;
import org.metahut.octopus.server.utils.SnowflakeIdGenerator;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RuleInstanceControllerImpl implements RuleInstanceController {

    private final RuleInstanceService ruleInstanceService;

    public RuleInstanceControllerImpl(RuleInstanceService ruleInstanceService) {
        this.ruleInstanceService = ruleInstanceService;
    }

    @Override
    public ResultEntity<List<RuleInstanceResponseDTO>> batchCreate(List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstanceCreateOrUpdateRequestDTOS) {
        ruleInstanceCreateOrUpdateRequestDTOS.forEach(item -> item.setCode(SnowflakeIdGenerator.getInstance().nextId()));
        return ResultEntity.success(ruleInstanceService.batchCreate(ruleInstanceCreateOrUpdateRequestDTOS));
    }

    @Override
    public ResultEntity deleteById(Integer id) {
        return ResultEntity.success(id);
    }

    @Override
    public ResultEntity<RuleInstanceResponseDTO> update(RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO) {
        return ResultEntity.success(ruleInstanceService.update(ruleInstanceCreateOrUpdateRequestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>> queryListPage(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO) {
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
    public ResultEntity prepRun(RuleInstanceCreateOrUpdateRequestDTO ruleInstanceCreateOrUpdateRequestDTO) {
        return ResultEntity.success();
    }

    @Override
    public ResultEntity getPrepTime(PrepTimeRequestDTO prepTimeRequestDTO) {
        return ResultEntity.success();
    }
}
