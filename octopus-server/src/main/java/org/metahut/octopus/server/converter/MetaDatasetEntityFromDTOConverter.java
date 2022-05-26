package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaDatasetRequestDTO;
import org.metahut.octopus.meta.api.MetaDatasetEntityRequest;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MetaDatasetEntityFromDTOConverter extends Converter<MetaDatasetRequestDTO, MetaDatasetEntityRequest> {
}
