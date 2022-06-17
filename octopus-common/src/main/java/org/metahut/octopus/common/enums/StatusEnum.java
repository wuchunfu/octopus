package org.metahut.octopus.common.enums;

public enum StatusEnum {

    SUCCESS(200, "success"),
    UNKNOWN_EXCEPTION(10000, "UNKNOWN_EXCEPTION"),
    VALIDATOR_EXCEPTION(10001, ""),
    CONVERTER_EXCEPTION(10002, "CONVERTER_EXCEPTION"),

    METRICS_NOT_EXIST(20010, "METRICS_NOT_EXIST"),
    METRICS_DELETE_ERROR(20011, "METRICS_DELETE_ERROR"),
    SAMPLE_NOT_EXIST(20020, "SAMPLE_NOT_EXIST"),
    RULE_INSTANCE_NOT_EXIST(20030, "FLOW_NOT_EXIST"),
    METRICS_CONFIG_NOT_EXIST(20040, "METRICS_CONFIG_NOT_EXIST"),
    ALERT_SOURCE_NOT_EXIST(20050, "ALERT_SOURCE_NOT_EXIST"),
    RULE_INSTANCE_EXIST(20060, "RULE_INSTANCE_EXIST"),
    FLOW_DEFINITION_CODE_NOT_EXIST(20070, "FLOW_DEFINITION_CODE_NOT_EXIST");
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
