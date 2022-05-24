package org.metahut.octopus.api.dto;

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
    private MetaReponseDTO meta;

    @ApiModelProperty(value = "source alert relations")
    private List<SourceAlertRelationResponseDTO> sourceAlertRelations;

    @ApiModelProperty(value = "rule instances")
    private List<RuleInstanceResponseDTO> ruleInstances;

    @ApiModelProperty(value = "sample unstance")
    private SampleInstanceResponseDTO sampleInstance;

    @ApiModelProperty(value = "env")
    private String env;

    @ApiModelProperty(value = "crontab")
    private String crontab;

    @ApiModelProperty(value = "scheduler code")
    private String schedulerCode;

    @ApiModelProperty(value = "create time")
    private Date createTime;

    @ApiModelProperty(value = "update time")
    private Date updateTime;

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

    public MetaReponseDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaReponseDTO meta) {
        this.meta = meta;
    }

    public List<SourceAlertRelationResponseDTO> getSourceAlertRelations() {
        return sourceAlertRelations;
    }

    public void setSourceAlertRelations(List<SourceAlertRelationResponseDTO> sourceAlertRelations) {
        this.sourceAlertRelations = sourceAlertRelations;
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
}
