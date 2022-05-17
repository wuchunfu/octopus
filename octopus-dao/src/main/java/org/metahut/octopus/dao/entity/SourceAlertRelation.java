package org.metahut.octopus.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_octopus_source_alert_relation")
public class SourceAlertRelation extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "source_code", referencedColumnName = "source_code")
    private RuleInstance ruleInstance;

    private Long alertInstancecode;

    private String alerter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RuleInstance getRuleInstance() {
        return ruleInstance;
    }

    public void setRuleInstance(RuleInstance ruleInstance) {
        this.ruleInstance = ruleInstance;
    }

    public Long getAlertInstancecode() {
        return alertInstancecode;
    }

    public void setAlertInstancecode(Long alertInstancecode) {
        this.alertInstancecode = alertInstancecode;
    }

    public String getAlerter() {
        return alerter;
    }

    public void setAlerter(String alerter) {
        this.alerter = alerter;
    }
}
