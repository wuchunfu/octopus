package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.MetricsCategoryEnum;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(description = "metrics conditions request dto")
public class MetricsConditionsRequestDTO {

    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "categories")
    private List<MetricsCategoryEnum> categories;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "metricsDimensions")
    private List<MetricsDimensionEnum> metricsDimensions;

    @ApiModelProperty(value = "createStartTime")
    private Date createStartTime;

    @ApiModelProperty(value = "createEndTime")
    private Date createEndTime;

    @ApiModelProperty(value = "updateStartTime")
    private Date updateStartTime;

    @ApiModelProperty(value = "updateEndTime")
    private Date updateEndTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MetricsCategoryEnum> getCategories() {
        return categories;
    }

    public void setCategories(List<MetricsCategoryEnum> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MetricsDimensionEnum> getMetricsDimensions() {
        return metricsDimensions;
    }

    public void setMetricsDimensions(List<MetricsDimensionEnum> metricsDimensions) {
        this.metricsDimensions = metricsDimensions;
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
