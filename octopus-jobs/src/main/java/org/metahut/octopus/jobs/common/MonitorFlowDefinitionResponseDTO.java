package org.metahut.octopus.jobs.common;

import org.metahut.octopus.jobs.enums.WindowType;
import org.metahut.octopus.jobs.enums.WindowUnit;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(description = "monitor flow definition response dto")
public class MonitorFlowDefinitionResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "meta")
    private MetaDatasetResponseDTO meta;

    @ApiModelProperty(value = "alerter instances")
    private List<AlerterInstanceResponseDTO> alerterInstances;

    @ApiModelProperty(value = "rule instances")
    private List<RuleInstanceResponseDTO> ruleInstances;

    @ApiModelProperty(value = "sample instance")
    private SampleInstanceResponseDTO sampleInstance;

    @ApiModelProperty(value = "env")
    private String env;

    @ApiModelProperty(value = "crontab")
    private String crontab;

    @ApiModelProperty(value = "scheduler code")
    private String schedulerCode;

    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "create time")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "update time")
    private Date updateTime;

    @ApiModelProperty(value = "dateTimeFields")
    private List<DateTimeFieldConfig> dateTimeFields;

    @ApiModelProperty(value = "windowType")
    private WindowType windowType;

    @ApiModelProperty(value = "windowSize")
    private String windowSize;

    @ApiModelProperty(value = "windowUnit")
    private WindowUnit windowUnit;

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

    public MetaDatasetResponseDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDatasetResponseDTO meta) {
        this.meta = meta;
    }

    public List<AlerterInstanceResponseDTO> getAlerterInstances() {
        return alerterInstances;
    }

    public void setAlerterInstances(List<AlerterInstanceResponseDTO> alerterInstances) {
        this.alerterInstances = alerterInstances;
    }

    public List<RuleInstanceResponseDTO> getRuleInstances() {
        return ruleInstances;
    }

    public void setRuleInstances(List<RuleInstanceResponseDTO> ruleInstances) {
        this.ruleInstances = ruleInstances;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public String getSchedulerCode() {
        return schedulerCode;
    }

    public void setSchedulerCode(String schedulerCode) {
        this.schedulerCode = schedulerCode;
    }

    public SampleInstanceResponseDTO getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(SampleInstanceResponseDTO sampleInstance) {
        this.sampleInstance = sampleInstance;
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

    public WindowType getWindowType() {
        return windowType;
    }

    public void setWindowType(WindowType windowType) {
        this.windowType = windowType;
    }

    public String getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(String windowSize) {
        this.windowSize = windowSize;
    }

    public WindowUnit getWindowUnit() {
        return windowUnit;
    }

    public void setWindowUnit(WindowUnit windowUnit) {
        this.windowUnit = windowUnit;
    }

    public List<DateTimeFieldConfig> getDateTimeFields() {
        return dateTimeFields;
    }

    public void setDateTimeFields(List<DateTimeFieldConfig> dateTimeFields) {
        this.dateTimeFields = dateTimeFields;
    }
}
