package org.metahut.octopus.dao.entity;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_octopus_alerter_instance")
public class AlerterInstance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dataset_code", insertable = false, updatable = false)
    private String datasetCode;

    @ManyToOne
    @JoinColumn(name = "alerter_source_code", referencedColumnName = "code", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private AlerterSource source;

    private String parameter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlerterSource getSource() {
        return source;
    }

    public void setSource(AlerterSource source) {
        this.source = source;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }
}
