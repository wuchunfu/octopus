package org.metahut.octopus.server.metrics;

import org.metahut.octopus.metrics.api.AbstractMetricsParameter;
import org.metahut.octopus.metrics.api.IMetricsManager;
import org.metahut.octopus.metrics.api.MetricsHeaderParameter;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

@Component
public class MetricsPluginHelper {

    private static final Map<String, IMetricsManager> METRICS_MANAGER_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        ServiceLoader.load(IMetricsManager.class).forEach(manager -> {

            String type = manager.getType();

            IMetricsManager metricsManager = METRICS_MANAGER_MAP.get(type);

            if (Objects.nonNull(metricsManager)) {
                throw new IllegalArgumentException(MessageFormat.format("Duplicate metrics type exists: {0}", type));
            }

            METRICS_MANAGER_MAP.put(type, manager);

        });
    }

    private IMetricsManager getMetricsManager(String type) {
        IMetricsManager manager = METRICS_MANAGER_MAP.get(type);
        if (Objects.isNull(manager)) {
            throw new IllegalArgumentException(MessageFormat.format("metrics type does not exists: {0}", type));
        }
        return manager;
    }

    public Collection<String> queryAllTypes() {
        return METRICS_MANAGER_MAP.keySet();
    }

    public String generateUniqueKey(String type, String parameter, MetricsHeaderParameter headerParameter) {
        AbstractMetricsParameter abstractMetricsParameter = getMetricsManager(type).deserializeParameter(parameter);
        abstractMetricsParameter.initHeader(headerParameter);
        return abstractMetricsParameter.generateUniqueKey();
    }

    public String generateUniqueKey(String parameter, MetricsHeaderParameter headerParameter) {
        String type = "SingleCustom";
        AbstractMetricsParameter abstractMetricsParameter = getMetricsManager(type).deserializeParameter(parameter);
        abstractMetricsParameter.initHeader(headerParameter);
        return abstractMetricsParameter.generateUniqueKey();
    }
}
