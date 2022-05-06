package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.MetricsCategoryEnum;
import org.metahut.octopus.common.enums.MetricsDimensionEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "metrics create or update request dto")
public class MetricsCreateOrUpdateRequestDTO {

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

    public MetricsDimensionEnum getMetricsDimension() {
        return metricsDimension;
    }

    public void setMetricsDimension(MetricsDimensionEnum metricsDimension) {
        this.metricsDimension = metricsDimension;
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
}
