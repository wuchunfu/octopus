package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;
import org.metahut.octopus.dao.entity.RuleTemplate;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RuleTemplateToDTOConverter  extends Converter<RuleTemplate, RuleTemplateResponseDTO> {
    List<RuleTemplateResponseDTO> convert(List<RuleTemplate> sources);
}
