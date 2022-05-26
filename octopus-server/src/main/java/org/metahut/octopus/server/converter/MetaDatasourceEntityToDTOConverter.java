package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaDatasourceResponseDTO;
import org.metahut.octopus.meta.api.MetaDatasourceEntity;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface MetaDatasourceEntityToDTOConverter extends Converter<MetaDatasourceEntity, MetaDatasourceResponseDTO> {

    Collection<MetaDatasourceResponseDTO> convert(Collection<MetaDatasourceEntity> sources);
}
