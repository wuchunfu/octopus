package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class RuleInstanceConditionRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "tableCode")
    private Integer tableCode;

    @ApiModelProperty(value = "sourceCode")
    private Integer sourceCode;

    @ApiModelProperty(value = "dataType")
    private Integer dataType;

    @ApiModelProperty(value = "createStartTime")
    private Date createStartTime;

    @ApiModelProperty(value = "createEndTime")
    private Date createEndTime;

    @ApiModelProperty(value = "updateStartTime")
    private Date updateStartTime;

    @ApiModelProperty(value = "updateEndTime")
    private Date updateEndTime;

    public Integer getTableCode() {
        return tableCode;
    }

    public void setTableCode(Integer tableCode) {
        this.tableCode = tableCode;
    }

    public Integer getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(Integer sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
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
