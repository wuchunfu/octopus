package org.metahut.octopus.meta.api;

import java.util.Collection;

public class MetaDatasetEntity {

    private String code;

    private String name;

    private String comment;

    private MetaDatabaseEntity database;

    private MetaDatasourceEntity datasource;

    private Collection<MetaSchemaEntity> schemas;

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

    public MetaDatabaseEntity getDatabase() {
        return database;
    }

    public void setDatabase(MetaDatabaseEntity database) {
        this.database = database;
    }

    public MetaDatasourceEntity getDatasource() {
        return datasource;
    }

    public void setDatasource(MetaDatasourceEntity datasource) {
        this.datasource = datasource;
    }

    public Collection<MetaSchemaEntity> getSchemas() {
        return schemas;
    }

    public void setSchemas(Collection<MetaSchemaEntity> schemas) {
        this.schemas = schemas;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
