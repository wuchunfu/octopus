package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.entity.Metrics_;
import org.metahut.octopus.dao.repository.MetricsRepository;
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

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.metahut.octopus.common.enums.StatusEnum.METRICS_NOT_EXIST;

@Service
public class MetricsServiceImpl implements MetricsService {

    private final MetricsRepository metricsRepository;
    private final ConversionService conversionService;

    public MetricsServiceImpl(MetricsRepository metricsRepository, ConversionService conversionService) {
        this.metricsRepository = metricsRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Metrics findOneByCode(String metricsCode) {
        Metrics metrics = new Metrics();
        metrics.setCode(metricsCode);
        Optional<Metrics> optional = metricsRepository.findOne(Example.of(metrics));
        Assert.notPresent(optional, METRICS_NOT_EXIST, new String[] {metricsCode});
        return optional.get();
    }

    @Override
    public MetricsResponseDTO findByCode(String metricsCode) {
        return conversionService.convert(findOneByCode(metricsCode), MetricsResponseDTO.class);
    }

    @Override
    public List<MetricsResponseDTO> findList(MetricsConditionsRequestDTO requestDTO) {
        return (List<MetricsResponseDTO>) conversionService.convert(metricsRepository.findAll(withConditions(requestDTO)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Metrics.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsResponseDTO.class)));
    }

    @Override
    public PageResponseDTO<MetricsResponseDTO> queryListPage(MetricsConditionsRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize());
        Page<Metrics> metricsPage = metricsRepository.findAll(withConditions(requestDTO), pageable);
        List<MetricsResponseDTO> convert = (List<MetricsResponseDTO>) conversionService.convert(metricsPage.getContent(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Metrics.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsResponseDTO.class)));
        return PageResponseDTO.of(requestDTO.getPageNo(), requestDTO.getPageSize(), metricsPage.getTotalElements(), convert);
    }

    private Specification<Metrics> withConditions(MetricsConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(Metrics_.name), "%" + requestDTO.getName() + "%"));
            }

            if (StringUtils.isNotBlank(requestDTO.getCode())) {
                conditions.add(builder.like(root.get(Metrics_.code), "%" + requestDTO.getCode() + "%"));
            }

            if (StringUtils.isNotBlank(requestDTO.getDescription())) {
                conditions.add(builder.like(root.get(Metrics_.description), "%" + requestDTO.getDescription() + "%"));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getMetricsDimensions())) {
                conditions.add(builder.in(root.get(Metrics_.metricsDimension).as(MetricsDimensionEnum.class).in(requestDTO.getMetricsDimensions())));
            }

            if (Objects.nonNull(requestDTO.getCreateStartTime()) && Objects.nonNull(requestDTO.getCreateEndTime())) {
                conditions.add(builder.between(root.get(Metrics_.createTime), requestDTO.getCreateStartTime(), requestDTO.getCreateEndTime()));
            }

            if (Objects.nonNull(requestDTO.getUpdateStartTime()) && Objects.nonNull(requestDTO.getUpdateEndTime())) {
                conditions.add(builder.between(root.get(Metrics_.updateTime), requestDTO.getUpdateStartTime(), requestDTO.getUpdateEndTime()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    public MetricsResponseDTO createOrUpdate(MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO) {
        Metrics convert = conversionService.convert(metricsCreateOrUpdateRequestDTO, Metrics.class);
        Metrics save = metricsRepository.save(convert);
        return conversionService.convert(save, MetricsResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        metricsRepository.deleteById(id);
    }
}
