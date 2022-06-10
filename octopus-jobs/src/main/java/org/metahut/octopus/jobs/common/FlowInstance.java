package org.metahut.octopus.jobs.common;

import java.io.Serializable;

public class FlowInstance implements Serializable {
    private int code;
    private String message;
    private FlowData data;

    public FlowInstance() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FlowData getData() {
        return data;
    }

    public void setData(FlowData data) {
        this.data = data;
    }
}
