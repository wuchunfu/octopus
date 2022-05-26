package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MonitorFlowDefinitionConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;
import org.metahut.octopus.dao.entity.FlowDefinition_;
import org.metahut.octopus.dao.repository.FlowDefinitionRepository;
import org.metahut.octopus.server.service.MonitorFlowDefinitionService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MonitorFlowDefinitionServiceImpl implements MonitorFlowDefinitionService {

    private final FlowDefinitionRepository flowDefinitionRepository;
    private final ConversionService conversionService;

    public MonitorFlowDefinitionServiceImpl(FlowDefinitionRepository flowDefinitionRepository, ConversionService conversionService) {
        this.flowDefinitionRepository = flowDefinitionRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PageResponseDTO<MonitorFlowDefinitionResponseDTO> queryListPage(MonitorFlowDefinitionConditionsRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize());
        Page<FlowDefinition> flowDefinitionPage = flowDefinitionRepository.findAll(withConditions(requestDTO), pageable);
        List<MonitorFlowDefinitionResponseDTO> convert = (List<MonitorFlowDefinitionResponseDTO>) conversionService.convert(flowDefinitionPage.getContent(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FlowDefinition.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MonitorFlowDefinitionResponseDTO.class)));
        return PageResponseDTO.of(requestDTO.getPageNo(), flowDefinitionPage.getSize(), flowDefinitionPage.getTotalElements(), convert);
    }

    private Specification<FlowDefinition> withConditions(MonitorFlowDefinitionConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            if(StringUtils.isNotBlank(requestDTO.getDatasetCode())) {
                conditions.add(builder.like(root.get(FlowDefinition_.datasetCode), requestDTO.getDatasetCode()));
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
    public MonitorFlowDefinitionResponseDTO createOrUpdate(MonitorFlowDefinitionCreateOrUpdateRequestDTO requestDTO) {
        FlowDefinition convert = conversionService.convert(requestDTO, FlowDefinition.class);
        FlowDefinition save = flowDefinitionRepository.save(convert);
        return conversionService.convert(save, MonitorFlowDefinitionResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        flowDefinitionRepository.deleteById(id);
    }

    @Override
    public Collection<String> queryRegisteredDatasetCodes() {
        return flowDefinitionRepository.findAll().stream().map(FlowDefinition::getDatasetCode).collect(Collectors.toSet());
    }
}
