package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.CheckMethodEnum;
import org.metahut.octopus.common.enums.CheckTypeEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "monitor log response dto")
public class MonitorLogResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "datasoucre name")
    private String datasourceName;

    @ApiModelProperty(value = "dataset name")
    private String datasetName;

    @ApiModelProperty(value = "rule name")
    private String ruleName;

    @ApiModelProperty(value = "subject category")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "metrics name")
    private String metricsName;

    @ApiModelProperty(value = "metrics config name")
    private String metricsConfigName;

    @ApiModelProperty(value = "sample")
    private Boolean sample;

    @ApiModelProperty(value = "sample scale")
    private Double sampleScale;

    @ApiModelProperty(value = "check type")
    private CheckTypeEnum checkType;

    @ApiModelProperty(value = "check method")
    private CheckMethodEnum checkMethod;

    @ApiModelProperty(value = "error")
    private Boolean error;

    @ApiModelProperty(value = "crontab")
    private String crontab;

    @ApiModelProperty(value = "log description")
    private String description;

    @ApiModelProperty(value = "result")
    private String result;

    @ApiModelProperty(value = "report time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date reportTime;

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
        return sample;
    }

    public void setSample(Boolean sample) {
        sample = sample;
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
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }
}
