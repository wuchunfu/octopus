package org.metahut.octopus.meta.api;

/**
 *
 */
public class MetaDatasourceTypeRequest {

    private Integer pageSize;

    private Integer pageNo;

    private String name;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
