package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.SelectItemRequestDTO;
import org.metahut.octopus.api.dto.SelectItemResponseDTO;
import org.metahut.octopus.common.enums.CheckMethodEnum;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.common.enums.SelectItemNameEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.rule.api.CheckTypeEnum;
import org.metahut.octopus.rule.api.ComparisonMethodEnum;
import org.metahut.octopus.rule.api.ComparisonUnitEnum;
import org.metahut.octopus.scheduler.api.ExecutionStatus;
import org.metahut.octopus.server.service.MetaService;
import org.metahut.octopus.server.service.SelectItemService;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SelectItemServiceImpl implements SelectItemService {

    private static final Logger logger = LoggerFactory.getLogger(SelectItemServiceImpl.class);

    private final MessageSource messageSource;
    private final MetaService metaService;

    public SelectItemServiceImpl(MessageSource messageSource, MetaService metaService) {
        this.messageSource = messageSource;
        this.metaService = metaService;
    }

    @Override
    public Map<String, List<SelectItemResponseDTO>> queryList(SelectItemRequestDTO selectItemRequestDTO) {
        Set<SelectItemNameEnum> componentNames = Objects.isNull(selectItemRequestDTO) || CollectionUtils.isEmpty(selectItemRequestDTO.getComponentNames())
            ? Arrays.stream(SelectItemNameEnum.values()).collect(Collectors.toSet())
            : selectItemRequestDTO.getComponentNames();
        return componentNames
            .stream()
            .collect(Collectors.toMap(SelectItemNameEnum::name, nameEnum -> generateSelectItem(nameEnum)));
    }

    private List<SelectItemResponseDTO> generateSelectItem(SelectItemNameEnum nameEnum) {
        switch (nameEnum) {
            case DATASOURCE_TYPE:
                return queryDatasourceTypeItem();
            case METRICS_DIMENSION:
                return queryMetricsDimensionItem();
            case SUBJECT_CATEGORY:
                return querySubjectCategoryItem();
            case EXECUTOR_TYPE:
                return queryExecutorTypeItem();
            case CHECK_TYPE:
                return queryCheckTypeItem();
            case CHECK_METHOD:
                return queryCheckMethodItem();
            case COMPARISON_METHOD:
                return queryComparisonMethodItem();
            case COMPARISON_UNIT:
                return queryComparisonUnitItem();
            case TASK_STATUS:
                return queryTaskStatusItem();
            default:
                return Collections.EMPTY_LIST;
        }
    }

    private List<SelectItemResponseDTO> queryDatasourceTypeItem() {
        // TODO query metadata interface

        List<SelectItemResponseDTO> list = new ArrayList<>();
        list.add(SelectItemResponseDTO.of("Hive", "Hive"));
        list.add(SelectItemResponseDTO.of("Pulsar", "Pulsar"));
        return list;
    }

    private List<SelectItemResponseDTO> queryExecutorTypeItem() {
        // TODO query metadata interface

        List<SelectItemResponseDTO> list = new ArrayList<>();
        list.add(SelectItemResponseDTO.of("Flink", "Flink"));
        return list;
    }

    private List<SelectItemResponseDTO> queryCheckTypeItem() {
        return enumsToSelectItems(CheckTypeEnum.values());
    }

    private List<SelectItemResponseDTO> queryCheckMethodItem() {
        // TODO query metadata interface

        List<SelectItemResponseDTO> list = new ArrayList<>();
        for (CheckMethodEnum checkMethodEnum : CheckMethodEnum.values()) {
            list.add(SelectItemResponseDTO.of(checkMethodEnum, checkMethodEnum.getName()));
        }
        return list;
    }

    private List<SelectItemResponseDTO> queryComparisonMethodItem() {
        return enumsToSelectItems(ComparisonMethodEnum.values());
    }

    private List<SelectItemResponseDTO> queryComparisonUnitItem() {
        return enumsToSelectItems(ComparisonUnitEnum.values());
    }

    private List<SelectItemResponseDTO> queryTaskStatusItem() {
        return enumsToSelectItems(ExecutionStatus.values());
    }

    private List<SelectItemResponseDTO> queryMetricsDimensionItem() {
        return enumsToSelectItems(MetricsDimensionEnum.values());
    }

    private List<SelectItemResponseDTO> querySubjectCategoryItem() {
        return enumsToSelectItems(SubjectCategoryEnum.values());
    }

    private List<SelectItemResponseDTO> enumsToSelectItems(Enum[] enums) {
        return Arrays.stream(enums)
            .map(value -> toSelectItem(value, value.name())).collect(Collectors.toList());
    }

    private SelectItemResponseDTO toSelectItem(Object value, String message) {
        try {
            message = messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
        } catch (Throwable throwable) {
            logger.error("select item value to i18n exception", throwable);
        }
        return SelectItemResponseDTO.of(value, message);
    }

}
