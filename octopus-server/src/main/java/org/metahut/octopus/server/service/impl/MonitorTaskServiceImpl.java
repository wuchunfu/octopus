package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.FlowDefinitionCreateRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;
import org.metahut.octopus.dao.repository.FlowDefinitionRepository;
import org.metahut.octopus.server.service.MonitorTaskService;
import org.metahut.octopus.server.utils.Assert;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.metahut.octopus.common.enums.StatusEnum.FLOW_DEFINITION_NOT_EXIST;

@Service
public class MonitorTaskServiceImpl implements MonitorTaskService {

    private final FlowDefinitionRepository flowDefinitionRepository;

    private final ConversionService conversionService;

    public MonitorTaskServiceImpl(FlowDefinitionRepository flowDefinitionRepository, ConversionService conversionService) {
        this.flowDefinitionRepository = flowDefinitionRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PageResponseDTO<MonitorTaskResponseDTO> queryListPage(MonitorTaskConditionsRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize());

        //TODO invoking dataSource interface

        Specification<FlowDefinition> specification = (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };

        Page<FlowDefinition> page = flowDefinitionRepository.findAll(specification, pageable);

        Map<String, FlowDefinition> schedulerMap = page.get().collect(Collectors.toMap(FlowDefinition::getSchedulerCode, Function.identity()));
        Set<String> schedulerCodes = schedulerMap.keySet();
        //TODO invoking scheduler interface add data to response

        List<MonitorTaskResponseDTO> responseList = (List<MonitorTaskResponseDTO>) conversionService.convert(page.getContent(),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FlowDefinition.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MonitorTaskResponseDTO.class))
        );

        return PageResponseDTO.of(requestDTO.getPageNo(), requestDTO.getPageSize(), page.getTotalElements(), responseList);
    }

    @Override
    public MonitorTaskResponseDTO queryById(Integer id) {
        Optional<FlowDefinition> optional = flowDefinitionRepository.findById(id);
        Assert.notPresent(optional, FLOW_DEFINITION_NOT_EXIST, new Integer[] {id});
        //TODO invoking dataSource interface
        //TODO invoking scheduler interface add data to response
        MonitorTaskResponseDTO response = conversionService.convert(optional.get(), MonitorTaskResponseDTO.class);
        return response;
    }

    @Override
    public MonitorTaskResponseDTO create(FlowDefinitionCreateRequestDTO createRequest) {
        FlowDefinition convert = conversionService.convert(createRequest, FlowDefinition.class);
        return conversionService.convert(flowDefinitionRepository.save(convert), MonitorTaskResponseDTO.class);
    }
}
