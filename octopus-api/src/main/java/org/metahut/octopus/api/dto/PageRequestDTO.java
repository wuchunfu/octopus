package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class PageRequestDTO {

    @ApiModelProperty(value = "page number", required = true)
    @NotNull(message = "{parameter.not.null}", groups = Page.class)
    private Integer pageNo;

    @ApiModelProperty(value = "page size", required = true)
    @NotNull(message = "{parameter.not.null}", groups = Page.class)
    private Integer pageSize;

    public interface Page {
    }

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
