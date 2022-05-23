package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AlerterInstanceFromDTOConverter extends Converter<AlerterInstanceCreateOrUpdateRequestDTO, AlerterInstance> {
}
