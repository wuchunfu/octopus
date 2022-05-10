package org.metahut.octopus.api.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PageResponseDTO<T> {
    @ApiModelProperty(value = "page number")
    private Integer pageNo;

    @ApiModelProperty(value = "page size")
    private Integer pageSize;

    @ApiModelProperty(value = "total")
    private Integer total;

    @ApiModelProperty(value = "data")
    private List<T> data;

    public static <T> PageResponseDTO of(Integer pageNo, Integer pageSize, Integer total, List<T> data) {
        PageResponseDTO response = new PageResponseDTO<>();
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        response.setTotal(total);
        response.setData(data);
        return response;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
