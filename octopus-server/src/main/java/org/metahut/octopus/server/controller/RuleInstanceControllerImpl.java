package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.RuleInstanceController;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.server.service.RuleInstanceService;
import org.metahut.octopus.server.utils.SnowflakeIdGenerator;

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
    public ResultEntity<RuleInstanceResponseDTO> create(RuleInstanceCreateOrUpdateRequestDTO requestDTO) {
        requestDTO.setCode(SnowflakeIdGenerator.getInstance().nextId());
        return ResultEntity.success(ruleInstanceService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity<RuleInstanceResponseDTO> update(RuleInstanceCreateOrUpdateRequestDTO requestDTO) {
        return ResultEntity.success(ruleInstanceService.createOrUpdate(requestDTO));
    }

    @Override
    public ResultEntity<PageResponseDTO<RuleInstanceResponseDTO>> queryListPage(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO) {
        return ResultEntity.success(ruleInstanceService.queryListPage(ruleInstanceConditionRequestDTO));
    }

}
