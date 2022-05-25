package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.AlerterSourceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
import org.metahut.octopus.dao.entity.AlerterSource;
import org.metahut.octopus.dao.entity.AlerterSource_;
import org.metahut.octopus.dao.repository.AlerterSourceRepository;
import org.metahut.octopus.server.alerter.AlerterPluginHelper;
import org.metahut.octopus.server.service.AlerterSourceService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AlerterSourceServiceImpl implements AlerterSourceService {

    private final AlerterSourceRepository alerterSourceRepository;
    private final AlerterPluginHelper alerterPluginHelper;
    private final ConversionService conversionService;

    public AlerterSourceServiceImpl(AlerterSourceRepository alerterSourceRepository, AlerterPluginHelper alerterPluginHelper, ConversionService conversionService) {
        this.alerterSourceRepository = alerterSourceRepository;
        this.alerterPluginHelper = alerterPluginHelper;
        this.conversionService = conversionService;
    }

    @Override
    public Collection<String> queryAllPluginTypes() {
        return alerterPluginHelper.queryAllTypes();
    }

    @Override
    public Page<AlerterSource> queryListPage(AlerterSourceConditionsRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo(), requestDTO.getPageSize());
        return alerterSourceRepository.findAll(withConditions(requestDTO), pageable);
    }

    @Override
    public List<AlerterSource> queryList(AlerterSourceConditionsRequestDTO requestDTO) {
        return alerterSourceRepository.findAll(withConditions(requestDTO));
    }

    private Specification<AlerterSource> withConditions(AlerterSourceConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(AlerterSource_.name), "%" + requestDTO.getName() + "%"));
            }

            if (StringUtils.isNotBlank(requestDTO.getAlertType())) {
                conditions.add(builder.equal(root.get(AlerterSource_.alertType), requestDTO.getAlertType()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    public AlerterSourceResponseDTO createOrUpdate(AlerterSourceCreateOrUpdateRequestDTO requestDTO) {
        // check alerter plugin instance parameter
        alerterPluginHelper.deserializeSourceParameter(requestDTO.getAlertType(), requestDTO.getParameter());
        AlerterSource convert = conversionService.convert(requestDTO, AlerterSource.class);
        AlerterSource save = alerterSourceRepository.save(convert);
        return conversionService.convert(save, AlerterSourceResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        alerterSourceRepository.deleteById(id);
    }
}
