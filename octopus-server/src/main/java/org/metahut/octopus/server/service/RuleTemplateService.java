package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleTemplateConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;

import java.util.List;

public interface RuleTemplateService {

    PageResponseDTO<RuleTemplateResponseDTO> queryListPage(RuleTemplateConditionRequestDTO ruleTemplateRequestDTO);

    RuleTemplateResponseDTO createOrUpdate(RuleTemplateCreateOrUpdateRequestDTO ruleTemplateRequestDTO);

    void deleteById(Integer id);

    List<RuleTemplateResponseDTO> findList(RuleTemplateConditionRequestDTO ruleTemplateRequest);

    long count(RuleTemplateConditionRequestDTO ruleTemplateRequestDTO);
}
