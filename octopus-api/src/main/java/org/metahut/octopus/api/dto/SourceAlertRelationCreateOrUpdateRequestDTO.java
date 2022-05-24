package org.metahut.octopus.api.dto;

public class SourceAlertRelationCreateOrUpdateRequestDTO {

    private Integer id;

    private String datasetCode;

    private Long alertInstanceCode;

    private String alerter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
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
