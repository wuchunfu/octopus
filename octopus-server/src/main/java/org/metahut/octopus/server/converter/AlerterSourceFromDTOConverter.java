package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.AlerterSourceCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.AlerterSource;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AlerterSourceFromDTOConverter extends Converter<AlerterSourceCreateOrUpdateRequestDTO, AlerterSource> {
}
