package org.metahut.octopus.meta.starfish;

import org.metahut.octopus.meta.api.*;
import org.metahut.octopus.meta.api.MetaSchemaEntity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StarfishMeta implements IMeta {

    private final OkHttpClient client;
    private final MetaProperties.Starfish properties;

    public StarfishMeta(OkHttpClient client, MetaProperties.Starfish properties) {
        this.client = client;
        this.properties = properties;
    }

    @Override
    public Collection<MetaDatasourceEntity> queryDatasourceList(String name) {
        List<MetaDatasourceEntity> result = new ArrayList<>();
        MetaDatasourceEntity metaDatasourceEntity1 = new MetaDatasourceEntity();
        metaDatasourceEntity1.setCode("01");
        metaDatasourceEntity1.setName("Hive-IDC");
        metaDatasourceEntity1.setType("Hive");
        result.add(metaDatasourceEntity1);

        MetaDatasourceEntity metaDatasourceEntity2 = new MetaDatasourceEntity();
        metaDatasourceEntity2.setCode("02");
        metaDatasourceEntity2.setName("Hive-HW");
        metaDatasourceEntity2.setType("Hive");
        result.add(metaDatasourceEntity2);

        MetaDatasourceEntity metaDatasourceEntity3 = new MetaDatasourceEntity();
        metaDatasourceEntity3.setCode("03");
        metaDatasourceEntity3.setName("Pulsar-A");
        metaDatasourceEntity3.setType("Pulsar");
        result.add(metaDatasourceEntity3);
        return result;
    }

    @Override
    public Collection<MetaDatabaseEntity> queryDatabaseList(String datasourceCode) {
        Collection<MetaDatabaseEntity> result = new ArrayList<>();
        MetaDatabaseEntity metaDatabaseEntity1 = new MetaDatabaseEntity();
        metaDatabaseEntity1.setCode("01");
        metaDatabaseEntity1.setName("dwd");
        result.add(metaDatabaseEntity1);

        MetaDatabaseEntity metaDatabaseEntity2 = new MetaDatabaseEntity();
        metaDatabaseEntity2.setCode("02");
        metaDatabaseEntity2.setName("dws");
        result.add(metaDatabaseEntity2);

        return result;
    }

    @Override
    public Collection<MetaDatasetEntity> queryDatasetList(MetaDatasetEntityRequest request) {
        Collection<MetaDatasetEntity> result = new ArrayList<>();
        MetaDatasetEntity metaDatasetEntity1 = new MetaDatasetEntity();
        metaDatasetEntity1.setCode("01");
        metaDatasetEntity1.setName("dwd_im_1");

        Collection<MetaSchemaEntity> metaSchemaEntities1 = new ArrayList<>();
        MetaSchemaEntity metaSchemaEntity1 = new MetaSchemaEntity();
        metaSchemaEntity1.setCode("01");
        metaSchemaEntity1.setName("name");
        metaSchemaEntities1.add(metaSchemaEntity1);

        MetaSchemaEntity metaSchemaEntity2 = new MetaSchemaEntity();
        metaSchemaEntity2.setCode("02");
        metaSchemaEntity2.setName("code");
        metaSchemaEntities1.add(metaSchemaEntity2);

        MetaSchemaEntity metaSchemaEntity3 = new MetaSchemaEntity();
        metaSchemaEntity3.setCode("03");
        metaSchemaEntity3.setName("gender");
        metaSchemaEntities1.add(metaSchemaEntity3);

        metaDatasetEntity1.setSchemas(metaSchemaEntities1);

        MetaDatasourceEntity metaDatasourceEntity1 = new MetaDatasourceEntity();
        metaDatasourceEntity1.setCode("01");
        metaDatasourceEntity1.setName("Hive-IDC");
        metaDatasourceEntity1.setType("Hive");

        metaDatasetEntity1.setDatasource(metaDatasourceEntity1);

        MetaDatabaseEntity metaDatabaseEntity1 = new MetaDatabaseEntity();
        metaDatabaseEntity1.setCode("01");
        metaDatabaseEntity1.setName("dwd");
        metaDatasetEntity1.setDatabase(metaDatabaseEntity1);

        result.add(metaDatasetEntity1);

        return result;
    }

    @Override
    public MetaDatasetEntity queryDatasetByCode(String code) {
        MetaDatasetEntity metaDatasetEntity1 = new MetaDatasetEntity();
        metaDatasetEntity1.setCode("01");
        metaDatasetEntity1.setName("dwd_im_1");

        Collection<MetaSchemaEntity> metaSchemaEntities1 = new ArrayList<>();
        MetaSchemaEntity metaSchemaEntity1 = new MetaSchemaEntity();
        metaSchemaEntity1.setCode("01");
        metaSchemaEntity1.setName("name");
        metaSchemaEntities1.add(metaSchemaEntity1);

        MetaSchemaEntity metaSchemaEntity2 = new MetaSchemaEntity();
        metaSchemaEntity2.setCode("02");
        metaSchemaEntity2.setName("code");
        metaSchemaEntities1.add(metaSchemaEntity2);

        MetaSchemaEntity metaSchemaEntity3 = new MetaSchemaEntity();
        metaSchemaEntity3.setCode("03");
        metaSchemaEntity3.setName("gender");
        metaSchemaEntities1.add(metaSchemaEntity3);

        metaDatasetEntity1.setSchemas(metaSchemaEntities1);
        return metaDatasetEntity1;
    }

    public String get(String url) throws IOException {
        url = properties.getServiceUrl() + url;
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
