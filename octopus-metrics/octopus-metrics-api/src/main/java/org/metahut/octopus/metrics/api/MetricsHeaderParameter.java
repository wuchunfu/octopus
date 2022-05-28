package org.metahut.octopus.metrics.api;

public class MetricsHeaderParameter {

    private String subjectCategory;
    private String subjectCode;
    private String metricsCode;
    private String filter;

    public MetricsHeaderParameter() {
    }

    public MetricsHeaderParameter(String subjectCategory, String subjectCode, String metricsCode, String filter) {
        this.subjectCategory = subjectCategory;
        this.subjectCode = subjectCode;
        this.metricsCode = metricsCode;
        this.filter = filter;
    }

    public static MetricsHeaderParameter of(String subjectCategory, String subjectCode, String metricsCode, String filter) {
        return new MetricsHeaderParameter(subjectCategory, subjectCode, metricsCode, filter);
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
