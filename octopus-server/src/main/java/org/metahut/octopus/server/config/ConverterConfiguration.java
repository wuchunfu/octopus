package org.metahut.octopus.server.config;

import org.metahut.octopus.server.converter.FlowDefinitionToDTOConverter;
import org.metahut.octopus.server.converter.MetricsResultToDTOConverter;
import org.metahut.octopus.server.converter.MonitorLogToDTOConverter;

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
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(flowDefinitionToDTOConverter);
        registry.addConverter(metricsResultToDTOConverter);
        registry.addConverter(monitorLogToDTOConverter);

    }
}