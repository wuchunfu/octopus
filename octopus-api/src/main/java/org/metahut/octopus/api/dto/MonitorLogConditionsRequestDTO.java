package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "monitor log conditions request dto")
public class MonitorLogConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "datasourceCode")
    private String datasourceCode;

    @ApiModelProperty(value = "datasetCode")
    private String datasetCode;

    @ApiModelProperty(value = "subjectCategory")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "metricsCode")
    private String metricsCode;

    @ApiModelProperty(value = "metricsConfigCode")
    private Long metricsConfigCode;

    @ApiModelProperty(value = "checkType")
    private String checkType;

    @ApiModelProperty(value = "checkMethod")
    private String checkMethod;

    @ApiModelProperty(value = "error")
    private Boolean error;

    @ApiModelProperty(value = "errorStartTime")
    private Date errorStartTime;

    @ApiModelProperty(value = "errorEndTime")
    private Date errorEndTime;

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

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public Long getMetricsConfigCode() {
        return metricsConfigCode;
    }

    public void setMetricsConfigCode(Long metricsConfigCode) {
        this.metricsConfigCode = metricsConfigCode;
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

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Date getErrorStartTime() {
        return errorStartTime;
    }

    public void setErrorStartTime(Date errorStartTime) {
        this.errorStartTime = errorStartTime;
    }

    public Date getErrorEndTime() {
        return errorEndTime;
    }

    public void setErrorEndTime(Date errorEndTime) {
        this.errorEndTime = errorEndTime;
    }
}
