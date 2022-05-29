package org.metahut.octopus.metrics.api;

import java.util.Objects;

public abstract class AbstractMetricsParameter {

    private MetricsHeaderParameter headerParameter;

    public void initHeader(MetricsHeaderParameter headerParameter) {
        this.headerParameter = headerParameter;
    }

    public String generateUniqueKey() {
        String key = generateKey(headerParameter.getMetricsCode(), headerParameter.getSubjectCategory(), headerParameter.getSubjectCode());
        String filter = headerParameter.getFilter();
        return Objects.isNull(filter) || ("").equals(filter.trim()) ? key : generateKey(key, filter);
    }

    protected String generateKey(String... args) {
        return String.join("-", args);
    }

    public MetricsHeaderParameter getHeaderParameter() {
        return headerParameter;
    }
    
}
