package org.metahut.octopus.alerter.dingtalk;

public enum MsgTypeEnum {

    TEXT("text"),
    MARKDOWN("markdown");

    private final String message;

    MsgTypeEnum(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

}
