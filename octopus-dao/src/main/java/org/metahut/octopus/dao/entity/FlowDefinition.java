package org.metahut.octopus.dao.entity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_octopus_flow_definition")
public class FlowDefinition extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Long code;

    @Column(name = "source_code", insertable = false, updatable = false)
    private String sourceCode;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "source_code", referencedColumnName = "source_code")
    private List<SourceAlertRelation> sourceAlertRelations;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "source_code", referencedColumnName = "source_code")
    private List<RuleInstance> ruleInstances;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "source_code", referencedColumnName = "source_code")
    private SampleInstance sampleInstance;

    private String env;
    private String crontab;
    private String schedulerCode;

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

    public List<SourceAlertRelation> getSourceAlertRelations() {
        return sourceAlertRelations;
    }

    public void setSourceAlertRelations(List<SourceAlertRelation> sourceAlertRelations) {
        this.sourceAlertRelations = sourceAlertRelations;
    }

    public List<RuleInstance> getRuleInstances() {
        return ruleInstances;
    }

    public void setRuleInstances(List<RuleInstance> ruleInstances) {
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

    public SampleInstance getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(SampleInstance sampleInstance) {
        this.sampleInstance = sampleInstance;
    }
}
