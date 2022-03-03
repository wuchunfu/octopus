package org.metahut.octopus.meta.parser.exception;

/**
 *
 */
public class AttributeValidExceptionMeta extends AbstractMetaParserException {

    public AttributeValidExceptionMeta() {
    }

    public AttributeValidExceptionMeta(String message) {
        super(message);
    }

    public AttributeValidExceptionMeta(String message, Throwable cause) {
        super(message, cause);
    }

    public AttributeValidExceptionMeta(Throwable cause) {
        super(cause);
    }

    public AttributeValidExceptionMeta(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
