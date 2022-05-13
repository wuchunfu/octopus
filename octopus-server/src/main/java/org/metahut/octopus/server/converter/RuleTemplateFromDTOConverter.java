package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleTemplateCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.RuleTemplate;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface RuleTemplateFromDTOConverter extends Converter<RuleTemplateCreateOrUpdateRequestDTO, RuleTemplate> {
}
