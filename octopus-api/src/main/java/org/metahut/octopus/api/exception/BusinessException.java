package org.metahut.octopus.api.exception;

import org.metahut.octopus.common.enums.StatusEnum;

import org.springframework.lang.Nullable;

public class BusinessException extends RuntimeException {

    private Integer code;

    private Object[] args;

    public BusinessException(StatusEnum status, @Nullable Object[] args) {
        super(status.getMessage());
        this.code = status.getCode();
        this.args = args;
    }

    public BusinessException(StatusEnum status, Throwable cause) {
        super(status.getMessage(), cause);
        this.code = status.getCode();
    }

    public BusinessException(StatusEnum status, @Nullable Object[] args, Throwable cause) {
        super(status.getMessage(), cause);
        this.code = status.getCode();
        this.args = args;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
