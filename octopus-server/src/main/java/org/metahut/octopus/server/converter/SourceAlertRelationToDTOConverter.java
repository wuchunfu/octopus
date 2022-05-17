package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.SourceAlertRelationResponseDTO;
import org.metahut.octopus.dao.entity.SourceAlertRelation;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;


@Mapper(componentModel = "spring")
public interface SourceAlertRelationToDTOConverter extends Converter<SourceAlertRelation, SourceAlertRelationResponseDTO> {

    List<SourceAlertRelationResponseDTO> convert(List<SourceAlertRelation> sources);
}
