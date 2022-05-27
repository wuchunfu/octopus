package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.MetricsDimensionEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "metrics create or update request dto")
public class MetricsCreateOrUpdateRequestDTO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    private Integer id;

    @ApiModelProperty(value = "code")
    @NotEmpty(message = "{parameter.not.null}")
    private String code;

    @ApiModelProperty(value = "name")
    @NotEmpty(message = "{parameter.not.null}")
    private String name;

    @ApiModelProperty(value = "category")
    private String category;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "metrics dimension")
    @NotNull(message = "{parameter.not.null}")
    private MetricsDimensionEnum metricsDimension;

    public interface Create {

    }

    public interface Update {

    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MetricsDimensionEnum getMetricsDimension() {
        return metricsDimension;
    }

    public void setMetricsDimension(MetricsDimensionEnum metricsDimension) {
        this.metricsDimension = metricsDimension;
    }
}
