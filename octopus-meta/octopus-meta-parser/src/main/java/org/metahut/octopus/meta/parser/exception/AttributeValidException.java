package org.metahut.octopus.meta.parser.exception;

/**
 *
 */
public class AttributeValidException extends AbstractParserException {

    public AttributeValidException() {
    }

    public AttributeValidException(String message) {
        super(message);
    }

    public AttributeValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public AttributeValidException(Throwable cause) {
        super(cause);
    }

    public AttributeValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
