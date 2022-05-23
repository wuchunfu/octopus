package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
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
    public Page<AlerterInstance> queryListPage(AlerterInstanceConditionsRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo(), requestDTO.getPageSize());
        return alerterInstanceRepository.findAll(withConditions(requestDTO), pageable);
    }

    @Override
    public List<AlerterInstance> queryList(AlerterInstanceConditionsRequestDTO requestDTO) {
        return alerterInstanceRepository.findAll(withConditions(requestDTO));
    }

    private Specification<AlerterInstance> withConditions(AlerterInstanceConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(AlerterInstance_.name), "%" + requestDTO.getName() + "%"));
            }

            if (StringUtils.isNotBlank(requestDTO.getAlertType())) {
                conditions.add(builder.equal(root.get(AlerterInstance_.alertType), requestDTO.getAlertType()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    public AlerterInstanceResponseDTO createOrUpdate(AlerterInstanceCreateOrUpdateRequestDTO requestDTO) {
        // check alerter plugin instance parameter
        alerterPluginHelper.deserializeParameter(requestDTO.getAlertType(), requestDTO.getParameter());
        AlerterInstance convert = conversionService.convert(requestDTO, AlerterInstance.class);
        AlerterInstance save = alerterInstanceRepository.save(convert);
        return conversionService.convert(save, AlerterInstanceResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        alerterInstanceRepository.deleteById(id);
    }
}
