package org.metahut.octopus.meta.starfish;

import org.metahut.octopus.meta.api.IMeta;
import org.metahut.octopus.meta.api.MetaDatabaseEntity;
import org.metahut.octopus.meta.api.MetaDatabaseRequest;
import org.metahut.octopus.meta.api.MetaDatasetEntity;
import org.metahut.octopus.meta.api.MetaDatasetRequest;
import org.metahut.octopus.meta.api.MetaDatasourceEntity;
import org.metahut.octopus.meta.api.MetaDatasourceRequest;
import org.metahut.octopus.meta.api.MetaDatasourceTypeEntity;
import org.metahut.octopus.meta.api.MetaDatasourceTypeRequest;
import org.metahut.octopus.meta.api.MetaProperties;
import org.metahut.octopus.meta.api.MetaSchemaEntity;
import org.metahut.octopus.meta.api.PageResponseDTO;
import org.metahut.octopus.meta.api.ResultEntity;
import org.metahut.octopus.meta.starfish.bean.Class;
import org.metahut.octopus.meta.starfish.bean.HiveClusterResponseDTO;
import org.metahut.octopus.meta.starfish.bean.HiveDBResponseDTO;
import org.metahut.octopus.meta.starfish.bean.HiveTableResponseDTO;
import org.metahut.octopus.meta.starfish.bean.PulsarClusterResponseDTO;
import org.metahut.octopus.meta.starfish.bean.PulsarNamespaceResponseDTO;
import org.metahut.octopus.meta.starfish.bean.PulsarTopicResponseDTO;
import org.metahut.octopus.meta.starfish.bean.SourceResponseDTO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class StarfishMeta implements IMeta {

    private Logger logger = LoggerFactory.getLogger(StarfishMeta.class);

    private final OkHttpClient client;
    private final MetaProperties.Starfish properties;

    public StarfishMeta(OkHttpClient client, MetaProperties.Starfish properties) {
        this.client = client;
        this.properties = properties;
    }

    @Override
    public PageResponseDTO<MetaDatasourceTypeEntity> queryDatasourceTypeListPage(MetaDatasourceTypeRequest datasourceTypeRequest) {
        try {
            String resultJson = get(MessageFormat.format("/entity/sources?name={0}&pageNo={1}&pageSize={2}",
                    datasourceTypeRequest.getName(),datasourceTypeRequest.getPageNo(),datasourceTypeRequest.getPageSize()));
            ResultEntity<PageResponseDTO<SourceResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                    new TypeReference<ResultEntity<PageResponseDTO<SourceResponseDTO>>>() {});
            if (resultEntity.isSuccess()) {
                PageResponseDTO<SourceResponseDTO> data = resultEntity.getData();
                return PageResponseDTO.of(data.getPageNo(),data.getPageSize(),data.getTotal(),
                        data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                            MetaDatasourceTypeEntity entity = new MetaDatasourceTypeEntity();
                            entity.setId(sourceResponseDTO.getId());
                            entity.setName(sourceResponseDTO.getQualifiedName());
                            return entity;
                        }).collect(Collectors.toList()));
            }

        } catch (Exception exception) {
            logger.error(exception.getMessage(),exception);
        }
        return null;
    }

    @Override
    public PageResponseDTO<MetaDatasourceEntity> queryDatasourceListPage(MetaDatasourceRequest metaDatasourceRequest) {
        try {
            if ("Hive".equals(metaDatasourceRequest.getDataSourceType())) {
                String resultJson = get(MessageFormat.format("/entity/hiveClusters?clusterName={0}&pageNo={1}&pageSize={2}",
                        metaDatasourceRequest.getName(),
                        metaDatasourceRequest.getPageNo(),
                        metaDatasourceRequest.getPageSize()));
                ResultEntity<PageResponseDTO<HiveClusterResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<HiveClusterResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<HiveClusterResponseDTO> data = resultEntity.getData();
                    return PageResponseDTO.of(data.getPageNo(),data.getPageSize(),data.getTotal(),
                            data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                                MetaDatasourceEntity entity = new MetaDatasourceEntity();
                                entity.setCode(sourceResponseDTO.getId());
                                entity.setName(sourceResponseDTO.getName());
                                entity.setType(sourceResponseDTO.getType());
                                return entity;
                            }).collect(Collectors.toList()));
                }
            } else if ("Pulsar".equals(metaDatasourceRequest.getDataSourceType())) {
                String resultJson = get(MessageFormat.format("/entity/pulsarClusters?name={0}&pageNo={1}&pageSize={2}",
                        metaDatasourceRequest.getName(),
                        metaDatasourceRequest.getPageNo(),
                        metaDatasourceRequest.getPageSize()));
                ResultEntity<PageResponseDTO<PulsarClusterResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<PulsarClusterResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<PulsarClusterResponseDTO> data = resultEntity.getData();
                    return PageResponseDTO.of(data.getPageNo(),data.getPageSize(),data.getTotal(),
                            data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                                MetaDatasourceEntity entity = new MetaDatasourceEntity();
                                entity.setCode(sourceResponseDTO.getId());
                                entity.setName(sourceResponseDTO.getName());
                                entity.setType(sourceResponseDTO.getType());
                                return entity;
                            }).collect(Collectors.toList()));
                }
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage(),exception);
        }
        return null;
    }

    @Override
    public PageResponseDTO<MetaDatabaseEntity> queryDatabaseListPage(MetaDatabaseRequest request) {
        try {
            if ("Hive".equals(request.getDataSourceType())) {
                String resultJson = get(MessageFormat.format("/entity/hiveDbs?id={0}&name={1}&pageNo={2}&pageSize={3}",
                        request.getCode(),
                        request.getName(),
                        request.getPageNo(),
                        request.getPageSize()));
                ResultEntity<PageResponseDTO<HiveDBResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<HiveDBResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<HiveDBResponseDTO> data = resultEntity.getData();
                    return PageResponseDTO.of(data.getPageNo(),data.getPageSize(),data.getTotal(),
                            data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                                MetaDatabaseEntity entity = new MetaDatabaseEntity();
                                entity.setCode(String.valueOf(sourceResponseDTO.getId()));
                                entity.setName(sourceResponseDTO.getName());
                                return entity;
                            }).collect(Collectors.toList()));
                }
            } else if ("Pulsar".equals(request.getDataSourceType())) {
                String resultJson = get(MessageFormat.format("/entity/pulsarNamespaces?id={0}&name={1}&pageNo={2}&pageSize={3}",
                        request.getCode(),
                        request.getName(),
                        request.getPageNo(),
                        request.getPageSize()));
                ResultEntity<PageResponseDTO<PulsarNamespaceResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<PulsarNamespaceResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<PulsarNamespaceResponseDTO> data = resultEntity.getData();
                    return PageResponseDTO.of(data.getPageNo(),data.getPageSize(),data.getTotal(),
                            data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                                MetaDatabaseEntity entity = new MetaDatabaseEntity();
                                entity.setCode(String.valueOf(sourceResponseDTO.getId()));
                                entity.setName(sourceResponseDTO.getName());
                                return entity;
                            }).collect(Collectors.toList()));
                }
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage(),exception);
        }
        return null;
    }

    @Override
    public PageResponseDTO<MetaDatasetEntity> queryDatasetListPage(MetaDatasetRequest request) {
        try {
            if ("Hive".equals(request.getDataSourceType())) {
                String resultJson = get(MessageFormat.format("/entity/hiveTables?hiveClusterId={0}&hiveTableName={2}&pageNo={3}&pageSize={4}",
                        request.getDataSourceCode(),
                        request.getName(),
                        request.getPageNo(),
                        request.getPageSize()));
                ResultEntity<PageResponseDTO<HiveTableResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<HiveTableResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<HiveTableResponseDTO> data = resultEntity.getData();
                    return PageResponseDTO.of(data.getPageNo(),data.getPageSize(),data.getTotal(),
                            data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                                MetaDatasetEntity entity = new MetaDatasetEntity();

                                return entity;
                            }).collect(Collectors.toList()));
                }
            } else if ("Pulsar".equals(request.getDataSourceType())) {
                String resultJson = get(MessageFormat.format("/entity/pulsarTopics?clusterId={0}&topicName={1}&pageNo={2}&pageSize={3}",
                        request.getDataSourceCode(),
                        request.getName(),
                        request.getPageNo(),
                        request.getPageSize()));
                ResultEntity<PageResponseDTO<PulsarTopicResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<PulsarTopicResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<PulsarTopicResponseDTO> data = resultEntity.getData();
                    return PageResponseDTO.of(data.getPageNo(),data.getPageSize(),data.getTotal(),
                            data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                                MetaDatasourceTypeEntity entity = new MetaDatasourceTypeEntity();
                                entity.setId(sourceResponseDTO.getId());
                                entity.setName(sourceResponseDTO.getName());
                                return entity;
                            }).collect(Collectors.toList()));
                }
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage(),exception);
        }
        return null;
    }

    @Override
    public MetaDatasetEntity queryDatasetByCode(String code) {
        try {
            String typeJson = get(MessageFormat.format("/entity/queryTypeByInstanceId?id={0}", code));
            ResultEntity<Class> typeResponse = new ObjectMapper().readValue(typeJson, new TypeReference<ResultEntity<Class>>() {});
            if (typeResponse.isSuccess()) {
                String className = typeResponse.getData().fullClassName();
                String instanceJson = get(MessageFormat.format("/entity/queryById?id={0}", code));

                ResultEntity<Map> instanceResponse = new ObjectMapper().readValue(typeJson, new TypeReference<ResultEntity<Map>>() {});
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage(),exception);
        }

        MetaDatasetEntity metaDatasetEntity1 = new MetaDatasetEntity();
        metaDatasetEntity1.setCode("01");
        metaDatasetEntity1.setName("dwd_im_1");

        MetaDatasourceEntity metaDatasourceEntity1 = new MetaDatasourceEntity();
        metaDatasourceEntity1.setCode(1L);
        metaDatasourceEntity1.setName("Hive-IDC");
        metaDatasourceEntity1.setType("Hive");
        metaDatasetEntity1.setDatasource(metaDatasourceEntity1);

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
