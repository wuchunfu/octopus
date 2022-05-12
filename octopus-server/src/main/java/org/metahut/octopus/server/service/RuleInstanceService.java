package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;

import java.util.List;

public interface RuleInstanceService {

    PageResponseDTO<RuleInstanceResponseDTO> queryListPage(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO);

    RuleInstanceResponseDTO createOrUpdate(List<RuleInstanceRequestDTO> ruleInstanceRequestDTO);

    void deleteById(Integer id);
}
