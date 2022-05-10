package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.MetricsDimensionEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(description = "metrics config conditions request dto")
public class MetricsConfigConditionsRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "metrics config name")
    private String name;

    @ApiModelProperty(value = "sourceCategories")
    private List<String> sourceCategories;

    @ApiModelProperty(value = "metricsCode")
    private String metricsCode;

    @ApiModelProperty(value = "metricsName")
    private String metricsName;

    @ApiModelProperty(value = "metricsDescription")
    private String metricsDescription;

    @ApiModelProperty(value = "metricsDimensions")
    private List<MetricsDimensionEnum> metricsDimensions;

    @ApiModelProperty(value = "subjectCategories")
    private List<SubjectCategoryEnum> subjectCategories;

    @ApiModelProperty(value = "createStartTime")
    private Date createStartTime;

    @ApiModelProperty(value = "createEndTime")
    private Date createEndTime;

    @ApiModelProperty(value = "updateStartTime")
    private Date updateStartTime;

    @ApiModelProperty(value = "updateEndTime")
    private Date updateEndTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSourceCategories() {
        return sourceCategories;
    }

    public void setSourceCategories(List<String> sourceCategories) {
        this.sourceCategories = sourceCategories;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }

    public String getMetricsDescription() {
        return metricsDescription;
    }

    public void setMetricsDescription(String metricsDescription) {
        this.metricsDescription = metricsDescription;
    }

    public List<MetricsDimensionEnum> getMetricsDimensions() {
        return metricsDimensions;
    }

    public void setMetricsDimensions(List<MetricsDimensionEnum> metricsDimensions) {
        this.metricsDimensions = metricsDimensions;
    }

    public List<SubjectCategoryEnum> getSubjectCategories() {
        return subjectCategories;
    }

    public void setSubjectCategories(List<SubjectCategoryEnum> subjectCategories) {
        this.subjectCategories = subjectCategories;
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
