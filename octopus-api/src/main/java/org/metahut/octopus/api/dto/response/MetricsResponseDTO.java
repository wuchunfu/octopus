package org.metahut.octopus.api.dto.response;

import org.metahut.octopus.common.enums.MetricsCategoryEnum;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "metrics response dto")
public class MetricsResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "category")
    private MetricsCategoryEnum category;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "metricsDimension")
    private MetricsDimensionEnum metricsDimension;

    @ApiModelProperty(value = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "creator")
    private Integer creator;

    @ApiModelProperty(value = "updater")
    private Integer updater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public MetricsCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(MetricsCategoryEnum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getUpdater() {
        return updater;
    }

    public void setUpdater(Integer updater) {
        this.updater = updater;
    }

    public MetricsDimensionEnum getMetricsDimension() {
        return metricsDimension;
    }

    public void setMetricsDimension(MetricsDimensionEnum metricsDimension) {
        this.metricsDimension = metricsDimension;
    }
}
