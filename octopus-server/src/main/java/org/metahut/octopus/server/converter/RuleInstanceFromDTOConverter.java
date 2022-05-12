package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleInstanceRequestDTO;
import org.metahut.octopus.dao.entity.RuleInstance;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface RuleInstanceFromDTOConverter extends Converter<RuleInstanceRequestDTO, RuleInstance> {
}
