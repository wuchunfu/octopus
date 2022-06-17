package org.metahut.octopus.alerter.server.dto;

import java.util.Date;

public class AlertStructuralRequestDTO {

    private Long ruleInstanceCode;

    private Date windowBeginTime;

    private Integer windowSize;

    private String windowUnit;

    private Date scheduleTime;

    private String datasourceCode;

    private String datasourceName;

    private String datasetCode;

    private String datasetName;

    private String metricsCode;

    private String metricsName;

    private String subjectCode;

    private String subjectCategory;

    private String checkType;

    private String checkMethod;

    private String comparisonMethod;

    private String comparisonUnit;

    private String metricsValue;

    private String actualValue;

    private String expectedValue;

    private Integer checkStatus;

    private String message;

    private String checkTime;

    public Long getRuleInstanceCode() {
        return ruleInstanceCode;
    }

    public void setRuleInstanceCode(Long ruleInstanceCode) {
        this.ruleInstanceCode = ruleInstanceCode;
    }

    public Date getWindowBeginTime() {
        return windowBeginTime;
    }

    public void setWindowBeginTime(Date windowBeginTime) {
        this.windowBeginTime = windowBeginTime;
    }

    public Integer getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(Integer windowSize) {
        this.windowSize = windowSize;
    }

    public String getWindowUnit() {
        return windowUnit;
    }

    public void setWindowUnit(String windowUnit) {
        this.windowUnit = windowUnit;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getDatasourceCode() {
        return datasourceCode;
    }

    public void setDatasourceCode(String datasourceCode) {
        this.datasourceCode = datasourceCode;
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(String subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getComparisonMethod() {
        return comparisonMethod;
    }

    public void setComparisonMethod(String comparisonMethod) {
        this.comparisonMethod = comparisonMethod;
    }

    public String getComparisonUnit() {
        return comparisonUnit;
    }

    public void setComparisonUnit(String comparisonUnit) {
        this.comparisonUnit = comparisonUnit;
    }

    public String getMetricsValue() {
        return metricsValue;
    }

    public void setMetricsValue(String metricsValue) {
        this.metricsValue = metricsValue;
    }

    public String getActualValue() {
        return actualValue;
    }

    public void setActualValue(String actualValue) {
        this.actualValue = actualValue;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }
}
