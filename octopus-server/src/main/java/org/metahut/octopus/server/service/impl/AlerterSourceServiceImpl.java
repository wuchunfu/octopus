package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.AlerterSourceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
import org.metahut.octopus.dao.entity.AlerterSource;
import org.metahut.octopus.dao.entity.AlerterSource_;
import org.metahut.octopus.dao.repository.AlerterSourceRepository;
import org.metahut.octopus.server.alerter.AlerterPluginParameterHelper;
import org.metahut.octopus.server.service.AlerterSourceService;
import org.metahut.octopus.server.utils.Assert;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.metahut.octopus.common.enums.StatusEnum.ALERT_SOURCE_NOT_EXIST;

/**
 * <p>
 *     converter: {@link org.metahut.octopus.server.converter.AlerterSourceToDTOConverter}
 *                {@link org.metahut.octopus.server.converter.AlerterSourceFromDTOConverter}
 * </p>
 */
@Service
public class AlerterSourceServiceImpl implements AlerterSourceService {

    private final AlerterSourceRepository alerterSourceRepository;
    private final AlerterPluginParameterHelper alerterPluginParameterHelper;
    private final ConversionService conversionService;

    public AlerterSourceServiceImpl(AlerterSourceRepository alerterSourceRepository, AlerterPluginParameterHelper alerterPluginParameterHelper, ConversionService conversionService) {
        this.alerterSourceRepository = alerterSourceRepository;
        this.alerterPluginParameterHelper = alerterPluginParameterHelper;
        this.conversionService = conversionService;
    }

    @Override
    public Collection<String> queryAllPluginTypes() {
        return alerterPluginParameterHelper.queryAllTypes();
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
        alerterPluginParameterHelper.deserializeSourceParameter(requestDTO.getAlertType(), requestDTO.getParameter());
        AlerterSource convert = conversionService.convert(requestDTO, AlerterSource.class);
        AlerterSource save = alerterSourceRepository.save(convert);
        return conversionService.convert(save, AlerterSourceResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        alerterSourceRepository.deleteById(id);
    }

    @Override
    public AlerterSource findByCode(Long alertSourceCode) {
        AlerterSource alerterSource = new AlerterSource();
        alerterSource.setCode(alertSourceCode);
        Optional<AlerterSource> optional = alerterSourceRepository.findOne(Example.of(alerterSource));
        Assert.isPresent(optional, ALERT_SOURCE_NOT_EXIST, alertSourceCode);
        return optional.get();
    }
}
