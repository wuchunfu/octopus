package org.metahut.octopus.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_octopus_flow_definition")
public class FlowDefinition extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String sourceCode;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "source_code", referencedColumnName = "sourceCode")
    private List<SourceAlertRelation> sourceAlertRelations;

    private String env;
    private String crontab;
    private String schedulerCode;

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

    public List<SourceAlertRelation> getSourceAlertRelations() {
        return sourceAlertRelations;
    }

    public void setSourceAlertRelations(List<SourceAlertRelation> sourceAlertRelations) {
        this.sourceAlertRelations = sourceAlertRelations;
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
