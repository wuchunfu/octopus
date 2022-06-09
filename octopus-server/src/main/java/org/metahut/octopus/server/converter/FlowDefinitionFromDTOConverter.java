package org.metahut.octopus.server.converter;

import org.metahut.octopus.api.dto.MetaDatasetResponseDTO;
import org.metahut.octopus.api.dto.MonitorFlowDefinitionCreateOrUpdateRequestDTO;
import org.metahut.octopus.dao.entity.FlowDefinition;
import org.metahut.octopus.scheduler.api.parameters.ScheduleCronParameter;
import org.metahut.octopus.scheduler.api.parameters.ScheduleParameter;
import org.metahut.octopus.server.service.MetaService;
import org.metahut.octopus.server.service.MonitorFlowDefinitionService;
import org.metahut.octopus.server.service.SchedulerService;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
import java.util.StringJoiner;

import static org.metahut.octopus.server.utils.Constants.NAME_SPLICE_SYMBOL;

@Mapper(componentModel = "spring", uses = { AlerterInstanceFromDTOConverter.class, RuleInstanceFromDTOConverter.class })
public abstract class FlowDefinitionFromDTOConverter implements Converter<MonitorFlowDefinitionCreateOrUpdateRequestDTO, FlowDefinition> {

    @Override
    public abstract FlowDefinition convert(MonitorFlowDefinitionCreateOrUpdateRequestDTO source);

    @Autowired
    private SchedulerService schedulerService;

    @Autowired
    private MonitorFlowDefinitionService monitorFlowDefinitionService;

    @Autowired
    private MetaService metaService;

    @BeforeMapping
    public void updateSchedule(MonitorFlowDefinitionCreateOrUpdateRequestDTO source) {
        if (StringUtils.isBlank(source.getSchedulerCode())) {
            // create flow definition

            // TODO name parameter need to be optimized
            MetaDatasetResponseDTO dataset = metaService.queryDatasetByCode(source.getDatasetCode());
            StringJoiner taskName = new StringJoiner(NAME_SPLICE_SYMBOL)
                    .add(dataset.getDatasource().getCode())
                    .add(source.getDatasetCode())
                    .add(String.valueOf(source.getCode()));

            String schedulerCode = schedulerService.createMetricsProductionTaskAndAddSchedule(taskName.toString(), source.getCode(), source.getCrontab());
            source.setSchedulerCode(schedulerCode);
        } else {
            // update flow definition
            FlowDefinition one = monitorFlowDefinitionService.findOneByCode(source.getCode());
            if (Objects.nonNull(one) && !one.getCrontab().equals(source.getCrontab())) {
                ScheduleParameter scheduleParameter = new ScheduleParameter();
                scheduleParameter.setFlowCode(source.getSchedulerCode());
                ScheduleCronParameter scheduleCronParameter = new ScheduleCronParameter();
                scheduleCronParameter.setCrontab(source.getCrontab());
                scheduleParameter.setScheduleCronParameter(scheduleCronParameter);
                schedulerService.updateScheduleTimer(scheduleParameter);
            }
        }
    }

    @AfterMapping
    public void sampleHandler(@MappingTarget FlowDefinition target) {
        target.getRuleInstances().stream()
                .filter(ruleInstance -> BooleanUtils.isTrue(ruleInstance.getSample()))
                .forEach(ruleInstance -> ruleInstance.setSampleInstance(target.getSampleInstance()));
    }

}
