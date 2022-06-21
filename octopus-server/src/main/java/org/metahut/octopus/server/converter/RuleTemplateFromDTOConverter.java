package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleTemplateCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.RuleTemplate;
import org.metahut.octopus.server.service.MetricsService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = {MetricsService.class})
public interface RuleTemplateFromDTOConverter extends Converter<RuleTemplateCreateOrUpdateRequestDTO, RuleTemplate> {

    @Mapping(source = "metricsCode", target = "metrics")
    RuleTemplate convert(RuleTemplateCreateOrUpdateRequestDTO source);

}
