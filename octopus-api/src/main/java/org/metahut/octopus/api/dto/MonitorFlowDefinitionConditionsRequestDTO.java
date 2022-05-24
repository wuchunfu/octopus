package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "monitor flow definition conditions request dto")
public class MonitorFlowDefinitionConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "dataset code")
    private String datasetCode;

    @ApiModelProperty(value = "datasource code")
    private String datasourceCode;

    @ApiModelProperty(value = "datasource type")
    private String datasourceType;

    @ApiModelProperty(value = "create start time")
    private Date createStartTime;

    @ApiModelProperty(value = "create end time")
    private Date createEndTime;

    @ApiModelProperty(value = "update start time")
    private Date updateStartTime;

    @ApiModelProperty(value = "update end time")
    private Date updateEndTime;


    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public String getDatasourceCode() {
        return datasourceCode;
    }

    public void setDatasourceCode(String datasourceCode) {
        this.datasourceCode = datasourceCode;
    }

    public String getDatasourceType() {
        return datasourceType;
    }

    public void setDatasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
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
