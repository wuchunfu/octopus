package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "metrics result response dto")
public class MetricsResultResponseDTO {

    @ApiModelProperty(value = "meta data")
    private MetaDatasetResponseDTO meta;

    @ApiModelProperty(value = "subject code")
    private String subjectCode;

    @ApiModelProperty(value = "subject category")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "metrics name")
    private String metricsName;

    @ApiModelProperty(value = "metrics code")
    private String metricsCode;

    @ApiModelProperty(value = "metrics value")
    private String metricsValue;

    @ApiModelProperty(value = "metrics unique key")
    private String metricsUniqueKey;

    @ApiModelProperty(value = "create time")
    private Date createTime;

    public MetaDatasetResponseDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDatasetResponseDTO meta) {
        this.meta = meta;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
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

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public String getMetricsValue() {
        return metricsValue;
    }

    public void setMetricsValue(String metricsValue) {
        this.metricsValue = metricsValue;
    }

    public String getMetricsUniqueKey() {
        return metricsUniqueKey;
    }

    public void setMetricsUniqueKey(String metricsUniqueKey) {
        this.metricsUniqueKey = metricsUniqueKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
