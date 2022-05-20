package org.metahut.octopus.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class MetricsResultResponseDTO extends PageRequestDTO {

    @ApiModelProperty(value = "datasoucreName")
    private String datasourceName;

    @ApiModelProperty(value = "datasetName")
    private String datasetName;

    @ApiModelProperty(value = "metricsName")
    private String metricsName;

    @ApiModelProperty(value = "metricsConfigName")
    private String metricsConfigName;

    @ApiModelProperty(value = "isSample")
    private Boolean isSample;

    @ApiModelProperty(value = "value")
    private String value;

    @ApiModelProperty(value = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
