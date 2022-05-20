package org.metahut.octopus.monitordb.api;

import java.util.Date;

public class MonitorLogRequest extends PageRequest {

    private String datasourceCode;

    private String datasetCode;

    private String subjectCategory;

    private String metricsCode;

    private String metricsConfigCode;

    private String checkType;

    private String checkMethod;

    private Boolean error;

    private Date errorStartTime;

    private Date errorEndTime;

    public String getDatasourceCode() {
        return datasourceCode;
    }

    public void setDatasourceCode(String datasourceCode) {
        this.datasourceCode = datasourceCode;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public String getMetricsConfigCode() {
        return metricsConfigCode;
    }

    public void setMetricsConfigCode(String metricsConfigCode) {
        this.metricsConfigCode = metricsConfigCode;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Date getErrorStartTime() {
        return errorStartTime;
    }

    public void setErrorStartTime(Date errorStartTime) {
        this.errorStartTime = errorStartTime;
    }

    public Date getErrorEndTime() {
        return errorEndTime;
    }

    public void setErrorEndTime(Date errorEndTime) {
        this.errorEndTime = errorEndTime;
    }
}
