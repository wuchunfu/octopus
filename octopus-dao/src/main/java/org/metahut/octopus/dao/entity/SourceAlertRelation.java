package org.metahut.octopus.dao.entity;

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
    @JoinColumn(name = "source_code", referencedColumnName = "code")
    private AlerterInstance alertInstance;

    private String alerter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlerterInstance getAlertInstance() {
        return alertInstance;
    }

    public void setAlertInstance(AlerterInstance alertInstance) {
        this.alertInstance = alertInstance;
    }

    public String getAlerter() {
        return alerter;
    }

    public void setAlerter(String alerter) {
        this.alerter = alerter;
    }
}
