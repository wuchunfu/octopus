package org.metahut.octopus.monitordb.api.entity;

import java.sql.Timestamp;
import java.util.Date;

public class MonitorLog {
    private Integer id;
    private String sourceCode;
    private String metricsCode;
    private String metricsConfigCode;
    private String alerterCode;
    private Boolean error;
    private String result;
    private String description;
    private Date reportTime;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
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

    public String getAlerterCode() {
        return alerterCode;
    }

    public void setAlerterCode(String alerterCode) {
        this.alerterCode = alerterCode;
    }

    public Boolean getError() {
        return error;
    }

    public Boolean isError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public void setError(Integer error) {
        if (error != null) {
            setError(1 == error);
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
