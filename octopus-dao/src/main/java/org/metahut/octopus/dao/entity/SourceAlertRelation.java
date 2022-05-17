package org.metahut.octopus.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_octopus_source_alert_relation")
public class SourceAlertRelation extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String sourceCode;

    private Long alertInstanceCode;

    private String alerter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Long getAlertInstanceCode() {
        return alertInstanceCode;
    }

    public void setAlertInstanceCode(Long alertInstanceCode) {
        this.alertInstanceCode = alertInstanceCode;
    }

    public String getAlerter() {
        return alerter;
    }

    public void setAlerter(String alerter) {
        this.alerter = alerter;
    }
}
