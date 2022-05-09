package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AlerterInstanceToDTOConverter extends Converter<AlerterInstance, AlerterInstanceResponseDTO> {

}
