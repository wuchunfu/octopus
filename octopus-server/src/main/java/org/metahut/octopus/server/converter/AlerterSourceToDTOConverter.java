package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
import org.metahut.octopus.dao.entity.AlerterSource;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlerterSourceToDTOConverter extends Converter<AlerterSource, AlerterSourceResponseDTO> {

    List<AlerterSourceResponseDTO> convert(List<AlerterSource> sources);
}
