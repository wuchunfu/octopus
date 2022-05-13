package org.metahut.octopus.common.enums;

public enum StatusEnum {

    SUCCESS(200, "success"),
    UNKNOWN_EXCEPTION(10000, "UNKNOWN_EXCEPTION"),
    VALIDATOR_EXCEPTION(10001, ""),

    METRICS_NOT_EXIST(20001, "METRICS_NOT_EXIST"),

    FLOW_DEFINITION_NOT_EXIST(20101, "FLOW_DEFINITION_NOT_EXIST");

    private int code;

    private String message;

    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
