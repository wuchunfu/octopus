package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.SourceAlertRelationCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.SourceAlertRelation;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SourceAlertRelationFromDTOConverter extends Converter<SourceAlertRelationCreateOrUpdateRequestDTO, SourceAlertRelation> {

    List<SourceAlertRelation> convert(List<SourceAlertRelationCreateOrUpdateRequestDTO> sources);
}
