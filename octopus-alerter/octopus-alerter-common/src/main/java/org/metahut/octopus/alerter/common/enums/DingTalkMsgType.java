package org.metahut.octopus.alerter.common.enums;

public enum DingTalkMsgType {

    TEXT(1, "text"),
    MARKDOWN(2, "markdown");

    private final int code;
    private final String message;

    DingTalkMsgType(int code, String message) {
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
