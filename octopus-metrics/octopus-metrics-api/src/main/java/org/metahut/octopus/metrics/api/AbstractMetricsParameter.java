package org.metahut.octopus.metrics.api;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
public abstract class AbstractMetricsParameter {

    private String type;
    private String subjectCategory;
    private String subjectCode;
    private String metricsCode;
    private String filter;

    public String generateUniqueKey() {
        String key = generateKey(metricsCode, subjectCategory, subjectCode);
        return Objects.isNull(filter) || ("").equals(filter.trim()) ? key : generateKey(key, filter);
    }

    protected String generateKey(String... args) {
        return String.join("-", args);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

}
