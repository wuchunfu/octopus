package org.metahut.octopus.alerter.api;

public class AlerterException extends RuntimeException {

    private Integer code;

    public AlerterException(String message) {
        super(message);
    }

    public AlerterException(String message, Throwable cause) {
        super(message, cause);
    }
}
