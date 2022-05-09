package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceCreateRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;
import org.metahut.octopus.dao.entity.AlerterInstance_;
import org.metahut.octopus.dao.repository.AlerterInstanceRepository;
import org.metahut.octopus.server.alerter.AlerterPluginHelper;
import org.metahut.octopus.server.service.AlerterInstanceService;

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
public class AlerterInstanceServiceImpl implements AlerterInstanceService {

    private final AlerterInstanceRepository alerterInstanceRepository;
    private final AlerterPluginHelper alerterPluginHelper;
    private final ConversionService conversionService;

    public AlerterInstanceServiceImpl(AlerterInstanceRepository alerterInstanceRepository, AlerterPluginHelper alerterPluginHelper, ConversionService conversionService) {
        this.alerterInstanceRepository = alerterInstanceRepository;
        this.alerterPluginHelper = alerterPluginHelper;
        this.conversionService = conversionService;
    }

    @Override
    public Collection<String> queryAllPluginTypes() {
        return alerterPluginHelper.queryAllTypes();
    }

    @Override
    public Page<AlerterInstance> queryListPage(AlerterInstanceConditionsRequestDTO alerterInstanceConditionsRequestDTO) {
        Pageable pageable = PageRequest.of(alerterInstanceConditionsRequestDTO.getPageNo(), alerterInstanceConditionsRequestDTO.getPageSize());
        Specification<AlerterInstance> specification = (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(alerterInstanceConditionsRequestDTO.getName())) {
                conditions.add(builder.like(root.get(AlerterInstance_.name), "%" + alerterInstanceConditionsRequestDTO.getName() + "%"));
            }

            if (StringUtils.isNotBlank(alerterInstanceConditionsRequestDTO.getType())) {
                conditions.add(builder.equal(root.get(AlerterInstance_.alertType), alerterInstanceConditionsRequestDTO.getType()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };

        return alerterInstanceRepository.findAll(specification, pageable);
    }

    @Override
    public List<AlerterInstance> queryList(AlerterInstanceConditionsRequestDTO alerterInstanceConditionsRequestDTO) {

        Specification<AlerterInstance> specification = (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(alerterInstanceConditionsRequestDTO.getName())) {
                conditions.add(builder.like(root.get(AlerterInstance_.name), "%" + alerterInstanceConditionsRequestDTO.getName() + "%"));
            }

            if (StringUtils.isNotBlank(alerterInstanceConditionsRequestDTO.getType())) {
                conditions.add(builder.equal(root.get(AlerterInstance_.alertType), alerterInstanceConditionsRequestDTO.getType()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };

        return alerterInstanceRepository.findAll(specification);
    }

    @Override
    public AlerterInstanceResponseDTO create(AlerterInstanceCreateRequestDTO alerterInstanceCreateRequestDTO) {

        // check alerter plugin instance parameter
        alerterPluginHelper.getParameter(alerterInstanceCreateRequestDTO.getType(), alerterInstanceCreateRequestDTO.getParams());

        AlerterInstance instance = new AlerterInstance();
        instance.setAlertType(alerterInstanceCreateRequestDTO.getType());
        instance.setAlertParams(alerterInstanceCreateRequestDTO.getType());
        instance.setName(alerterInstanceCreateRequestDTO.getName());
        AlerterInstance save = alerterInstanceRepository.save(instance);
        return conversionService.convert(save, AlerterInstanceResponseDTO.class);
    }

    public void update() {

    }

    @Override
    public void deleteById(Integer id) {
        alerterInstanceRepository.deleteById(id);
    }
}
