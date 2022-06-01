package org.metahut.octopus.scheduler.api;

public enum ExecutionStatus {

    SUCCESS(1, "Succeed"),
    FAIL(2, "Failed");

    private final int code;
    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ExecutionStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
