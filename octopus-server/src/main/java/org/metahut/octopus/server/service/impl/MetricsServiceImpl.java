package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.entity.Metrics_;
import org.metahut.octopus.dao.repository.MetricsRepository;
import org.metahut.octopus.server.service.MetricsService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetricsServiceImpl implements MetricsService {

    private final MetricsRepository metricsRepository;
    private final ConversionService conversionService;

    public MetricsServiceImpl(MetricsRepository metricsRepository, ConversionService conversionService) {
        this.metricsRepository = metricsRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<MetricsResponseDTO> findList(MetricsConditionsRequestDTO requestDTO) {
        return conversionService.convert(metricsRepository.findAll(withConditions(requestDTO)), List.class);
    }

    @Override
    public PageResponseDTO<MetricsResponseDTO> queryListPage(MetricsConditionsRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize());
        Page<Metrics> metricsPage = metricsRepository.findAll(withConditions(requestDTO), pageable);
        List convert = conversionService.convert(metricsPage.getContent(), List.class);
        return PageResponseDTO.of(requestDTO.getPageNo(), requestDTO.getPageSize(), metricsPage.getTotalPages(), convert);
    }

    private Specification<Metrics> withConditions(MetricsConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(Metrics_.name), "%" + requestDTO.getName() + "%"));
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
