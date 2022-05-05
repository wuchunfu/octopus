package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceCreateRequestDTO;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;
import org.metahut.octopus.dao.entity.AlerterInstance_;
import org.metahut.octopus.dao.repository.AlerterInstanceRepositoty;
import org.metahut.octopus.server.alerter.AlerterPluginHelper;
import org.metahut.octopus.server.service.AlerterInstanceService;

import org.apache.commons.lang3.StringUtils;
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

    private AlerterInstanceRepositoty alerterInstanceRepositoty;
    private AlerterPluginHelper alerterPluginHelper;

    public AlerterInstanceServiceImpl(AlerterInstanceRepositoty alerterInstanceRepositoty, AlerterPluginHelper alerterPluginHelper) {
        this.alerterInstanceRepositoty = alerterInstanceRepositoty;
        this.alerterPluginHelper = alerterPluginHelper;
    }

    @Override
    public Collection<String> queryAllTypes() {
        return alerterPluginHelper.queryAllTypes();
    }

    @Override
    public Page<AlerterInstance> queryListPage(PageRequestDTO<AlerterInstanceConditionsRequestDTO> pageRequestDTO) {
        Pageable pageable = PageRequest.of(pageRequestDTO.getPageNo(), pageRequestDTO.getPageSize());
        Specification<AlerterInstance> specification = (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(pageRequestDTO.getParams().getName())) {
                conditions.add(builder.like(root.get(AlerterInstance_.name), "%" + pageRequestDTO.getParams().getName() + "%"));
            }

            if (StringUtils.isNotBlank(pageRequestDTO.getParams().getType())) {
                conditions.add(builder.equal(root.get(AlerterInstance_.alertType), pageRequestDTO.getParams().getType()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };

        return alerterInstanceRepositoty.findAll(specification, pageable);
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

        return alerterInstanceRepositoty.findAll(specification);
    }

    public AlerterInstance create(AlerterInstanceCreateRequestDTO alerterInstanceCreateRequestDTO) {

        // check alerter plugin instance parameter
        alerterPluginHelper.getParameter(alerterInstanceCreateRequestDTO.getType(), alerterInstanceCreateRequestDTO.getParams());

        AlerterInstance instance = new AlerterInstance();
        instance.setAlertType(alerterInstanceCreateRequestDTO.getType());
        instance.setAlertParams(alerterInstanceCreateRequestDTO.getType());
        instance.setName(alerterInstanceCreateRequestDTO.getName());
        return alerterInstanceRepositoty.save(instance);
    }

    public void update() {

    }

    public void deleteById(Integer id) {
        alerterInstanceRepositoty.deleteById(id);
    }
}
