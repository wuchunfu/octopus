package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaDatabaseConditionsRequestDTO;
import org.metahut.octopus.meta.api.MetaDatabaseRequest;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MetaDatasbaseToDTOConverter extends Converter<MetaDatabaseConditionsRequestDTO, MetaDatabaseRequest> {
}
