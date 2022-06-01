package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorTaskInstanceConditionsRequestDTO;
import org.metahut.octopus.scheduler.api.parameters.TaskInstanceRequestParameter;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.core.convert.converter.Converter;

import java.util.StringJoiner;

import static org.metahut.octopus.server.utils.Constants.NAME_SPLICE_SYMBOL;

@Mapper(componentModel = "spring")
public interface SchedulerTaskInstanceFromDTOConverter extends Converter<MonitorTaskInstanceConditionsRequestDTO, TaskInstanceRequestParameter> {

    @Override
    @Mappings({
        @Mapping(source = "taskStartStartTime", target = "beginTime"),
        @Mapping(source = "taskStartEndTime", target = "endTime"),
        @Mapping(source = "source", target = "name", qualifiedByName = "taskInstanceNameHandler")
    })
    TaskInstanceRequestParameter convert(MonitorTaskInstanceConditionsRequestDTO source);

    @Deprecated
    @Named("taskInstanceNameHandler")
    default String taskInstanceNameHandler(MonitorTaskInstanceConditionsRequestDTO source) {

        if (StringUtils.isNotBlank(source.getFlowName())) {
            return source.getFlowName();
        }

        StringJoiner joiner = new StringJoiner(NAME_SPLICE_SYMBOL);
        if (StringUtils.isNotBlank(source.getDatasourceCode())) {
            joiner.add(source.getDatasourceCode());
        }

        if (StringUtils.isNotBlank(source.getDatasetCode())) {
            joiner.add(source.getDatasourceCode());
        }
        return joiner.toString();
    }
}
