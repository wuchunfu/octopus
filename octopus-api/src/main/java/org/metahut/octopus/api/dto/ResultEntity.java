package org.metahut.octopus.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.metahut.octopus.common.enums.StatusEnum;

import static org.metahut.octopus.common.enums.StatusEnum.SUCCESS;

public class ResultEntity<T> {

    private Integer code;

    private String message;

    private T data;

    public ResultEntity() {

    }

    private ResultEntity(T data, StatusEnum status) {
        this.data = data;
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    private ResultEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResultEntity<T> of (Integer code, String message) {
        return new ResultEntity<>(code, message);
    }

    public static <T> ResultEntity<T> success(T data) {
        return new ResultEntity<>(data, SUCCESS);
    }

    public static <T> ResultEntity<T> success() {
        return success(null);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.isStatus(SUCCESS);
    }

    @JsonIgnore
    public boolean isFailed() {
        return !this.isSuccess();
    }

    public boolean isStatus(StatusEnum status) {
        return this.code != null && this.code.equals(status.getCode());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
