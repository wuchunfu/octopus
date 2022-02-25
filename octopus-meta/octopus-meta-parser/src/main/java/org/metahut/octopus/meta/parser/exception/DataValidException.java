package org.metahut.octopus.meta.parser.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *
 */
public class DataValidException extends AbstractParserException {

    public DataValidException() {
    }

    public DataValidException(String message) {
        super(message);
    }

    public DataValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataValidException(Throwable cause) {
        super(cause);
    }

    public DataValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
