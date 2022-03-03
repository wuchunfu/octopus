package org.metahut.octopus.meta.parser.exception;

/**
 *
 */
public class ModelValidExceptionMeta extends AbstractMetaParserException {

    public ModelValidExceptionMeta() {
    }

    public ModelValidExceptionMeta(String message) {
        super(message);
    }

    public ModelValidExceptionMeta(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelValidExceptionMeta(Throwable cause) {
        super(cause);
    }

    public ModelValidExceptionMeta(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
