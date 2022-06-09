package org.metahut.octopus.server.config;

import org.metahut.octopus.server.converter.AlerterInstanceToDTOConverter;
import org.metahut.octopus.server.converter.FlowDefinitionFromDTOConverter;
import org.metahut.octopus.server.converter.FlowDefinitionToDTOConverter;
import org.metahut.octopus.server.converter.MetricsConfigFromDTOConverter;
import org.metahut.octopus.server.converter.MetricsResultToDTOConverter;
import org.metahut.octopus.server.converter.MonitorLogToDTOConverter;
import org.metahut.octopus.server.converter.RuleInstanceFromDTOConverter;
import org.metahut.octopus.server.converter.RuleInstanceSingleFromDTOConverter;
import org.metahut.octopus.server.converter.SchedulerTaskInstanceToDTOConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

@Configuration
public class ConverterConfiguration {

    @Autowired
    private FlowDefinitionToDTOConverter flowDefinitionToDTOConverter;
    @Autowired
    private MetricsResultToDTOConverter metricsResultToDTOConverter;
    @Autowired
    private MonitorLogToDTOConverter monitorLogToDTOConverter;
    @Autowired
    private FlowDefinitionFromDTOConverter flowDefinitionFromDTOConverter;
    @Autowired
    private AlerterInstanceToDTOConverter alerterInstanceToDTOConverter;
    @Autowired
    private MetricsConfigFromDTOConverter metricsConfigFromDTOConverter;
    @Autowired
    private RuleInstanceFromDTOConverter ruleInstanceFromDTOConverter;
    @Autowired
    private SchedulerTaskInstanceToDTOConverter schedulerTaskInstanceToDTOConverter;
    @Autowired
    private RuleInstanceSingleFromDTOConverter ruleInstanceSingleFromDTOConverter;

    @Autowired
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(flowDefinitionFromDTOConverter);
        registry.addConverter(flowDefinitionToDTOConverter);
        registry.addConverter(metricsResultToDTOConverter);
        registry.addConverter(monitorLogToDTOConverter);
        registry.addConverter(alerterInstanceToDTOConverter);
        registry.addConverter(metricsConfigFromDTOConverter);
        registry.addConverter(ruleInstanceFromDTOConverter);
        registry.addConverter(schedulerTaskInstanceToDTOConverter);
        registry.addConverter(ruleInstanceSingleFromDTOConverter);
    }
}