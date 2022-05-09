package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.entity.Metrics_;
import org.metahut.octopus.dao.repository.MetricsRepository;
import org.metahut.octopus.server.service.MetricsService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetricsServiceImpl implements MetricsService {

    private MetricsRepository metricsRepository;
    private ConversionService conversionService;

    public MetricsServiceImpl(MetricsRepository metricsRepository, ConversionService conversionService) {
        this.metricsRepository = metricsRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<MetricsResponseDTO> findAll(MetricsConditionsRequestDTO requestDTO) {
        return conversionService.convert(metricsRepository.findAll(convertRequest(requestDTO)), List.class);
    }

    private Specification<Metrics> convertRequest(MetricsConditionsRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(Metrics_.name), "%" + requestDTO.getName() + "%"));
            }
            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };

    }
}
