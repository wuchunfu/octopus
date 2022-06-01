package org.metahut.octopus.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_octopus_flow_definition")
public class FlowDefinition extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long code;

    @Column(name = "dataset_code", insertable = false, updatable = false)
    private String datasetCode;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "dataset_code", referencedColumnName = "dataset_code", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<AlerterInstance> alerterInstances;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "dataset_code", referencedColumnName = "dataset_code", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<RuleInstance> ruleInstances;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "dataset_code", referencedColumnName = "dataset_code", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
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

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public List<AlerterInstance> getAlerterInstances() {
        return alerterInstances;
    }

    public void setAlerterInstances(List<AlerterInstance> alerterInstances) {
        this.alerterInstances = alerterInstances;
    }

    public List<RuleInstance> getRuleInstances() {
        return ruleInstances;
    }

    public void setRuleInstances(List<RuleInstance> ruleInstances) {
        this.ruleInstances = ruleInstances;
    }

    public SampleInstance getSampleInstance() {
        return sampleInstance;
    }

    public void setSampleInstance(SampleInstance sampleInstance) {
        this.sampleInstance = sampleInstance;
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
}
