package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.MonitorTaskInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.MonitorTaskInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageResponseDTO;
import org.metahut.octopus.scheduler.api.PageResponse;
import org.metahut.octopus.scheduler.api.entity.TaskInstance;
import org.metahut.octopus.scheduler.api.parameters.TaskInstanceRequestParameter;
import org.metahut.octopus.server.service.MonitorTaskInstanceService;
import org.metahut.octopus.server.service.SchedulerService;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorTaskInstanceServiceImpl implements MonitorTaskInstanceService {

    private final ConversionService conversionService;
    private final SchedulerService schedulerService;

    public MonitorTaskInstanceServiceImpl(ConversionService conversionService, SchedulerService schedulerService) {
        this.conversionService = conversionService;
        this.schedulerService = schedulerService;
    }

    @Override
    public PageResponseDTO<MonitorTaskInstanceResponseDTO> queryListPage(MonitorTaskInstanceConditionsRequestDTO requestDTO) {
        TaskInstanceRequestParameter parameter = conversionService.convert(requestDTO, TaskInstanceRequestParameter.class);
        PageResponse<TaskInstance> taskInstancePageResponse = schedulerService.queryTaskInstanceListPage(parameter);

        List<MonitorTaskInstanceResponseDTO> convert = (List<MonitorTaskInstanceResponseDTO>) conversionService.convert(taskInstancePageResponse.getData(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(TaskInstance.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MonitorTaskInstanceResponseDTO.class)));
        return PageResponseDTO.of(taskInstancePageResponse.getPageNo(), taskInstancePageResponse.getPageSize(), taskInstancePageResponse.getTotal(), convert);
    }

}
