package org.metahut.octopus.alerter.api;

public class AlerterResult {

    private boolean status;
    private String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AlerterResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public AlerterResult(boolean status) {
        this.status = status;
    }
}
