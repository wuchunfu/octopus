package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

public class PageRequestDTO<T> {

    @ApiModelProperty(value = "page number", required = true)
    private Integer pageNo;

    @ApiModelProperty(value = "page size", required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "request params")
    private T params;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
