package org.metahut.octopus.metrics.api;

public interface IMetricsManager {

    String getType();

    IMetrics generateInstance(AbstractMetricsParameter parameter);
}
