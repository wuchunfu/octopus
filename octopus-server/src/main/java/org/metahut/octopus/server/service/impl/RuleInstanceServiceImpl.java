package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.entity.MetricsConfig;
import org.metahut.octopus.dao.entity.Metrics_;
import org.metahut.octopus.dao.entity.RuleInstance;
import org.metahut.octopus.dao.entity.RuleInstance_;
import org.metahut.octopus.dao.repository.RuleInstanceRepository;
import org.metahut.octopus.server.service.MetricsConfigService;
import org.metahut.octopus.server.service.MetricsService;
import org.metahut.octopus.server.service.RuleInstanceService;

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
public class RuleInstanceServiceImpl implements RuleInstanceService {

    private final RuleInstanceRepository ruleInstanceRepository;
    private final ConversionService conversionService;
    private final MetricsService metricsService;
    private final MetricsConfigService metricsConfigService;

    public RuleInstanceServiceImpl(RuleInstanceRepository ruleInstanceRepository,
                                   ConversionService conversionService,
                                   MetricsService metricsService,
                                   MetricsConfigService metricsConfigService) {
        this.ruleInstanceRepository = ruleInstanceRepository;
        this.conversionService = conversionService;
        this.metricsService = metricsService;
        this.metricsConfigService = metricsConfigService;
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
    public RuleInstanceResponseDTO createOrUpdate(RuleInstanceCreateOrUpdateRequestDTO requestDTO) {
        RuleInstance convert = conversionService.convert(requestDTO, RuleInstance.class);
        if (Objects.nonNull(requestDTO.getMetricsConfigCode())) {
            MetricsConfig metricsConfig = metricsConfigService.findOneByCode(requestDTO.getMetricsConfigCode());
            convert.setMetricsConfig(metricsConfig);
            convert.setMetrics(metricsConfig.getMetrics());
        } else {
            Metrics metrics = metricsService.findOneByCode(requestDTO.getMetricsCode());
            convert.setMetrics(metrics);
        }

        // When the sampling request data changes, the sampling instance table data also changes.
        // TODO need to test
        if (Objects.nonNull(requestDTO.getSampleInstance())) {
            // TODO
        }

        RuleInstance save = ruleInstanceRepository.save(convert);
        return conversionService.convert(save, RuleInstanceResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        ruleInstanceRepository.deleteById(id);
    }

}
