package org.metahut.octopus.jobs.common;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class MetricInfo implements Serializable {

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
    private Date windowBeginTime;
    private Integer windowSize;
    private String windowUnit;
    private Date scheduleTime;
    private String executorScript;
    private Boolean sampleFlag = Boolean.TRUE;

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

    public String getExecutorScript() {
        return executorScript;
    }

    public void setExecutorScript(String executorScript) {
        this.executorScript = executorScript;
    }

    public Boolean getSampleFlag() {
        return sampleFlag;
    }

    public void setSampleFlag(Boolean sampleFlag) {
        this.sampleFlag = sampleFlag;
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

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(metricsUniqueKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof MetricInfo)) {
            return false;
        } else if (obj instanceof MetricInfo) {
            MetricInfo metricInfo = (MetricInfo)obj;
            return metricInfo.metricsUniqueKey.equals(metricsUniqueKey);
        }
        return false;
    }
}
