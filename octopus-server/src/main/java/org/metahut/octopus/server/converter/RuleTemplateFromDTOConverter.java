package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.RuleTemplateCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.RuleTemplate;
import org.metahut.octopus.server.service.MetricsService;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring", uses = {MetricsService.class})
public interface RuleTemplateFromDTOConverter extends Converter<RuleTemplateCreateOrUpdateRequestDTO, RuleTemplate> {

    @Mapping(source = "metricsCode", target = "metrics")
    RuleTemplate convert(RuleTemplateCreateOrUpdateRequestDTO source);

    @AfterMapping
    default void nameHandler(@MappingTarget RuleTemplate ruleTemplate) {
        ruleTemplate.setName(StringUtils.joinWith("_", ruleTemplate.getSubjectCategory(), ruleTemplate.getMetrics().getCode(), ruleTemplate.getComparisonMethod()));
    }
}
