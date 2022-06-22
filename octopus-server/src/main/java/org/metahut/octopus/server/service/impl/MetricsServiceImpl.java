package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MetricsConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsConfigConditionsRequestDTO;
import org.metahut.octopus.api.dto.MetricsCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.MetricsResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.api.dto.RuleInstanceConditionRequestDTO;
import org.metahut.octopus.api.dto.RuleTemplateConditionRequestDTO;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.dao.entity.Metrics;
import org.metahut.octopus.dao.entity.Metrics_;
import org.metahut.octopus.dao.repository.MetricsRepository;
import org.metahut.octopus.server.service.MetricsConfigService;
import org.metahut.octopus.server.service.MetricsService;
import org.metahut.octopus.server.service.RuleInstanceService;
import org.metahut.octopus.server.service.RuleTemplateService;
import org.metahut.octopus.server.utils.Assert;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.metahut.octopus.common.enums.StatusEnum.METRICS_CODE_UPDATE_ERROR;
import static org.metahut.octopus.common.enums.StatusEnum.METRICS_DELETE_ERROR;
import static org.metahut.octopus.common.enums.StatusEnum.METRICS_NAME_OR_CODE_EXIST;
import static org.metahut.octopus.common.enums.StatusEnum.METRICS_NOT_EXIST;

@Service
public class MetricsServiceImpl implements MetricsService {

    private final MetricsRepository metricsRepository;
    private final ConversionService conversionService;
    private final MetricsConfigService metricsConfigService;
    private final RuleInstanceService ruleInstanceService;
    private final RuleTemplateService ruleTemplateService;

    public MetricsServiceImpl(MetricsRepository metricsRepository, ConversionService conversionService, MetricsConfigService metricsConfigService,
                              RuleInstanceService ruleInstanceService, RuleTemplateService ruleTemplateService) {
        this.metricsRepository = metricsRepository;
        this.conversionService = conversionService;
        this.metricsConfigService = metricsConfigService;
        this.ruleInstanceService = ruleInstanceService;
        this.ruleTemplateService = ruleTemplateService;
    }

    @Override
    public Metrics findOneByCode(String metricsCode) {
        Metrics metrics = new Metrics();
        metrics.setCode(metricsCode);
        Optional<Metrics> optional = metricsRepository.findOne(Example.of(metrics));
        Assert.isPresent(optional, METRICS_NOT_EXIST, metricsCode);
        return optional.get();
    }

    @Override
    public MetricsResponseDTO findByCode(String metricsCode) {
        return conversionService.convert(findOneByCode(metricsCode), MetricsResponseDTO.class);
    }

    @Override
    public List<MetricsResponseDTO> findList(MetricsConditionsRequestDTO requestDTO) {
        return (List<MetricsResponseDTO>) conversionService.convert(metricsRepository.findAll(withConditions(requestDTO)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Metrics.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsResponseDTO.class)));
    }

    @Override
    public PageResponseDTO<MetricsResponseDTO> queryListPage(MetricsConditionsRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(requestDTO.getPageNo() - 1, requestDTO.getPageSize());
        Page<Metrics> metricsPage = metricsRepository.findAll(withConditions(requestDTO), pageable);
        List<MetricsResponseDTO> convert = (List<MetricsResponseDTO>) conversionService.convert(metricsPage.getContent(),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Metrics.class)),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MetricsResponseDTO.class)));
        return PageResponseDTO.of(requestDTO.getPageNo(), metricsPage.getSize(), metricsPage.getTotalElements(), convert);
    }

    private Specification<Metrics> withConditions(MetricsConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(requestDTO.getName())) {
                conditions.add(builder.like(root.get(Metrics_.name), "%" + requestDTO.getName() + "%"));
            }

            if (StringUtils.isNotBlank(requestDTO.getCode())) {
                conditions.add(builder.like(root.get(Metrics_.code), "%" + requestDTO.getCode() + "%"));
            }

            if (StringUtils.isNotBlank(requestDTO.getDescription())) {
                conditions.add(builder.like(root.get(Metrics_.description), "%" + requestDTO.getDescription() + "%"));
            }

            if (CollectionUtils.isNotEmpty(requestDTO.getMetricsDimensions())) {
                conditions.add(root.get(Metrics_.metricsDimension).as(MetricsDimensionEnum.class).in(requestDTO.getMetricsDimensions()));
            }

            if (Objects.nonNull(requestDTO.getCreateStartTime()) && Objects.nonNull(requestDTO.getCreateEndTime())) {
                conditions.add(builder.between(root.get(Metrics_.createTime), requestDTO.getCreateStartTime(), requestDTO.getCreateEndTime()));
            }

            if (Objects.nonNull(requestDTO.getUpdateStartTime()) && Objects.nonNull(requestDTO.getUpdateEndTime())) {
                conditions.add(builder.between(root.get(Metrics_.updateTime), requestDTO.getUpdateStartTime(), requestDTO.getUpdateEndTime()));
            }
            query.orderBy(builder.desc(root.get(Metrics_.updateTime)));
            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }

    @Override
    public MetricsResponseDTO create(MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO) {
        List<Metrics> list = metricsRepository.findAll((root, query, builder) ->
            builder.or(builder.equal(root.get(Metrics_.name), metricsCreateOrUpdateRequestDTO.getName()),
                builder.equal(root.get(Metrics_.code), metricsCreateOrUpdateRequestDTO.getCode()))
        );
        Assert.isEmpty(list, METRICS_NAME_OR_CODE_EXIST);
        Metrics convert = conversionService.convert(metricsCreateOrUpdateRequestDTO, Metrics.class);
        Metrics save = metricsRepository.save(convert);
        return conversionService.convert(save, MetricsResponseDTO.class);
    }

    @Override
    public MetricsResponseDTO update(MetricsCreateOrUpdateRequestDTO metricsCreateOrUpdateRequestDTO) {

        // 1.Check if name already exists
        Metrics query = new Metrics();
        query.setName(metricsCreateOrUpdateRequestDTO.getName());
        Optional<Metrics> optional = metricsRepository.findOne(Example.of(query));
        Assert.isTrue(!optional.isPresent() || optional.get().getId().equals(metricsCreateOrUpdateRequestDTO.getId()), METRICS_NAME_OR_CODE_EXIST);

        // When the query exists, it can only be the current record
        optional = optional.isPresent() ? optional : metricsRepository.findById(metricsCreateOrUpdateRequestDTO.getId());
        Assert.isPresent(optional, METRICS_NOT_EXIST, metricsCreateOrUpdateRequestDTO.getId());
        Assert.isTrue(optional.get().getCode().equals(metricsCreateOrUpdateRequestDTO.getCode()), METRICS_CODE_UPDATE_ERROR);

        Metrics convert = conversionService.convert(metricsCreateOrUpdateRequestDTO, Metrics.class);
        Metrics save = metricsRepository.save(convert);
        return conversionService.convert(save, MetricsResponseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Metrics> optional = metricsRepository.findById(id);
        Assert.isPresent(optional, METRICS_NOT_EXIST, id);

        String metricsCode = optional.get().getCode();

        MetricsConfigConditionsRequestDTO metricsConfigConditionsRequestDTO = new MetricsConfigConditionsRequestDTO();
        metricsConfigConditionsRequestDTO.setMetricsCode(metricsCode);
        Assert.isTrue(metricsConfigService.count(metricsConfigConditionsRequestDTO) == 0, METRICS_DELETE_ERROR, metricsCode, "metricsConfig");

        RuleTemplateConditionRequestDTO ruleTemplateConditionRequestDTO = new RuleTemplateConditionRequestDTO();
        ruleTemplateConditionRequestDTO.setMetricsCode(metricsCode);
        Assert.isTrue(ruleTemplateService.count(ruleTemplateConditionRequestDTO) == 0, METRICS_DELETE_ERROR, metricsCode, "ruleTemplate");

        RuleInstanceConditionRequestDTO ruleInstanceConditionRequestDTO = new RuleInstanceConditionRequestDTO();
        ruleInstanceConditionRequestDTO.setMetricsCode(metricsCode);
        Assert.isTrue(ruleInstanceService.count(ruleInstanceConditionRequestDTO) == 0, METRICS_DELETE_ERROR, metricsCode, "ruleInstance");

        metricsRepository.deleteById(id);
    }
}
