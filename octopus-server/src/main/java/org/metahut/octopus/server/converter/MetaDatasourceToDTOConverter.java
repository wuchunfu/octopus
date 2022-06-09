package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaDatasourceRequestDTO;
import org.metahut.octopus.meta.api.MetaDatasourceRequest;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MetaDatasourceToDTOConverter extends Converter<MetaDatasourceRequestDTO, MetaDatasourceRequest> {
}
