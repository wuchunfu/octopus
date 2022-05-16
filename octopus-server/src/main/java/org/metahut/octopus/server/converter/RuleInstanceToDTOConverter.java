package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.dao.entity.RuleInstance;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RuleInstanceToDTOConverter extends Converter<RuleInstance, RuleInstanceResponseDTO> {

    List<RuleInstanceResponseDTO> convert(List<RuleInstance> sources);
}
