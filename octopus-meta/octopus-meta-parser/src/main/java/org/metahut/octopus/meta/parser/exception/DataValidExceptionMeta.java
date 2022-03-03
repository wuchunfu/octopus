package org.metahut.octopus.meta.parser.exception;

/**
 *
 */
public class DataValidExceptionMeta extends AbstractMetaParserException {

    public DataValidExceptionMeta() {
    }

    public DataValidExceptionMeta(String message) {
        super(message);
    }

    public DataValidExceptionMeta(String message, Throwable cause) {
        super(message, cause);
    }

    public DataValidExceptionMeta(Throwable cause) {
        super(cause);
    }

    public DataValidExceptionMeta(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
