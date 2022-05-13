package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.CreateTypeEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "metrics config response dto")
public class MetricsConfigResponseDTO {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "sourceCategory")
    private String sourceCategory;

    @ApiModelProperty(value = "metrics")
    private MetricsResponseDTO metrics;

    @ApiModelProperty(value = "subjectCategory")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "createType")
    private CreateTypeEnum createType;

    @ApiModelProperty(value = "metricsParams")
    private String metricsParams;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "creator")
    private Long creator;

    @ApiModelProperty(value = "updater")
    private Long updater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceCategory() {
        return sourceCategory;
    }

    public void setSourceCategory(String sourceCategory) {
        this.sourceCategory = sourceCategory;
    }

    public MetricsResponseDTO getMetrics() {
        return metrics;
    }

    public void setMetrics(MetricsResponseDTO metrics) {
        this.metrics = metrics;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public CreateTypeEnum getCreateType() {
        return createType;
    }

    public void setCreateType(CreateTypeEnum createType) {
        this.createType = createType;
    }

    public String getMetricsParams() {
        return metricsParams;
    }

    public void setMetricsParams(String metricsParams) {
        this.metricsParams = metricsParams;
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

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }
}
