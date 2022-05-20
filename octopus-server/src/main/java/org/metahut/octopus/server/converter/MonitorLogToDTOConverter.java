package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.monitordb.api.entity.MonitorLog;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface MonitorLogToDTOConverter extends Converter<MonitorLog, MonitorLogResponseDTO> {
}
