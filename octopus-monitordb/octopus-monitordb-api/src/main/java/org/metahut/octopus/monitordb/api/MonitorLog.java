package org.metahut.octopus.monitordb.api;

import java.io.Serializable;
import java.util.Date;

public class MonitorLog implements Serializable {

    private String id;

    private Long ruleInstanceCode;

    private Date windowBeginTime;

    private Integer windowSize;

    private String windowUnit;

    private Date scheduleTime;

    private String datasourceCode;

    private String datasetCode;

    private String metricsCode;
    private String metricsConfigCode;
    private String subjectCode;

    private String subjectCategory;

    private String checkType;

    private String checkMethod;

    private String comparisonMethod;

    private String comparisonUnit;

    private String metricsValue;

    private String expectedValue;

    private String result;

    private Integer error;

    private String errorInfo;

    private Date errorTime;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRuleInstanceCode() {
        return ruleInstanceCode;
    }

    public void setRuleInstanceCode(Long ruleInstanceCode) {
        this.ruleInstanceCode = ruleInstanceCode;
    }

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

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod;
    }

    public String getComparisonMethod() {
        return comparisonMethod;
    }

    public void setComparisonMethod(String comparisonMethod) {
        this.comparisonMethod = comparisonMethod;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComparisonUnit() {
        return comparisonUnit;
    }

    public void setComparisonUnit(String comparisonUnit) {
        this.comparisonUnit = comparisonUnit;
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

    public String getMetricsValue() {
        return metricsValue;
    }

    public void setMetricsValue(String metricsValue) {
        this.metricsValue = metricsValue;
    }
}
