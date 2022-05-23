package org.metahut.octopus.monitordb.api;

import java.util.Date;

public class MetricsResult {

    private Integer id;

    private String reportChannel;

    private String sourceCode;

    private String subjectCode;

    private String subjectCategory;
    private String metricsCode;

    private String metricsUniqueKey;

    private String metricsValue;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportChannel() {
        return reportChannel;
    }

    public void setReportChannel(String reportChannel) {
        this.reportChannel = reportChannel;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
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

    public String getMetricsValue() {
        return metricsValue;
    }

    public void setMetricsValue(String metricsValue) {
        this.metricsValue = metricsValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
