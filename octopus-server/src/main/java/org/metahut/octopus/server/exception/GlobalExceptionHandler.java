package org.metahut.octopus.server.exception;

import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.exception.BusinessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.util.stream.Collectors;

import static org.metahut.octopus.common.enums.StatusEnum.UNKNOWN_EXCEPTION;
import static org.metahut.octopus.common.enums.StatusEnum.VALIDATOR_EXCEPTION;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResultEntity exceptionHandler(BusinessException exception) {
        logger.error(exception.getMessage(), exception);
        String message = exception.getMessage();
        try {
            message = messageSource.getMessage(exception.getMessage(), exception.getArgs(), LocaleContextHolder.getLocale());
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage(), throwable);
        }
        return ResultEntity.of(exception.getCode(), message);
    }

    @ExceptionHandler(value = Exception.class)
    public ResultEntity exceptionHandler(Exception exception) {
        logger.error(exception.getMessage(), exception);
        String message = messageSource.getMessage(UNKNOWN_EXCEPTION.getMessage(), new Object[]{exception.getMessage()}, LocaleContextHolder.getLocale());
        return ResultEntity.of(UNKNOWN_EXCEPTION.getCode(), message);
    }

    /**
     * constraint violation exception handler
     * @param exception ConstraintViolationException
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultEntity constraintViolationException(ConstraintViolationException exception) {
        logger.error(exception.getMessage(), exception);
        String message = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        return ResultEntity.of(VALIDATOR_EXCEPTION.getCode(), message);
    }

    /**
     * method argument not valid exception handler
     * @param exception MethodArgumentNotValidException
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        logger.error(exception.getMessage(), exception);
        String message = exception.getBindingResult().getFieldError().getDefaultMessage();
        return ResultEntity.of(VALIDATOR_EXCEPTION.getCode(), message);
    }

}
