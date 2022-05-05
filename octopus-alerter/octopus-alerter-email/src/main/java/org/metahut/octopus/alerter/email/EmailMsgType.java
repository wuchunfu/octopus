package org.metahut.octopus.alerter.email;

public enum EmailMsgType {
    TEXT(1, "text"),
    HTML(2, "html");

    private final int code;
    private final String message;

    EmailMsgType(int code, String message) {
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
