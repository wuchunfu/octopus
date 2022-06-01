package org.metahut.octopus.meta.api;

public interface IMeta {

    PageResponseDTO<MetaDatasourceTypeEntity> queryDatasourceTypeListPage(MetaDatasourceTypeRequest datasourceTypeRequest);

    PageResponseDTO<MetaDatasourceEntity> queryDatasourceListPage(MetaDatasourceRequest metaDatasourceRequest);

    PageResponseDTO<MetaDatabaseEntity> queryDatabaseListPage(MetaDatabaseRequest metaDatasourceRequest);

    PageResponseDTO<MetaDatasetEntity> queryDatasetListPage(MetaDatasetRequest request);

    MetaDatasetEntity queryDatasetByCode(String code);

}
