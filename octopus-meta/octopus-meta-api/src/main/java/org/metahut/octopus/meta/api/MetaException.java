package org.metahut.octopus.meta.api;

public class MetaException extends RuntimeException {

    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }

    public MetaException(Throwable cause) {
        super(cause);
    }
}
