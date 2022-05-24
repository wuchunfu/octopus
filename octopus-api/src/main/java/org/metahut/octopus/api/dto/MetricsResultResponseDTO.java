package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "metrics result response dto")
public class MetricsResultResponseDTO {

    @ApiModelProperty(value = "datasoucre name")
    private String datasourceName;

    @ApiModelProperty(value = "datasoucre name")
    private String datasourceCode;

    @ApiModelProperty(value = "dataset name")
    private String datasetName;

    @ApiModelProperty(value = "dataset code")
    private String datasetCode;

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

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public String getDatasourceCode() {
        return datasourceCode;
    }

    public void setDatasourceCode(String datasourceCode) {
        this.datasourceCode = datasourceCode;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
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
