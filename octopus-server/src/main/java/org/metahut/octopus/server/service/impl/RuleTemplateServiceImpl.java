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
import org.metahut.octopus.server.service.RuleTemplateService;
import org.metahut.octopus.server.utils.Assert;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.metahut.octopus.common.enums.StatusEnum.RULE_TEMPLATE_EXIST;

@Service
public class RuleTemplateServiceImpl implements RuleTemplateService {

    private final RuleTemplateRespository ruleTemplateRespository;
    private final ConversionService conversionService;

    public RuleTemplateServiceImpl(RuleTemplateRespository ruleTemplateRespository, ConversionService conversionService) {
        this.ruleTemplateRespository = ruleTemplateRespository;
        this.conversionService = conversionService;
    }

    @Override
    public PageResponseDTO<RuleTemplateResponseDTO> queryListPage(RuleTemplateConditionRequestDTO ruleTemplateRequestDTO) {
        Sort.TypedSort<RuleTemplate> typedSort = Sort.sort(RuleTemplate.class);
        Sort sort = typedSort.by(RuleTemplate::getUpdateTime).descending();
        Pageable pageable = PageRequest.of(ruleTemplateRequestDTO.getPageNo() - 1, ruleTemplateRequestDTO.getPageSize(), sort);
        Page<RuleTemplate> ruleTemplatePage = ruleTemplateRespository.findAll(withConditions(ruleTemplateRequestDTO), pageable);
        List<RuleTemplateResponseDTO> convert = (List<RuleTemplateResponseDTO>) conversionService.convert(ruleTemplatePage.getContent(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleTemplate.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleTemplateResponseDTO.class)));
        return PageResponseDTO.of(ruleTemplateRequestDTO.getPageNo(), ruleTemplatePage.getSize(), ruleTemplatePage.getTotalElements(), convert);
    }

    private Specification<RuleTemplate> withConditions(RuleTemplateConditionRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(RuleTemplate_.name), "%" + requestDTO.getName() + "%"));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getSubjectCategories())) {
                conditions.add(root.get(RuleTemplate_.subjectCategory).as(SubjectCategoryEnum.class).in(requestDTO.getSubjectCategories()));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getCheckTypes())) {
                conditions.add(root.get(RuleTemplate_.checkType).as(String.class).in(requestDTO.getCheckTypes()));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getCheckMethods())) {
                conditions.add(root.get(RuleTemplate_.checkMethod).as(String.class).in(requestDTO.getCheckMethods()));
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
        if (StringUtils.isNotBlank(ruleTemplateRequestDTO.getName())) {
            RuleTemplate ruleTemplate = new RuleTemplate();
            ruleTemplate.setName(ruleTemplateRequestDTO.getName());
            Optional<RuleTemplate> optional = ruleTemplateRespository.findOne(Example.of(ruleTemplate));
            Assert.notPresent(optional, RULE_TEMPLATE_EXIST, ruleTemplate.getName());
        }
        RuleTemplate ruleTemplate = conversionService.convert(ruleTemplateRequestDTO, RuleTemplate.class);
        RuleTemplate save = ruleTemplateRespository.save(ruleTemplate);
        return conversionService.convert(save, RuleTemplateResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        ruleTemplateRespository.deleteById(id);
    }

    @Override
    public List<RuleTemplateResponseDTO> findList(RuleTemplateConditionRequestDTO ruleTemplateRequest) {
        return (List<RuleTemplateResponseDTO>) conversionService.convert(ruleTemplateRespository.findAll(withConditions(ruleTemplateRequest)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleTemplate.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleTemplateResponseDTO.class)));
    }

    @Override
    public long count(RuleTemplateConditionRequestDTO ruleTemplateRequestDTO) {
        return ruleTemplateRespository.count(countConditions(ruleTemplateRequestDTO));
    }

    private Specification<RuleTemplate> countConditions(RuleTemplateConditionRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            if (StringUtils.isNotBlank(requestDTO.getMetricsCode())) {
                conditions.add(builder.equal(root.get(RuleTemplate_.metrics).get(Metrics_.code), requestDTO.getMetricsCode()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

}
