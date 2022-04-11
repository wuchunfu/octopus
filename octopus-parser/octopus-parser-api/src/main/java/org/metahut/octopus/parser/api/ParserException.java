package org.metahut.octopus.parser.api;

public class ParserException extends RuntimeException {

    private Integer code;

    public ParserException(String message) {
        super(message);
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
