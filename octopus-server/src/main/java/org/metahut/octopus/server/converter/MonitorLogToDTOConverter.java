package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorLogResponseDTO;
import org.metahut.octopus.monitordb.api.MonitorLog;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonitorLogToDTOConverter extends Converter<MonitorLog, MonitorLogResponseDTO> {

    List<MonitorLogResponseDTO> convert(List<MonitorLog> sources);
}
