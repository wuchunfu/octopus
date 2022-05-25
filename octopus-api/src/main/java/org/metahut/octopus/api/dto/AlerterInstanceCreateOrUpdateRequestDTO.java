package org.metahut.octopus.api.dto;

public class AlerterInstanceCreateOrUpdateRequestDTO {

    private Integer id;

    private String datasetCode;

    private Long alertSourceCode;

    private String parameter;

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

    public Long getAlertSourceCode() {
        return alertSourceCode;
    }

    public void setAlertSourceCode(Long alertSourceCode) {
        this.alertSourceCode = alertSourceCode;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
