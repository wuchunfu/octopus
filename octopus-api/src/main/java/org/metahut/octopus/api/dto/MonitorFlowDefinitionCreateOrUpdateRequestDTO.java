package org.metahut.octopus.api.dto;

import java.util.List;

public class MonitorFlowDefinitionCreateOrUpdateRequestDTO {

    private Integer id;

    private Long code;

    private String sourceCode;

    private String crontab;

    private List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstances;

    private List<SourceAlertRelationCreateOrUpdateRequestDTO> sourceAlertRelations;

    private SampleInstanceCreateOrUpdateRequestDTO sampleInstance;

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

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public List<RuleInstanceCreateOrUpdateRequestDTO> getRuleInstances() {
        return ruleInstances;
    }

    public void setRuleInstances(List<RuleInstanceCreateOrUpdateRequestDTO> ruleInstances) {
        this.ruleInstances = ruleInstances;
    }

    public List<SourceAlertRelationCreateOrUpdateRequestDTO> getSourceAlertRelations() {
        return sourceAlertRelations;
    }

    public void setSourceAlertRelations(List<SourceAlertRelationCreateOrUpdateRequestDTO> sourceAlertRelations) {
        this.sourceAlertRelations = sourceAlertRelations;
    }

    public SampleInstanceCreateOrUpdateRequestDTO getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(SampleInstanceCreateOrUpdateRequestDTO sampleInstance) {
        this.sampleInstance = sampleInstance;
    }
}
