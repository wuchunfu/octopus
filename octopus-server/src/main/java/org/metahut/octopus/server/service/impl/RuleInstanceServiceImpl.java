package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleExistConditionDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceSingleCreateOrUpdateRequestDTO;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.entity.Metrics_;
import org.metahut.octopus.dao.entity.RuleInstance;
import org.metahut.octopus.dao.entity.RuleInstance_;
import org.metahut.octopus.dao.repository.RuleInstanceRepository;
import org.metahut.octopus.server.service.RuleInstanceService;
import org.metahut.octopus.server.utils.Assert;

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
import java.util.stream.Collectors;

import static org.metahut.octopus.common.enums.StatusEnum.RULE_INSTANCE_EXIST;

@Service
public class RuleInstanceServiceImpl implements RuleInstanceService {

    private final RuleInstanceRepository ruleInstanceRepository;
    private final ConversionService conversionService;

    public RuleInstanceServiceImpl(RuleInstanceRepository ruleInstanceRepository,
                                   ConversionService conversionService) {
        this.ruleInstanceRepository = ruleInstanceRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PageResponseDTO<RuleInstanceResponseDTO> queryListPage(RuleInstanceConditionRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize());
        Page<RuleInstance> ruleInstancePage = ruleInstanceRepository.findAll(withConditions(requestDTO), pageable);
        List<RuleInstanceResponseDTO> convert = (List<RuleInstanceResponseDTO>) conversionService.convert(ruleInstanceRepository.findAll(withConditions(requestDTO)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleInstance.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleInstanceResponseDTO.class)));
        return PageResponseDTO.of(requestDTO.getPageNo(), ruleInstancePage.getSize(), ruleInstancePage.getTotalElements(), convert);
    }

    private Specification<RuleInstance> withConditions(RuleInstanceConditionRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            if (StringUtils.isNotBlank(requestDTO.getDatasetCode())) {
                conditions.add((builder.equal(root.get(RuleInstance_.datasetCode), requestDTO.getDatasetCode())));
            }

            if (Objects.nonNull(requestDTO.getCreateEndTime())) {
                conditions.add(builder.between(root.get(RuleInstance_.createTime), requestDTO.getCreateStartTime(), requestDTO.getCreateEndTime()));
            }

            if (Objects.nonNull(requestDTO.getUpdateStartTime()) && Objects.nonNull(requestDTO.getUpdateEndTime())) {
                conditions.add(builder.between(root.get(RuleInstance_.updateTime), requestDTO.getUpdateStartTime(), requestDTO.getUpdateEndTime()));
            }

            Join<RuleInstance, Metrics> metricsJoin = root.join(RuleInstance_.metrics, JoinType.INNER);
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
    public RuleInstanceResponseDTO createOrUpdate(RuleInstanceSingleCreateOrUpdateRequestDTO requestDTO) {
        RuleInstance convert = conversionService.convert(requestDTO, RuleInstance.class);
        RuleInstance save = ruleInstanceRepository.save(convert);
        return conversionService.convert(save, RuleInstanceResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        ruleInstanceRepository.deleteById(id);
    }

    @Override
    public void checkExistRule(RuleExistConditionDTO ruleExistConditionDTO) {
        Specification specification = (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            Join<RuleInstance, Metrics> metricsJoin = root.join(RuleInstance_.metrics, JoinType.INNER);
            conditions.add(builder.equal(metricsJoin.get(Metrics_.code), ruleExistConditionDTO.getMetricsCode()));
            conditions.add(root.get(RuleInstance_.subjectCategory).as(SubjectCategoryEnum.class).in(ruleExistConditionDTO.getSubjectCategory()));
            conditions.add(root.get(RuleInstance_.subjectCode).as(String.class).in(ruleExistConditionDTO.getSubjectCodes()));
            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };

        List<RuleInstanceResponseDTO> convert = (List<RuleInstanceResponseDTO>) conversionService.convert(ruleInstanceRepository.findAll(specification),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleInstance.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleInstanceResponseDTO.class)));
        List<String> ruleExists = convert.stream().map(i -> i.getSubjectCode()).collect(Collectors.toList());
        Assert.empty(convert, RULE_INSTANCE_EXIST, ruleExists);
    }

    @Override
    public long count(RuleInstanceConditionRequestDTO requestDTO) {
        return ruleInstanceRepository.count(countConditions(requestDTO));
    }

    private Specification<RuleInstance> countConditions(RuleInstanceConditionRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            if (StringUtils.isNotBlank(requestDTO.getMetricsCode())) {
                conditions.add(builder.equal(root.get(RuleInstance_.metrics).get(Metrics_.code), requestDTO.getMetricsCode()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }
}
