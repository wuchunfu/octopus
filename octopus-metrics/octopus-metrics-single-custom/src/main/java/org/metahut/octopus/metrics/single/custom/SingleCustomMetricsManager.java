package org.metahut.octopus.metrics.single.custom;

import org.metahut.octopus.metrics.api.AbstractMetricsParameter;
import org.metahut.octopus.metrics.api.IMetrics;
import org.metahut.octopus.metrics.api.IMetricsManager;
import org.metahut.octopus.metrics.api.JSONUtils;

public class SingleCustomMetricsManager implements IMetricsManager {
    @Override
    public String getType() {
        return "SingleCustom";
    }

    @Override
    public SingleCustomMetricsparameter deserializeParameter(String parameter) {
        return JSONUtils.parseObject(parameter, SingleCustomMetricsparameter.class);
    }
    @Override
    public IMetrics generateInstance(AbstractMetricsParameter parameter) {
        return null;
    }
}
