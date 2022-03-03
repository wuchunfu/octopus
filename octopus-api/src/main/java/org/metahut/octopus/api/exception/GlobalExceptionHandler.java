package org.metahut.octopus.api.exception;

import org.metahut.octopus.api.dto.ResultEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.metahut.octopus.api.enums.Status.UNKNOWN_EXCEPTION;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResultEntity exceptionHandler(BusinessException exception) {
        logger.error(exception.getMessage(), exception);
        String message = messageSource.getMessage(exception.getMessage(), exception.getArgs(), LocaleContextHolder.getLocale());
        return ResultEntity.of(exception.getCode(), message);
    }

    @ExceptionHandler(value = Exception.class)
    public ResultEntity exceptionHandler(Exception exception) {
        logger.error(exception.getMessage(), exception);
        String message = messageSource.getMessage(UNKNOWN_EXCEPTION.getMessage(), new Object[]{exception.getMessage()}, LocaleContextHolder.getLocale());
        return ResultEntity.of(UNKNOWN_EXCEPTION.getCode(), message);
    }

}
