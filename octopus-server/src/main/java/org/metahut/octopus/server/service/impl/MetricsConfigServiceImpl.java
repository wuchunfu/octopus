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

import static org.metahut.octopus.common.enums.StatusEnum.METRICS_CONFIG_CODE_UPDATE_ERROR;
import static org.metahut.octopus.common.enums.StatusEnum.METRICS_CONFIG_NOT_EXIST;
import static org.metahut.octopus.common.enums.StatusEnum.METRICS_CONFIG_UNIQUE_ERROR;

@Service
public class MetricsConfigServiceImpl implements MetricsConfigService {

    private final MetricsConfigRepository metricsConfigRepository;
    private final ConversionService conversionService;

    public MetricsConfigServiceImpl(MetricsConfigRepository metricsConfigRepository, ConversionService conversionService) {
        this.metricsConfigRepository = metricsConfigRepository;
        this.conversionService = conversionService;
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
    public MetricsConfigResponseDTO create(MetricsConfigCreateOrUpdateRequestDTO requestDTO) {
        MetricsConfig queryConditions = new MetricsConfig();
        Metrics metrics = new Metrics();
        metrics.setCode(requestDTO.getMetricsCode());

        queryConditions.setMetrics(metrics);
        queryConditions.setSubjectCategory(requestDTO.getSubjectCategory());
        queryConditions.setSourceCategory(requestDTO.getSourceCategory());
        Assert.isFalse(metricsConfigRepository.exists(Example.of(queryConditions)), METRICS_CONFIG_UNIQUE_ERROR);

        MetricsConfig convert = conversionService.convert(requestDTO, MetricsConfig.class);
        MetricsConfig save = metricsConfigRepository.save(convert);
        return conversionService.convert(save, MetricsConfigResponseDTO.class);
    }

    @Override
    public MetricsConfigResponseDTO update(MetricsConfigCreateOrUpdateRequestDTO requestDTO) {
        Optional<MetricsConfig> optional = metricsConfigRepository.findOne((root, query, builder) ->
            builder.and(builder.equal(root.get(MetricsConfig_.metrics).get(Metrics_.code), requestDTO.getMetricsCode()),
                builder.equal(root.get(MetricsConfig_.subjectCategory), requestDTO.getSubjectCategory()),
                builder.equal(root.get(MetricsConfig_.sourceCategory), requestDTO.getSourceCategory()),
                builder.notEqual(root.get(MetricsConfig_.id), requestDTO.getId()))
        );
        Assert.notPresent(optional, METRICS_CONFIG_UNIQUE_ERROR);

        Optional<MetricsConfig> metricsConfigOptional = metricsConfigRepository.findById(requestDTO.getId());
        Assert.isPresent(metricsConfigOptional, METRICS_CONFIG_NOT_EXIST, requestDTO.getId());
        Assert.isEquals(metricsConfigOptional.get().getCode(), requestDTO.getCode(), METRICS_CONFIG_CODE_UPDATE_ERROR);

        MetricsConfig convert = conversionService.convert(requestDTO, MetricsConfig.class);
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
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public long count(MetricsConfigConditionsRequestDTO requestDTO) {
        return metricsConfigRepository.count(countConditions(requestDTO));
    }

    private Specification<MetricsConfig> countConditions(MetricsConfigConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            if (StringUtils.isNotBlank(requestDTO.getMetricsCode())) {
                conditions.add(builder.equal(root.get(MetricsConfig_.metrics).get(Metrics_.code), requestDTO.getMetricsCode()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }
}
