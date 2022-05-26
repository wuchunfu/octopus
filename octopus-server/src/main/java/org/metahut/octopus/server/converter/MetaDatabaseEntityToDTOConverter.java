package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaDatabaseResponseDTO;
import org.metahut.octopus.meta.api.MetaDatabaseEntity;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface MetaDatabaseEntityToDTOConverter extends Converter<MetaDatabaseEntity, MetaDatabaseResponseDTO> {

    Collection<MetaDatabaseResponseDTO> convert(Collection<MetaDatabaseEntity> sources);
}
