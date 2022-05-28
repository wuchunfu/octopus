package org.metahut.octopus.metrics.api;

public interface IMetricsManager {

    String getType();

    AbstractMetricsParameter deserializeParameter(String parameter);

    IMetrics generateInstance(AbstractMetricsParameter parameter);
}
