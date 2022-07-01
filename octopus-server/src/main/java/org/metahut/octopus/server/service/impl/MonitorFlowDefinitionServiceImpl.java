package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MonitorFlowDefinitionConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;
import org.metahut.octopus.dao.entity.FlowDefinition;
import org.metahut.octopus.dao.entity.FlowDefinition_;
import org.metahut.octopus.dao.repository.FlowDefinitionRepository;
import org.metahut.octopus.server.service.MonitorFlowDefinitionService;
import org.metahut.octopus.server.service.SchedulerService;
import org.metahut.octopus.server.utils.Assert;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.metahut.octopus.common.enums.StatusEnum.FLOW_DEFINITION_CODE_NOT_EXIST;

@Service
public class MonitorFlowDefinitionServiceImpl implements MonitorFlowDefinitionService {

    private final FlowDefinitionRepository flowDefinitionRepository;
    private final ConversionService conversionService;
    private final SchedulerService schedulerService;

    public MonitorFlowDefinitionServiceImpl(FlowDefinitionRepository flowDefinitionRepository, ConversionService conversionService, SchedulerService schedulerService) {
        this.flowDefinitionRepository = flowDefinitionRepository;
        this.conversionService = conversionService;
        this.schedulerService = schedulerService;
    }

    @Override
    public PageResponseDTO<MonitorFlowDefinitionResponseDTO> queryListPage(MonitorFlowDefinitionConditionsRequestDTO requestDTO) {
        Sort.TypedSort<FlowDefinition> typedSort = Sort.sort(FlowDefinition.class);
        Sort sort = typedSort.by(FlowDefinition::getUpdateTime).descending();
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize(), sort);
        Page<FlowDefinition> flowDefinitionPage = flowDefinitionRepository.findAll(withConditions(requestDTO), pageable);
        List<MonitorFlowDefinitionResponseDTO> convert = (List<MonitorFlowDefinitionResponseDTO>) conversionService.convert(flowDefinitionPage.getContent(),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FlowDefinition.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MonitorFlowDefinitionResponseDTO.class)));
        return PageResponseDTO.of(requestDTO.getPageNo(), flowDefinitionPage.getSize(), flowDefinitionPage.getTotalElements(), convert);
    }

    private Specification<FlowDefinition> withConditions(MonitorFlowDefinitionConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            if (StringUtils.isNotBlank(requestDTO.getDatasourceCode())) {
                conditions.add(builder.equal(root.get(FlowDefinition_.datasourceCode), requestDTO.getDatasourceCode()));
            }

            if (StringUtils.isNotBlank(requestDTO.getDatasetCode())) {
                conditions.add(builder.equal(root.get(FlowDefinition_.datasetCode), requestDTO.getDatasetCode()));
            }

            if (StringUtils.isNotBlank(requestDTO.getDatabaseCode())) {
                conditions.add(builder.equal(root.get(FlowDefinition_.databaseCode), requestDTO.getDatabaseCode()));
            }

            if (Objects.nonNull(requestDTO.getCreateStartTime()) && Objects.nonNull(requestDTO.getCreateEndTime())) {
                conditions.add(builder.between(root.get(FlowDefinition_.createTime), requestDTO.getCreateStartTime(), requestDTO.getCreateEndTime()));
            }

            if (Objects.nonNull(requestDTO.getUpdateStartTime()) && Objects.nonNull(requestDTO.getUpdateEndTime())) {
                conditions.add(builder.between(root.get(FlowDefinition_.updateTime), requestDTO.getUpdateStartTime(), requestDTO.getUpdateEndTime()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    @Transactional
    public MonitorFlowDefinitionResponseDTO createOrUpdate(MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO) {
        FlowDefinition convert = conversionService.convert(requestDTO, FlowDefinition.class);
        if (Objects.nonNull(requestDTO.getId())) {
            FlowDefinition flowDefinition = new FlowDefinition();
            flowDefinition.setCode(requestDTO.getCode());
            Optional<FlowDefinition> optional = flowDefinitionRepository.findById(requestDTO.getId());
            optional.get().getRuleInstances().addAll(convert.getRuleInstances());
            BeanUtils.copyProperties(convert.getSampleInstance(), optional.get().getSampleInstance());
            Map<Integer, AlerterInstance> targetAlert = optional.get().getAlerterInstances().stream().collect(Collectors.toMap(AlerterInstance::getId, user -> user, (v1, v2) -> v2));
            Set<Integer> targetIds = targetAlert.keySet();
            Map<Integer, AlerterInstance> sourceAlert = convert.getAlerterInstances().stream().collect(Collectors.toMap(AlerterInstance::getId, user -> user, (v1, v2) -> v2));
            Set<Integer> sourceIds = sourceAlert.keySet();
            sourceAlert.forEach((k, v) -> {
                if (targetIds.contains(k)) {
                    BeanUtils.copyProperties(v, targetAlert.get(k));
                    targetAlert.get(k).setDatasetCode(convert.getDatasetCode());
                } else {
                    optional.get().getAlerterInstances().add(v);
                }
            });

            targetAlert.forEach((k, v) -> {
                if (!sourceIds.contains(k)) {
                    optional.get().getAlerterInstances().remove(targetAlert.get(k));
                }
            });

            return conversionService.convert(flowDefinitionRepository.findById(requestDTO.getId()).get(), MonitorFlowDefinitionResponseDTO.class);
        } else {
            FlowDefinition save = flowDefinitionRepository.save(convert);
            return conversionService.convert(convert, MonitorFlowDefinitionResponseDTO.class);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Optional<FlowDefinition> optional = flowDefinitionRepository.findById(id);
        Assert.isPresent(optional, FLOW_DEFINITION_CODE_NOT_EXIST, id);
        flowDefinitionRepository.deleteById(id);
        schedulerService.deleteFlowByCode(optional.get().getSchedulerCode());
    }

    @Override
    public Collection<String> queryRegisteredDatasetCodes() {
        return flowDefinitionRepository.findAll().stream().map(FlowDefinition::getDatasetCode).collect(Collectors.toSet());
    }

    @Override
    public FlowDefinition findOneByCode(Long code) {
        Optional<FlowDefinition> optional = flowDefinitionRepository.findOne((root, query, builder) -> builder.equal(root.get(FlowDefinition_.code), code));
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public MonitorFlowDefinitionResponseDTO queryByCode(Long code) {
        return conversionService.convert(findOneByCode(code), MonitorFlowDefinitionResponseDTO.class);
    }
}
