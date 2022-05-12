package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.dao.entity.RuleInstance;
import org.metahut.octopus.dao.repository.RuleInstanceRespository;
import org.metahut.octopus.server.service.RuleInstanceService;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleInstanceServiceImpl implements RuleInstanceService {

    private final RuleInstanceRespository ruleInstanceRespository;
    private final ConversionService conversionService;

    public RuleInstanceServiceImpl(RuleInstanceRespository ruleInstanceRespository, ConversionService conversionService) {
        this.ruleInstanceRespository = ruleInstanceRespository;
        this.conversionService = conversionService;
    }

    @Override
    public PageResponseDTO<RuleInstanceResponseDTO> queryListPage(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO) {

        return null;
    }

    private Specification<RuleInstance> withConditions(RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    public RuleInstanceResponseDTO createOrUpdate(List<RuleInstanceRequestDTO> ruleInstanceRequestDTO) {
        RuleInstance convert = conversionService.convert(ruleInstanceRequestDTO, RuleInstance.class);
        RuleInstance save = ruleInstanceRespository.save(convert);
        return conversionService.convert(save, RuleInstanceResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        ruleInstanceRespository.deleteById(id);
    }
}
