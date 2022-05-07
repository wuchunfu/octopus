package org.metahut.octopus.api.dto;

public class AlerterInstanceResponseDTO {

    private Integer id;

    private Long code;

    private String name;

    private String alertType;

    private String alertParams;

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

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertParams() {
        return alertParams;
    }

    public void setAlertParams(String alertParams) {
        this.alertParams = alertParams;
    }
}
