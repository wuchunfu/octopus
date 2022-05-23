package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorLogConditionsRequestDTO;
import org.metahut.octopus.monitordb.api.MonitorLogRequest;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MonitorLogRequestFromDTOConverter extends Converter<MonitorLogConditionsRequestDTO, MonitorLogRequest> {
}
