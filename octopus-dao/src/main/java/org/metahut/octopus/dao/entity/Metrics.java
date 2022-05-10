package org.metahut.octopus.dao.entity;

import org.metahut.octopus.common.enums.MetricsDimensionEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_octopus_metrics")
public class Metrics extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String code;

    private String name;

    private String category;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private MetricsDimensionEnum metricsDimension;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MetricsDimensionEnum getMetricsDimension() {
        return metricsDimension;
    }

    public void setMetricsDimension(MetricsDimensionEnum metricsDimension) {
        this.metricsDimension = metricsDimension;
    }
}
