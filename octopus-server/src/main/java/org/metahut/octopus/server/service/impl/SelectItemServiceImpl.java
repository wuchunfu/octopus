package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.SelectItemRequestDTO;
import org.metahut.octopus.api.dto.SelectItemResponseDTO;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.common.enums.SelectItemNameEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.server.service.MetaService;
import org.metahut.octopus.server.service.SelectItemService;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
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
        return metaService.queryAllSourceCategories().stream().map(category -> SelectItemResponseDTO.of(category, category)).collect(Collectors.toList());
    }

    private List<SelectItemResponseDTO> queryExecutorTypeItem() {
        // TODO query metadata interface

        List<SelectItemResponseDTO> list = new ArrayList<>();
        list.add(SelectItemResponseDTO.of("Flink", "Flink"));
        return list;
    }

    private List<SelectItemResponseDTO> queryCheckTypeItem() {
        // TODO query metadata interface

        List<SelectItemResponseDTO> list = new ArrayList<>();
        list.add(SelectItemResponseDTO.of("Num", "数值类型"));
        list.add(SelectItemResponseDTO.of("Rate", "波动率类型"));
        return list;
    }

    private List<SelectItemResponseDTO> queryCheckMethodItem() {
        // TODO query metadata interface

        List<SelectItemResponseDTO> list = new ArrayList<>();
        list.add(SelectItemResponseDTO.of("FixedValue", "与固定值比较"));
        list.add(SelectItemResponseDTO.of("7-DayAverage", "7天平均值波动"));
        return list;
    }

    private List<SelectItemResponseDTO> queryComparisonMethodItem() {
        // TODO query metadata interface

        List<SelectItemResponseDTO> list = new ArrayList<>();
        list.add(SelectItemResponseDTO.of("FixedValue", "与固定值比较"));
        list.add(SelectItemResponseDTO.of("7-DayAverage", "7天平均值波动"));
        return list;
    }

    private List<SelectItemResponseDTO> queryComparisonUnitItem() {
        // TODO query metadata interface

        List<SelectItemResponseDTO> list = new ArrayList<>();
        list.add(SelectItemResponseDTO.of("GT", "大于"));
        list.add(SelectItemResponseDTO.of("LT", "小于"));
        return list;
    }

    private List<SelectItemResponseDTO> queryTaskStatusItem() {
        // TODO query metadata interface

        List<SelectItemResponseDTO> list = new ArrayList<>();
        list.add(SelectItemResponseDTO.of("Hive", "运行中"));
        list.add(SelectItemResponseDTO.of("Pulsar", "失败"));
        return list;
    }

    private List<SelectItemResponseDTO> queryDateFormatItem() {
        // TODO query metadata interface
        DateTimeFormatter.ofPattern("");
        List<SelectItemResponseDTO> list = new ArrayList<>();
        list.add(SelectItemResponseDTO.of("Hive", "运行中"));
        list.add(SelectItemResponseDTO.of("Pulsar", "失败"));
        return list;
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
