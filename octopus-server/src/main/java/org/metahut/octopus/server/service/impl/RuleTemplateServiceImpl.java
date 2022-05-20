package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleTemplateConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateResponseDTO;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.entity.Metrics_;
import org.metahut.octopus.dao.entity.RuleTemplate;
import org.metahut.octopus.dao.entity.RuleTemplate_;
import org.metahut.octopus.dao.repository.RuleTemplateRespository;
import org.metahut.octopus.server.service.MetricsService;
import org.metahut.octopus.server.service.RuleTemplateService;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RuleTemplateServiceImpl implements RuleTemplateService {

    private final RuleTemplateRespository ruleTemplateRespository;
    private final ConversionService conversionService;
    private final MetricsService metricsService;

    public RuleTemplateServiceImpl(RuleTemplateRespository ruleTemplateRespository, ConversionService conversionService, MetricsService metricsService) {
        this.ruleTemplateRespository = ruleTemplateRespository;
        this.conversionService = conversionService;
        this.metricsService = metricsService;
    }

    @Override
    public PageResponseDTO<RuleTemplateResponseDTO> queryListPage(RuleTemplateConditionRequestDTO ruleTemplateRequestDTO) {
        Pageable pageable = PageRequest.of(ruleTemplateRequestDTO.getPageNo() - 1, ruleTemplateRequestDTO.getPageSize());
        Page<RuleTemplate> ruleTemplatePage = ruleTemplateRespository.findAll(withConditions(ruleTemplateRequestDTO), pageable);
        List<RuleTemplateResponseDTO> convert = (List<RuleTemplateResponseDTO>)conversionService.convert(ruleTemplateRespository.findAll(withConditions(ruleTemplateRequestDTO)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleTemplate.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleTemplateResponseDTO.class)));
        return PageResponseDTO.of(ruleTemplateRequestDTO.getPageNo(), ruleTemplateRequestDTO.getPageSize(), ruleTemplatePage.getTotalElements(), convert);
    }

    private Specification<RuleTemplate> withConditions(RuleTemplateConditionRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(RuleTemplate_.name), "%" + requestDTO.getName() + "%"));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getSubjectCategories())) {
                conditions.add(builder.in(root.get(RuleTemplate_.subjectCategory).as(SubjectCategoryEnum.class).in(requestDTO.getSubjectCategories())));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getCheckTypes())) {
                conditions.add(builder.in(root.get(RuleTemplate_.checkType).as(String.class).in(requestDTO.getCheckTypes())));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getCheckMethods())) {
                conditions.add(builder.in(root.get(RuleTemplate_.checkMethod).as(String.class).in(requestDTO.getCheckMethods())));
            }

            if (Objects.nonNull(requestDTO.getCreateStartTime()) && Objects.nonNull(requestDTO.getCreateEndTime())) {
                conditions.add(builder.between(root.get(RuleTemplate_.createTime), requestDTO.getCreateStartTime(), requestDTO.getCreateEndTime()));
            }

            if (Objects.nonNull(requestDTO.getUpdateStartTime()) && Objects.nonNull(requestDTO.getUpdateEndTime())) {
                conditions.add(builder.between(root.get(RuleTemplate_.updateTime), requestDTO.getUpdateStartTime(), requestDTO.getUpdateEndTime()));
            }

            Join<RuleTemplate, Metrics> metricsJoin = root.join(RuleTemplate_.metrics, JoinType.INNER);
            if (StringUtils.isNotBlank(requestDTO.getMetricsCode())) {
                conditions.add(builder.like(metricsJoin.get(Metrics_.code), "%" + requestDTO.getMetricsCode() + "%"));
            }
            if (StringUtils.isNotBlank(requestDTO.getMetricsName())) {
                conditions.add(builder.like(metricsJoin.get(Metrics_.name), "%" + requestDTO.getMetricsName() + "%"));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    public RuleTemplateResponseDTO createOrUpdate(RuleTemplateCreateOrUpdateRequestDTO ruleTemplateRequestDTO) {
        Metrics metrics = metricsService.findOneByCode(ruleTemplateRequestDTO.getMetricsCode());
        RuleTemplate ruleTemplate = conversionService.convert(ruleTemplateRequestDTO, RuleTemplate.class);
        ruleTemplate.setMetrics(metrics);
        RuleTemplate save = ruleTemplateRespository.save(ruleTemplate);
        return conversionService.convert(save, RuleTemplateResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        ruleTemplateRespository.deleteById(id);
    }

    @Override
    public List<RuleTemplateResponseDTO> findList(RuleTemplateConditionRequestDTO ruleTemplateRequest) {
        return (List<RuleTemplateResponseDTO>)conversionService.convert(ruleTemplateRespository.findAll(withConditions(ruleTemplateRequest)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleTemplate.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleTemplateResponseDTO.class)));
    }

}
