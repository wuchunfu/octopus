package org.metahut.octopus.monitordb.api;

import java.sql.Timestamp;
import java.util.Date;

public class MetricsResult {
    private Integer id;
    private String sourceCode;
    private String metricsCode;
    private String metricsConfigCode;
    private String result;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
