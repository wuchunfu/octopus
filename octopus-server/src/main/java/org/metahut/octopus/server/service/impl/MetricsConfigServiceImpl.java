package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetricsConfigConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.dao.entity.MetricsConfig;
import org.metahut.octopus.dao.entity.MetricsConfig_;
import org.metahut.octopus.dao.repository.MetricsConfigRepository;
import org.metahut.octopus.server.service.MetricsConfigService;

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
public class MetricsConfigServiceImpl implements MetricsConfigService {

    private final MetricsConfigRepository metricsConfigRepository;
    private final ConversionService conversionService;

    public MetricsConfigServiceImpl(MetricsConfigRepository metricsConfigRepository, ConversionService conversionService) {
        this.metricsConfigRepository = metricsConfigRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<MetricsConfigResponseDTO> findList(MetricsConfigConditionsRequestDTO requestDTO) {
        return conversionService.convert(metricsConfigRepository.findAll(withConditions(requestDTO)), List.class);
    }

    @Override
    public PageResponseDTO<MetricsConfigResponseDTO> queryListPage(MetricsConfigConditionsRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize());
        Page<MetricsConfig> metricsConfigPage = metricsConfigRepository.findAll(withConditions(requestDTO), pageable);
        List convert = conversionService.convert(metricsConfigPage.getContent(), List.class);
        return PageResponseDTO.of(requestDTO.getPageNo(), requestDTO.getPageSize(), metricsConfigPage.getTotalPages(), convert);
    }

    private Specification<MetricsConfig> withConditions(MetricsConfigConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(MetricsConfig_.name), "%" + requestDTO.getName() + "%"));
            }
            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    public MetricsConfigResponseDTO createOrUpdate(MetricsConfigCreateOrUpdateRequestDTO metricsConfigCreateOrUpdateRequestDTO) {
        MetricsConfig convert = conversionService.convert(metricsConfigCreateOrUpdateRequestDTO, MetricsConfig.class);
        MetricsConfig save = metricsConfigRepository.save(convert);
        return conversionService.convert(save, MetricsConfigResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        metricsConfigRepository.deleteById(id);
    }
}
