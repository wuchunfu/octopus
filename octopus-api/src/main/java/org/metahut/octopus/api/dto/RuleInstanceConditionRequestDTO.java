package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class RuleInstanceConditionRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "datasetCode")
    private String datasetCode;

    private String metricsName;

    private String metricsCode;

    @ApiModelProperty(value = "createStartTime")
    private Date createStartTime;

    @ApiModelProperty(value = "createEndTime")
    private Date createEndTime;

    @ApiModelProperty(value = "updateStartTime")
    private Date updateStartTime;

    @ApiModelProperty(value = "updateEndTime")
    private Date updateEndTime;

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public Date getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(Date createStartTime) {
        this.createStartTime = createStartTime;
    }

    public Date getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(Date createEndTime) {
        this.createEndTime = createEndTime;
    }

    public Date getUpdateStartTime() {
        return updateStartTime;
    }

    public void setUpdateStartTime(Date updateStartTime) {
        this.updateStartTime = updateStartTime;
    }

    public Date getUpdateEndTime() {
        return updateEndTime;
    }

    public void setUpdateEndTime(Date updateEndTime) {
        this.updateEndTime = updateEndTime;
    }
}
