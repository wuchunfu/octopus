package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.CheckMethodEnum;
import org.metahut.octopus.common.enums.CheckTypeEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "monitor log conditions request dto")
public class MonitorLogConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "datasoucreName")
    private String datasourceName;

    @ApiModelProperty(value = "datasetName")
    private String datasetName;

    @ApiModelProperty(value = "ruleName")
    private String ruleName;

    @ApiModelProperty(value = "subjectCategory")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "metricsName")
    private String metricsName;

    @ApiModelProperty(value = "metricsConfigName")
    private String metricsConfigName;

    @ApiModelProperty(value = "isSample")
    private Boolean isSample;

    @ApiModelProperty(value = "sampleScale")
    private Double sampleScale;

    @ApiModelProperty(value = "checkType")
    private CheckTypeEnum checkType;

    @ApiModelProperty(value = "checkMethod")
    private CheckMethodEnum checkMethod;

    @ApiModelProperty(value = "isError")
    private Boolean isError;

    @ApiModelProperty(value = "reportStartTime")
    private Date reportStartTime;

    @ApiModelProperty(value = "reportEndTime")
    private Date reportEndTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
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

    public Double getSampleScale() {
        return sampleScale;
    }

    public void setSampleScale(Double sampleScale) {
        this.sampleScale = sampleScale;
    }

    public CheckTypeEnum getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckTypeEnum checkType) {
        this.checkType = checkType;
    }

    public CheckMethodEnum getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(CheckMethodEnum checkMethod) {
        this.checkMethod = checkMethod;
    }

    public Boolean getError() {
        return isError;
    }

    public void setError(Boolean error) {
        isError = error;
    }

    public Date getReportStartTime() {
        return reportStartTime;
    }

    public void setReportStartTime(Date reportStartTime) {
        this.reportStartTime = reportStartTime;
    }

    public Date getReportEndTime() {
        return reportEndTime;
    }

    public void setReportEndTime(Date reportEndTime) {
        this.reportEndTime = reportEndTime;
    }
}
