package org.metahut.octopus.meta.api;

/**
 * 表名/topic
 */
public class MetaDatasetRequest {

    private String dataSourceType;

    private String name;

    private Long dataSourceCode;

    private Integer pageSize;

    private Integer pageNo;

    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDataSourceCode() {
        return dataSourceCode;
    }

    public void setDataSourceCode(Long dataSourceCode) {
        this.dataSourceCode = dataSourceCode;
    }

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
}
