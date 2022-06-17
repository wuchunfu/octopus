package org.metahut.octopus.jobs.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MetricMessage implements Serializable {

    private String id;
    private String reportChannel;
    private String datasourceCode;
    private String datasourceName;
    private String datasetCode;
    private String datasetName;
    private String subjectCode;
    private String subjectCategory;
    private String metricsCode;
    private String metricsName;
    private Long metricsConfigCode;
    private String metricsUniqueKey;
    private String metricsValue;
    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT+8")
    private Date windowBeginTime;
    private Integer windowSize;
    private String windowUnit;
    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT+8")
    private Date scheduleTime;
    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT+8")
    private Date sendDate;
    private List<RuleInstance> ruleInstances;

    public String getId() {
        return id;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public String getMetricsUniqueKey() {
        return metricsUniqueKey;
    }

    public void setMetricsUniqueKey(String metricsUniqueKey) {
        this.metricsUniqueKey = metricsUniqueKey;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportChannel() {
        return reportChannel;
    }

    public void setReportChannel(String reportChannel) {
        this.reportChannel = reportChannel;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
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

    public List<RuleInstance> getRuleInstances() {
        return ruleInstances;
    }

    public void setRuleInstances(List<RuleInstance> ruleInstances) {
        this.ruleInstances = ruleInstances;
    }

    public String getDatasourceCode() {
        return datasourceCode;
    }

    public void setDatasourceCode(String datasourceCode) {
        this.datasourceCode = datasourceCode;
    }

    public Long getMetricsConfigCode() {
        return metricsConfigCode;
    }

    public void setMetricsConfigCode(Long metricsConfigCode) {
        this.metricsConfigCode = metricsConfigCode;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
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

    public Date getWindowBeginTime() {
        return windowBeginTime;
    }

    public void setWindowBeginTime(Date windowBeginTime) {
        this.windowBeginTime = windowBeginTime;
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

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }
}
