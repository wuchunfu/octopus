package org.metahut.octopus.api.enums;

public enum Status {

    SUCCESS(200, "success"),
    UNKNOWN_EXCEPTION(10000, "UNKNOWN_EXCEPTION")
    ;

    private int code;

    private String message;

    Status(int code, String message) {
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
