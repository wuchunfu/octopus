package org.metahut.octopus.api.dto;

import java.util.Date;
import java.util.List;

public class MonitorFlowDefinitionResponseDTO {

    private Integer id;

    private Long code;

    private MetaReponseDTO meta;

    private List<SourceAlertRelationResponseDTO> sourceAlertRelations;

    private List<RuleInstanceResponseDTO> ruleInstances;

    private SampleInstanceResponseDTO sampleInstance;

    private String env;
    private String crontab;
    private String schedulerCode;

    private Date createTime;

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
