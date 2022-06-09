package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaDatasourceTypeRequestDTO;
import org.metahut.octopus.meta.api.MetaDatasourceTypeRequest;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MetaDatasourceTypeToDTOConverter extends Converter<MetaDatasourceTypeRequestDTO, MetaDatasourceTypeRequest> {
}
