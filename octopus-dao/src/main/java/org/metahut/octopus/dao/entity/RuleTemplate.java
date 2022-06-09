package org.metahut.octopus.dao.entity;

import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.dao.converter.ListToStringConverter;

import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_octopus_rule_template")
public class RuleTemplate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long code;

    private String name;

    @ManyToOne
    @JoinColumn(name = "metrics_code", referencedColumnName = "code", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Metrics metrics;

    private String checkType;

    private String checkMethod;

    private String comparisonMethod;

    private String comparisonUnit;

    @Convert(converter = ListToStringConverter.class)
    private List<String> expectedValue;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private SubjectCategoryEnum subjectCategory;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod;
    }

    public String getComparisonMethod() {
        return comparisonMethod;
    }

    public void setComparisonMethod(String comparisonMethod) {
        this.comparisonMethod = comparisonMethod;
    }

    public List<String> getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(List<String> expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getComparisonUnit() {
        return comparisonUnit;
    }

    public void setComparisonUnit(String comparisonUnit) {
        this.comparisonUnit = comparisonUnit;
    }
}
