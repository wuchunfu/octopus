package org.metahut.octopus.meta.api;

public enum Status {

    SUCCESS(200, "success"),
    UNKNOWN_EXCEPTION(10000, "UNKNOWN_EXCEPTION"),

    COLLECTOR_ADAPTER_TEST_CONNECTION_FAIL(20001, "COLLECTOR_ADAPTER_TEST_CONNECTION_FAIL"),
    COLLECTOR_TASK_CREATE_SCHEDULE_FAIL(20002, "COLLECTOR_TASK_CREATE_SCHEDULE_FAIL"),
    INIT_TYPE_MODEL_TO_LOAD_FILE_FAIL(30001, "INIT_TYPE_MODEL_TO_LOAD_FILE_FAIL")
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
