package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

public class PageRequestDTO {

    @ApiModelProperty(value = "page number", required = true)
    private Integer pageNo;

    @ApiModelProperty(value = "page size", required = true)
    private Integer pageSize;

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

}
