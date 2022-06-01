package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MonitorTaskInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.scheduler.api.PageResponse;
import org.metahut.octopus.scheduler.api.entity.TaskInstance;
import org.metahut.octopus.server.service.MonitorFlowDefinitionService;
import org.metahut.octopus.server.utils.Assert;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

import static org.metahut.octopus.common.enums.StatusEnum.FLOW_DEFINITION_CODE_NOT_EXIST;
import static org.metahut.octopus.server.utils.Constants.NAME_SPLICE_SYMBOL;

@Mapper(componentModel = "spring", uses = { MonitorFlowDefinitionService.class })
public interface SchedulerTaskInstanceToDTOConverter extends Converter<TaskInstance, MonitorTaskInstanceResponseDTO> {

    @Deprecated
    @BeforeMapping
    default void flowCodeHandler(TaskInstance source) {
        String[] split = source.getName().split(NAME_SPLICE_SYMBOL);
        if (split.length != 3) {
            Assert.notNull(null, FLOW_DEFINITION_CODE_NOT_EXIST, source.getName());
        }
        source.setFlowCode(split[2]);
    }

    @Override
    @Mappings({
        @Mapping(source = "state", target = "executionStatus"),
        @Mapping(source = "startTime", target = "taskStartTime"),
        @Mapping(source = "endTime", target = "taskEndTime"),
        @Mapping(source = "flowInstanceId", target = "schedulerFlowInstanceCode"),
        @Mapping(source = "id", target = "schedulerTaskInstanceCode"),
        @Mapping(source = "flowCode", target = "flowDefinition")
    })
    MonitorTaskInstanceResponseDTO convert(TaskInstance source);

    List<MonitorTaskInstanceResponseDTO> convert(List<TaskInstance> sources);

    PageResponseDTO<MonitorTaskInstanceResponseDTO> convert(PageResponse<TaskInstance> sources);

}
