package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaSchemaSingleResponseDTO;
import org.metahut.octopus.meta.api.MetaSchemaEntity;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface MetaSchemaEntityToDTOConverter extends Converter<MetaSchemaEntity, MetaSchemaSingleResponseDTO> {

    Collection<MetaSchemaSingleResponseDTO> convert(Collection<MetaSchemaEntity> sources);
}
