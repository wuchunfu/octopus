package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "metrics result conditions request dto")
public class MetricsResultConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "datasoucreCode")
    private String datasoucreCode;

    @ApiModelProperty(value = "datasetCode")
    private String datasetCode;

    @ApiModelProperty(value = "metricsName")
    private String metricsName;

    @ApiModelProperty(value = "metricsConfigName")
    private String metricsConfigName;

    @ApiModelProperty(value = "isSample")
    private Boolean isSample;

    @ApiModelProperty(value = "createStartTime")
    private Date createStartTime;

    @ApiModelProperty(value = "createEndTime")
    private Date createEndTime;

    public String getDatasoucreCode() {
        return datasoucreCode;
    }

    public void setDatasoucreCode(String datasoucreCode) {
        this.datasoucreCode = datasoucreCode;
    }

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

    public String getMetricsConfigName() {
        return metricsConfigName;
    }

    public void setMetricsConfigName(String metricsConfigName) {
        this.metricsConfigName = metricsConfigName;
    }

    public Boolean getSample() {
        return isSample;
    }

    public void setSample(Boolean sample) {
        isSample = sample;
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
}
