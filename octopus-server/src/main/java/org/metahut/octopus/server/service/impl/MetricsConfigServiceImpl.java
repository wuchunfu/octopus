package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetricsConfigConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.entity.MetricsConfig;
import org.metahut.octopus.dao.entity.MetricsConfig_;
import org.metahut.octopus.dao.entity.Metrics_;
import org.metahut.octopus.dao.repository.MetricsConfigRepository;
import org.metahut.octopus.server.service.MetricsConfigService;
import org.metahut.octopus.server.service.MetricsService;
import org.metahut.octopus.server.utils.Assert;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Example;
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
import java.util.Optional;

import static org.metahut.octopus.common.enums.StatusEnum.METRICS_CONFIG_NOT_EXIST;

@Service
public class MetricsConfigServiceImpl implements MetricsConfigService {

    private final MetricsConfigRepository metricsConfigRepository;
    private final ConversionService conversionService;
    private final MetricsService metricsService;

    public MetricsConfigServiceImpl(MetricsConfigRepository metricsConfigRepository, ConversionService conversionService, MetricsService metricsService) {
        this.metricsConfigRepository = metricsConfigRepository;
        this.conversionService = conversionService;
        this.metricsService = metricsService;
    }

    @Override
    public List<MetricsConfigResponseDTO> findList(MetricsConfigConditionsRequestDTO requestDTO) {
        return (List<MetricsConfigResponseDTO>) conversionService.convert(metricsConfigRepository.findAll(withConditions(requestDTO)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsConfig.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsConfigResponseDTO.class)));
    }

    @Override
    public PageResponseDTO<MetricsConfigResponseDTO> queryListPage(MetricsConfigConditionsRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize());
        Page<MetricsConfig> metricsConfigPage = metricsConfigRepository.findAll(withConditions(requestDTO), pageable);
        List<MetricsConfigResponseDTO> convert = (List<MetricsConfigResponseDTO>) conversionService.convert(metricsConfigPage.getContent(),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsConfig.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsConfigResponseDTO.class)));
        return PageResponseDTO.of(requestDTO.getPageNo(), metricsConfigPage.getSize(), metricsConfigPage.getTotalElements(), convert);
    }

    private Specification<MetricsConfig> withConditions(MetricsConfigConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(MetricsConfig_.name), "%" + requestDTO.getName() + "%"));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getSourceCategories())) {
                conditions.add(root.get(MetricsConfig_.sourceCategory).as(String.class).in(requestDTO.getSourceCategories()));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getSubjectCategories())) {
                conditions.add(root.get(MetricsConfig_.subjectCategory).as(SubjectCategoryEnum.class).in(requestDTO.getSubjectCategories()));
            }

            if (Objects.nonNull(requestDTO.getCreateStartTime()) && Objects.nonNull(requestDTO.getCreateEndTime())) {
                conditions.add(builder.between(root.get(MetricsConfig_.createTime), requestDTO.getCreateStartTime(), requestDTO.getCreateEndTime()));
            }

            if (Objects.nonNull(requestDTO.getUpdateStartTime()) && Objects.nonNull(requestDTO.getUpdateEndTime())) {
                conditions.add(builder.between(root.get(MetricsConfig_.updateTime), requestDTO.getUpdateStartTime(), requestDTO.getUpdateEndTime()));
            }

            Join<MetricsConfig, Metrics> metricsJoin = root.join(MetricsConfig_.metrics, JoinType.INNER);
            if (StringUtils.isNotBlank(requestDTO.getMetricsCode())) {
                conditions.add(builder.like(metricsJoin.get(Metrics_.code), "%" + requestDTO.getMetricsCode() + "%"));
            }
            if (StringUtils.isNotBlank(requestDTO.getMetricsName())) {
                conditions.add(builder.like(metricsJoin.get(Metrics_.name), "%" + requestDTO.getMetricsName() + "%"));
            }

            if (StringUtils.isNotBlank(requestDTO.getMetricsDescription())) {
                conditions.add(builder.like(metricsJoin.get(Metrics_.description), "%" + requestDTO.getMetricsDescription() + "%"));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getMetricsDimensions())) {
                conditions.add(metricsJoin.get(Metrics_.metricsDimension).as(MetricsDimensionEnum.class).in(requestDTO.getMetricsDimensions()));
            }
            query.orderBy(builder.desc(root.get(MetricsConfig_.updateTime)));
            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    public MetricsConfigResponseDTO createOrUpdate(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO) {
        Metrics metrics = metricsService.findOneByCode(metricsConfigCreateOrUpdateRequestDTO.getMetricsCode());
        MetricsConfig convert = conversionService.convert(metricsConfigCreateOrUpdateRequestDTO, MetricsConfig.class);
        convert.setMetrics(metrics);
        String metricsConfigName = metricsConfigCreateOrUpdateRequestDTO.getSubjectCategory() + "_"
            + metrics.getCode() + "_"
            + metricsConfigCreateOrUpdateRequestDTO.getSourceCategory() + "_"
            + metricsConfigCreateOrUpdateRequestDTO.getExecutorType();
        convert.setName(metricsConfigName);
        MetricsConfig save = metricsConfigRepository.save(convert);
        return conversionService.convert(save, MetricsConfigResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        metricsConfigRepository.deleteById(id);
    }

    @Override
    public MetricsConfigResponseDTO findByCode(Long metricsConfigCode) {
        return conversionService.convert(findOneByCode(metricsConfigCode), MetricsConfigResponseDTO.class);
    }

    @Override
    public MetricsConfig findOneByCode(Long code) {
        MetricsConfig metricsConfig = new MetricsConfig();
        metricsConfig.setCode(code);
        Optional<MetricsConfig> optional = metricsConfigRepository.findOne(Example.of(metricsConfig));
        Assert.notPresent(optional, METRICS_CONFIG_NOT_EXIST, new Long[] {code});
        return optional.get();
    }
}
