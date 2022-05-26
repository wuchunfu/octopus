package org.metahut.octopus.meta.api;

import java.util.Collection;

public interface IMeta {

    Collection<MetaDatasourceEntity> queryDatasourceList(String name);

    Collection<MetaDatabaseEntity> queryDatabaseList(String datasourceCode);

    Collection<MetaDatasetEntity> queryDatasetList(MetaDatasetEntityRequest request);

    MetaDatasetEntity queryDatasetByCode(String code);

}
