package org.metahut.octopus.meta.api;

/**
 * 数据库
 */
public class MetaDatabaseEntity {

    private String code;

    private String name;

    private MetaDatasourceEntity datasource;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MetaDatasourceEntity getDatasource() {
        return datasource;
    }

    public void setDatasource(MetaDatasourceEntity datasource) {
        this.datasource = datasource;
    }
}
