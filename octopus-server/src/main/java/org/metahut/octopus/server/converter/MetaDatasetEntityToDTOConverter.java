package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.meta.api.MetaDatasetEntity;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface MetaDatasetEntityToDTOConverter extends Converter<MetaDatasetEntity, MetaDatasetResponseDTO> {

    Collection<MetaDatasetResponseDTO> convert(Collection<MetaDatasetEntity> sources);
}
