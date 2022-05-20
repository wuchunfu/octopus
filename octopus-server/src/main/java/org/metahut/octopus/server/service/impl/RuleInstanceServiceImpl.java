package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.RuleInstanceResponseDTO;
import org.metahut.octopus.api.dto.SourceAlertRelationResponseDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;
import org.metahut.octopus.dao.entity.FlowDefinition_;
import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.entity.MetricsConfig;
import org.metahut.octopus.dao.entity.RuleInstance;
import org.metahut.octopus.dao.entity.RuleInstance_;
import org.metahut.octopus.dao.entity.SampleInstance;
import org.metahut.octopus.dao.entity.SourceAlertRelation;
import org.metahut.octopus.dao.repository.FlowDefinitionRepository;
import org.metahut.octopus.dao.repository.RuleInstanceRepository;
import org.metahut.octopus.dao.repository.SampleInstanceRepository;
import org.metahut.octopus.dao.repository.SourceAlertRelationRepository;
import org.metahut.octopus.server.service.MetricsConfigService;
import org.metahut.octopus.server.service.MetricsService;
import org.metahut.octopus.server.service.RuleInstanceService;
import org.metahut.octopus.server.utils.Assert;
import org.metahut.octopus.server.utils.SnowflakeIdGenerator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.metahut.octopus.common.enums.StatusEnum.FLOW_DEFINITION_NOT_EXIST;
import static org.metahut.octopus.common.enums.StatusEnum.RULE_INSTANCE_NOT_EXIST;
import static org.metahut.octopus.common.enums.StatusEnum.SAMPLE_NOT_EXIST;

@Service
public class RuleInstanceServiceImpl implements RuleInstanceService {

    private final RuleInstanceRepository ruleInstanceRepository;
    private final ConversionService conversionService;
    private final FlowDefinitionRepository flowDefinitionRepository;
    private final SampleInstanceRepository sampleInstanceRepository;
    private final MetricsService metricsService;
    private final MetricsConfigService metricsConfigService;
    private final SourceAlertRelationRepository sourceAlertRelationRepository;

    public RuleInstanceServiceImpl(RuleInstanceRepository ruleInstanceRepository,
                                   ConversionService conversionService,
                                   FlowDefinitionRepository flowDefinitionRepository,
                                   SampleInstanceRepository sampleInstanceRepository,
                                   MetricsService metricsService,
                                   MetricsConfigService metricsConfigService,
                                   SourceAlertRelationRepository sourceAlertRelationRepository) {
        this.ruleInstanceRepository = ruleInstanceRepository;
        this.conversionService = conversionService;
        this.flowDefinitionRepository = flowDefinitionRepository;
        this.sampleInstanceRepository = sampleInstanceRepository;
        this.metricsService = metricsService;
        this.metricsConfigService = metricsConfigService;
        this.sourceAlertRelationRepository = sourceAlertRelationRepository;
    }

    @Override
    public PageResponseDTO<RuleInstanceResponseDTO> queryListPage(RuleInstanceConditionRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize());
        Page<RuleInstance> ruleInstancePage = ruleInstanceRepository.findAll(withConditions(requestDTO), pageable);
        List<RuleInstanceResponseDTO> convert = (List<RuleInstanceResponseDTO>) conversionService.convert(ruleInstanceRepository.findAll(withConditions(requestDTO)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleInstance.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RuleInstanceResponseDTO.class)));
        return PageResponseDTO.of(requestDTO.getPageNo(), requestDTO.getPageSize(), ruleInstancePage.getTotalElements(), convert);
    }

    private Specification<RuleInstance> withConditions(RuleInstanceConditionRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (Objects.nonNull(requestDTO.getSubjectCode())) {
                conditions.add(builder.in(root.get(RuleInstance_.subjectCode).as(String.class).in(requestDTO.getSubjectCode())));
            }

            Join<RuleInstance, FlowDefinition> flowJoin = root.join(RuleInstance_.flowDefinition, JoinType.INNER);
            if (StringUtils.isNotBlank(requestDTO.getSourceCode())) {
                conditions.add(builder.like(flowJoin.get(FlowDefinition_.sourceCode), "%" + requestDTO.getSourceCode() + "%"));
            }

            //todo sourceType

            if (Objects.nonNull(requestDTO.getCreateEndTime())) {
                conditions.add(builder.between(root.get(RuleInstance_.createTime), requestDTO.getCreateStartTime(), requestDTO.getCreateEndTime()));
            }

            if (Objects.nonNull(requestDTO.getUpdateStartTime()) && Objects.nonNull(requestDTO.getUpdateEndTime())) {
                conditions.add(builder.between(root.get(RuleInstance_.updateTime), requestDTO.getUpdateStartTime(), requestDTO.getUpdateEndTime()));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    public List<RuleInstanceResponseDTO> batchCreate(List<RuleInstanceCreateOrUpdateRequestDTO> requestDTOs) {
        List<RuleInstanceResponseDTO> list = requestDTOs.stream().map(item -> {
            SampleInstance sampleInstance = createSampleInstance(item.getSamplevlue(), item.getSourceCode());
            FlowDefinition flowDefinition = createFlowDefinition(item.getSourceCode(), item.getCrontab(), item.getAlertGroup());
            Metrics metrics = metricsService.findOneByCode(item.getMetricsCode());
            RuleInstance convert = conversionService.convert(item, RuleInstance.class);
            convert.setMetrics(metrics);
            if (Objects.nonNull(item.getMetricsConfigCode())) {
                MetricsConfig metricsConfig = metricsConfigService.findOneByCode(item.getMetricsConfigCode());
                convert.setMetricsConfig(metricsConfig);
            }
            convert.setSampleInstance(sampleInstance);
            convert.setFlowDefinition(flowDefinition);
            //todo uniquekey  sourceType
            //String metricsParams = "{\"type\":\"test\"}";
            //AbstractMetricsParameter abstractMetricsParameter = JSONUtils.parseObject(metricsParams, AbstractMetricsParameter.class);
            convert.setMetricsUniqueKey("test");
            RuleInstance save = ruleInstanceRepository.save(convert);
            return conversionService.convert(save, RuleInstanceResponseDTO.class);
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public RuleInstanceResponseDTO update(RuleInstanceCreateOrUpdateRequestDTO requestDTO) {
        RuleInstance instance = findByInstanceId(requestDTO.getId());
        SampleInstance sampleInstance = updateSampleInstance(instance.getSampleInstance().getCode(), requestDTO.getSamplevlue(), requestDTO.getSourceCode());
        FlowDefinition flowDefinition = updateFlowDefinition(requestDTO.getSourceCode(), requestDTO.getCrontab(), requestDTO.getAlertGroup());
        Metrics metrics = metricsService.findOneByCode(requestDTO.getMetricsCode());
        RuleInstance convert = conversionService.convert(requestDTO, RuleInstance.class);
        convert.setFlowDefinition(flowDefinition);
        convert.setMetrics(metrics);
        if (Objects.nonNull(requestDTO.getMetricsConfigCode())) {
            MetricsConfig metricsConfig = metricsConfigService.findOneByCode(requestDTO.getMetricsConfigCode());
            convert.setMetricsConfig(metricsConfig);
        }
        convert.setSampleInstance(sampleInstance);
        RuleInstance save = ruleInstanceRepository.save(convert);

        return conversionService.convert(save, RuleInstanceResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        ruleInstanceRepository.deleteById(id);
    }

    private RuleInstance findByInstanceId(Integer id) {
        RuleInstance ruleInstance = new RuleInstance();
        ruleInstance.setId(id);
        Optional<RuleInstance> instance = ruleInstanceRepository.findOne(Example.of(ruleInstance));
        Assert.notPresent(instance, RULE_INSTANCE_NOT_EXIST, new Integer[] {id});
        return instance.get();
    }

    private SampleInstance findBySampleCode(Long code) {
        SampleInstance sampleInstance = new SampleInstance();
        sampleInstance.setCode(code);
        Optional<SampleInstance> sample = sampleInstanceRepository.findOne(Example.of(sampleInstance));
        Assert.notPresent(sample, SAMPLE_NOT_EXIST, new Long[] {code});
        return sample.get();
    }

    private SampleInstance createSampleInstance(String sampleValue, String sourceCode) {
        SampleInstance sampleInstance = new SampleInstance();
        sampleInstance.setCode(SnowflakeIdGenerator.getInstance().nextId());
        sampleInstance.setSourceCode(sourceCode);
        sampleInstance.setParams(sampleValue);
        return sampleInstance;
    }

    private SampleInstance updateSampleInstance(Long sampleCode, String sampleValue, String sourceCode) {
        SampleInstance sampleInstance = findBySampleCode(sampleCode);
        sampleInstance.setParams(sampleValue);
        sampleInstance.setSourceCode(sourceCode);
        return sampleInstance;
    }

    private void deleteSampleInstance(Integer smapleId) {
        sampleInstanceRepository.deleteById(smapleId);
    }

    private FlowDefinition findBySourceCode(String sourceCode) {
        FlowDefinition flowDefinition = new FlowDefinition();
        flowDefinition.setSourceCode(sourceCode);
        Optional<FlowDefinition> flow = flowDefinitionRepository.findOne(Example.of(flowDefinition));
        Assert.notPresent(flow, FLOW_DEFINITION_NOT_EXIST, new String[] {sourceCode});
        return flow.get();
    }

    private FlowDefinition createFlowDefinition(String sourceCode, String crontab, Map<Long, String> map) {
        FlowDefinition flowDefinition = new FlowDefinition();
        flowDefinition.setSchedulerCode(String.valueOf(SnowflakeIdGenerator.getInstance().nextId()));
        flowDefinition.setSourceCode(sourceCode);
        flowDefinition.setCrontab(crontab);
        List<SourceAlertRelation> list = new ArrayList<>();
        map.forEach((k, v) -> {
            SourceAlertRelation sourceAlertRelation = new SourceAlertRelation();
            sourceAlertRelation.setAlertInstanceCode(k);
            sourceAlertRelation.setAlerter(v);
            list.add(sourceAlertRelation);
        });
        flowDefinition.setSourceAlertRelations(list);
        return flowDefinition;
    }

    private FlowDefinition updateFlowDefinition(String sourceCode, String crontab, Map<Long, String> map) {
        FlowDefinition flow = findBySourceCode(sourceCode);
        flow.setSourceCode(sourceCode);
        flow.setCrontab(crontab);
        flow.getSourceAlertRelations().forEach(i -> sourceAlertRelationRepository.deleteById(i.getId()));
        List<SourceAlertRelation> list = new ArrayList<>();
        map.forEach((k, v) -> {
            SourceAlertRelation sourceAlertRelation = new SourceAlertRelation();
            sourceAlertRelation.setAlertInstanceCode(k);
            sourceAlertRelation.setAlerter(v);
            list.add(sourceAlertRelation);
        });
        flow.setSourceAlertRelations(list);
        return flow;
    }

    private void deleteFlowDefinition(Integer id) {
        flowDefinitionRepository.deleteById(id);
    }
  
    private List<SourceAlertRelationResponseDTO> createSourceAlertRelations(List<Long> alertCodes, List<String> peoples, RuleInstance ruleInstance) {
        List<SourceAlertRelationResponseDTO> sourceAlertRelations = new ArrayList<>();
        SourceAlertRelation sourceAlertRelation = new SourceAlertRelation();
        alertCodes.forEach(instance -> {
            peoples.forEach(people -> {
                sourceAlertRelation.setAlertInstanceCode(instance);
                sourceAlertRelation.setAlerter(people);
                SourceAlertRelationResponseDTO sourceAlertRelationResponseDTO =
                    conversionService.convert(sourceAlertRelationRepository.save(sourceAlertRelation), SourceAlertRelationResponseDTO.class);
                sourceAlertRelations.add(sourceAlertRelationResponseDTO);
            });
        });
        return sourceAlertRelations;
    }

}
