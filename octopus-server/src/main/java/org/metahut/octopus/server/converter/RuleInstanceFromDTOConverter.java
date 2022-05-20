package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.RuleInstance;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RuleInstanceFromDTOConverter extends Converter<RuleInstanceCreateOrUpdateRequestDTO, RuleInstance> {

    List<RuleInstance> convert(List<RuleInstanceCreateOrUpdateRequestDTO> sources);
}
