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
import org.metahut.octopus.meta.api.MetaException;
import org.metahut.octopus.meta.api.MetaProperties;
import org.metahut.octopus.meta.api.MetaSchemaEntity;
import org.metahut.octopus.meta.api.PageResponseDTO;
import org.metahut.octopus.meta.api.ResultEntity;
import org.metahut.octopus.meta.starfish.bean.Class;
import org.metahut.octopus.meta.starfish.bean.HiveClusterResponseDTO;
import org.metahut.octopus.meta.starfish.bean.HiveColumnResponseDTO;
import org.metahut.octopus.meta.starfish.bean.HiveDBResponseDTO;
import org.metahut.octopus.meta.starfish.bean.HiveTableResponseDTO;
import org.metahut.octopus.meta.starfish.bean.PulsarClusterResponseDTO;
import org.metahut.octopus.meta.starfish.bean.PulsarNamespaceResponseDTO;
import org.metahut.octopus.meta.starfish.bean.PulsarSchemaResponseDTO;
import org.metahut.octopus.meta.starfish.bean.PulsarTenantResponseDTO;
import org.metahut.octopus.meta.starfish.bean.PulsarTopicResponseDTO;
import org.metahut.octopus.meta.starfish.bean.SourceResponseDTO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StarfishMeta implements IMeta {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarfishMeta.class);

    private final OkHttpClient client;
    private final MetaProperties.Starfish properties;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public StarfishMeta(OkHttpClient client, MetaProperties.Starfish properties) {
        this.client = client;
        this.properties = properties;
    }

    @Override
    public PageResponseDTO<MetaDatasourceTypeEntity> queryDatasourceTypeListPage(MetaDatasourceTypeRequest datasourceTypeRequest) {
        try {
            Object resultJson =
                get(MessageFormat.format("/entity/sources?name={0}&pageNo={1}&pageSize={2}", StringUtils.isEmpty(datasourceTypeRequest.getName()) ? "" : datasourceTypeRequest.getName(),
                    datasourceTypeRequest.getPageNo(), datasourceTypeRequest.getPageSize()));
            PageResponseDTO<SourceResponseDTO> data = objectMapper.convertValue(resultJson, new TypeReference<PageResponseDTO<SourceResponseDTO>>() {
            });
            return PageResponseDTO.of(data.getPageNo(), data.getPageSize(), data.getTotal(), data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                MetaDatasourceTypeEntity entity = new MetaDatasourceTypeEntity();
                entity.setId(sourceResponseDTO.getId());
                entity.setName(sourceResponseDTO.getQualifiedName());
                return entity;
            }).collect(Collectors.toList()));
        } catch (Exception exception) {
            throw new MetaException(exception);
        }
    }

    @Override
    public PageResponseDTO<MetaDatasourceEntity> queryDatasourceListPage(MetaDatasourceRequest metaDatasourceRequest) {
        try {
            if ("Hive".equals(metaDatasourceRequest.getType())) {
                Object resultJson = get(MessageFormat.format("/entity/hiveClusters?clusterName={0}&pageNo={1}&pageSize={2}",
                    StringUtils.isEmpty(metaDatasourceRequest.getName()) ? "" : metaDatasourceRequest.getName(), metaDatasourceRequest.getPageNo(),
                    metaDatasourceRequest.getPageSize()));
                PageResponseDTO<HiveClusterResponseDTO> data = objectMapper.convertValue(resultJson, new TypeReference<PageResponseDTO<HiveClusterResponseDTO>>() {
                });
                return PageResponseDTO.of(data.getPageNo(), data.getPageSize(), data.getTotal(), data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                    MetaDatasourceEntity entity = new MetaDatasourceEntity();
                    entity.setCode(sourceResponseDTO.getId());
                    entity.setName(sourceResponseDTO.getName());
                    entity.setType(sourceResponseDTO.getType());
                    return entity;
                }).collect(Collectors.toList()));
            } else if ("Pulsar".equals(metaDatasourceRequest.getType())) {
                Object resultJson =
                    get(MessageFormat.format("/entity/pulsarClusters?name={0}&pageNo={1}&pageSize={2}", StringUtils.isEmpty(metaDatasourceRequest.getName()) ? "" : metaDatasourceRequest.getName(),
                        metaDatasourceRequest.getPageNo(),
                        metaDatasourceRequest.getPageSize()));
                PageResponseDTO<PulsarClusterResponseDTO> data = objectMapper.convertValue(resultJson, new TypeReference<PageResponseDTO<PulsarClusterResponseDTO>>() {
                });

                return PageResponseDTO.of(data.getPageNo(), data.getPageSize(), data.getTotal(), data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                    MetaDatasourceEntity entity = new MetaDatasourceEntity();
                    entity.setCode(sourceResponseDTO.getId());
                    entity.setName(sourceResponseDTO.getName());
                    entity.setType(sourceResponseDTO.getType());
                    return entity;
                }).collect(Collectors.toList()));
            }

            throw new MetaException("unsupported type:" + metaDatasourceRequest.getType());
        } catch (Exception exception) {
            throw new MetaException(exception);
        }
    }

    @Override
    public PageResponseDTO<MetaDatabaseEntity> queryDatabaseListPage(MetaDatabaseRequest request) {
        try {
            if ("Hive".equals(request.getDataSourceType())) {
                Object resultJson =
                    get(MessageFormat.format("/entity/hiveDbs?id={0}&name={1}&pageNo={2}&pageSize={3}",
                        Objects.isNull(request.getCode()) ? "" : request.getCode(),
                        StringUtils.isEmpty(request.getName()) ? "" : request.getName(),
                        request.getPageNo(), request.getPageSize()));
                PageResponseDTO<HiveDBResponseDTO> data = objectMapper.convertValue(resultJson, new TypeReference<PageResponseDTO<HiveDBResponseDTO>>() {
                });

                return PageResponseDTO.of(data.getPageNo(), data.getPageSize(), data.getTotal(), data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                    MetaDatabaseEntity entity = new MetaDatabaseEntity();
                    entity.setCode(String.valueOf(sourceResponseDTO.getId()));
                    entity.setName(sourceResponseDTO.getName());
                    return entity;
                }).collect(Collectors.toList()));

            } else if ("Pulsar".equals(request.getDataSourceType())) {
                Object resultJson =
                    get(MessageFormat.format("/entity/pulsarNamespaces?id={0}&name={1}&pageNo={2}&pageSize={3}",
                        Objects.isNull(request.getCode()) ? "" : request.getCode(),
                        StringUtils.isEmpty(request.getName()) ? "" : request.getName(),
                        request.getPageNo(), request.getPageSize()));
                PageResponseDTO<PulsarNamespaceResponseDTO> data = objectMapper.convertValue(resultJson, new TypeReference<PageResponseDTO<PulsarNamespaceResponseDTO>>() {
                });

                return PageResponseDTO.of(data.getPageNo(), data.getPageSize(), data.getTotal(), data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                    MetaDatabaseEntity entity = new MetaDatabaseEntity();
                    entity.setCode(String.valueOf(sourceResponseDTO.getId()));
                    entity.setName(sourceResponseDTO.getName());
                    return entity;
                }).collect(Collectors.toList()));

            }
            throw new MetaException("unsupported type:" + request.getDataSourceType());
        } catch (Exception exception) {
            throw new MetaException(exception);
        }
    }

    @Override
    public PageResponseDTO<MetaDatasetEntity> queryDatasetListPage(MetaDatasetRequest request) {
        try {
            if ("Hive".equals(request.getDataSourceType())) {
                Object resultJson =
                    get(MessageFormat.format("/entity/hiveTables?hiveClusterId={0}&hiveTableName={1}&pageNo={2}&pageSize={3}",
                        Objects.isNull(request.getDataSourceCode()) ? "" : request.getDataSourceCode(),
                        StringUtils.isEmpty(request.getName()) ? "" : request.getName(),
                        request.getPageNo(), request.getPageSize()));
                PageResponseDTO<HiveTableResponseDTO> data = objectMapper.convertValue(resultJson, new TypeReference<PageResponseDTO<HiveTableResponseDTO>>() {
                });

                return PageResponseDTO.of(data.getPageNo(), data.getPageSize(), data.getTotal(), data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                    MetaDatasetEntity entity = new MetaDatasetEntity();
                    entity.setCode(String.valueOf(sourceResponseDTO.getId()));
                    entity.setName(sourceResponseDTO.getName());

                    HiveDBResponseDTO db = sourceResponseDTO.getDb();
                    MetaDatabaseEntity database = new MetaDatabaseEntity();
                    database.setCode(String.valueOf(db.getId()));
                    database.setName(db.getName());
                    entity.setDatabase(database);

                    HiveClusterResponseDTO cluster = db.getCluster();
                    MetaDatasourceEntity datasource = new MetaDatasourceEntity();
                    datasource.setCode(cluster.getId());
                    datasource.setName(cluster.getName());
                    datasource.setType(cluster.getType());
                    entity.setDatasource(datasource);

                    List<MetaSchemaEntity> schemas = new ArrayList<>();
                    List<HiveColumnResponseDTO> columns = sourceResponseDTO.getColumns();
                    if (CollectionUtils.isNotEmpty(columns)) {
                        columns.stream().forEach(column -> {
                            MetaSchemaEntity schema = new MetaSchemaEntity();
                            schema.setName(column.getName());
                            schema.setCode(String.valueOf(column.getId()));
                            schemas.add(schema);
                        });
                    }
                    entity.setSchemas(schemas);
                    return entity;
                }).collect(Collectors.toList()));

            } else if ("Pulsar".equals(request.getDataSourceType())) {
                Object resultJson =
                    get(MessageFormat.format("/entity/pulsarTopics?clusterId={0}&topicName={1}&pageNo={2}&pageSize={3}",
                        Objects.isNull(request.getDataSourceCode()) ? "" : request.getDataSourceCode(),
                        StringUtils.isEmpty(request.getName()) ? "" : request.getName(),
                        request.getPageNo(),
                        request.getPageSize()));
                PageResponseDTO<PulsarTopicResponseDTO> data = objectMapper.convertValue(resultJson, new TypeReference<PageResponseDTO<PulsarTopicResponseDTO>>() {
                });
                return PageResponseDTO.of(data.getPageNo(), data.getPageSize(), data.getTotal(), data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {

                    MetaDatasetEntity entity = new MetaDatasetEntity();
                    entity.setCode(String.valueOf(sourceResponseDTO.getId()));
                    entity.setName(sourceResponseDTO.getName());

                    PulsarNamespaceResponseDTO namespace = sourceResponseDTO.getNamespace();
                    MetaDatabaseEntity database = new MetaDatabaseEntity();
                    database.setCode(String.valueOf(namespace.getId()));
                    database.setName(namespace.getName());
                    entity.setDatabase(database);

                    MetaDatasourceEntity datasource = new MetaDatasourceEntity();
                    dsFor:
                    for (PulsarTenantResponseDTO tenant : namespace.getTenant()) {
                        if (Objects.nonNull(tenant) && CollectionUtils.isNotEmpty(tenant.getAllowedClusters())) {
                            for (PulsarClusterResponseDTO cluster : tenant.getAllowedClusters()) {
                                if (Objects.nonNull(cluster)) {
                                    datasource.setType(cluster.getType());
                                    datasource.setName(cluster.getName());
                                    datasource.setCode(cluster.getId());
                                    break dsFor;
                                }
                            }
                        }
                    }
                    entity.setDatasource(datasource);

                    List<PulsarSchemaResponseDTO> schemas = sourceResponseDTO.getSchemas();
                    List<MetaSchemaEntity> schemaEntitys = new ArrayList<>();
                    if (CollectionUtils.isNotEmpty(schemas)) {
                        schemas.stream().forEach(schema -> {
                            MetaSchemaEntity schemaEntity = new MetaSchemaEntity();
                            schemaEntity.setName(schema.getName());
                            schemaEntity.setCode(String.valueOf(schema.getId()));
                            schemaEntitys.add(schemaEntity);
                        });
                    }
                    entity.setSchemas(schemaEntitys);

                    return entity;
                }).collect(Collectors.toList()));

            }
            throw new MetaException("unsupported type:" + request.getDataSourceType());
        } catch (Exception exception) {
            throw new MetaException(exception);
        }
    }

    @Override
    public MetaDatasetEntity queryDatasetByCode(String code) {
        try {
            Object typeJson = get(MessageFormat.format("/entity/queryTypeByInstanceId?id={0}", code));
            Class clazz = objectMapper.convertValue(typeJson, new TypeReference<Class>() {
            });
            String className = clazz.fullClassName();

            String body;
            if ("org.starfish.HiveTable".equals(className)) {
                body =
                    "{\"eachPointers\": {\"db\" : {\"relationType\": \"CHILD\", \"eachPointers\": {\"cluster\" : {\"relationType\": \"CHILD\", \"eachPointers\": {} } } }, "
                        + "\"columns\": {\"relationType\": \"CHILD\", \"eachPointers\": {} } }, \"id\": " + code + ", \"typeName\": \"org.starfish.HiveTable\"}";
            } else {
                body =
                    "{\"eachPointers\": {\"namespace\" : {\"relationType\": \"CHILD\", \"eachPointers\": {\"tenant\" : {\"relationType\": \"CHILD\", \"eachPointers\": {\"allowedClusters\" : "
                        + "{\"relationType\": \"CHILD\", \"eachPointers\": { } } } } } }, \"schemas\": {\"relationType\": \"CHILD\", \"eachPointers\": {} } }, \"id\": "
                        + code + " , \"typeName\": \"org.starfish.PulsarTopic\"}";
            }

            Object instanceJson = post("/entity/queryByIdAndTypeNameAndCondition", body);

            List<MetaSchemaEntity> schemas = new ArrayList<>();
            MetaDatasetEntity dataset = new MetaDatasetEntity();
            MetaDatabaseEntity database = new MetaDatabaseEntity();
            MetaDatasourceEntity datasource = new MetaDatasourceEntity();
            switch (className) {
                case "org.starfish.HiveTable":
                    HiveTableResponseDTO table = objectMapper.convertValue(instanceJson, new TypeReference<HiveTableResponseDTO>() {
                    });

                    dataset.setCode(String.valueOf(table.getId()));
                    dataset.setName(table.getName());
                    dataset.setComment(table.getDescription());

                    HiveDBResponseDTO db = table.getDb();
                    database.setCode(String.valueOf(db.getId()));
                    database.setName(db.getName());

                    HiveClusterResponseDTO hiveCluster = db.getCluster();
                    datasource.setCode(hiveCluster.getId());
                    datasource.setName(hiveCluster.getName());
                    datasource.setType(hiveCluster.getType());
                    if (CollectionUtils.isNotEmpty(table.getColumns())) {
                        table.getColumns().stream().forEach(column -> {
                            MetaSchemaEntity schema = new MetaSchemaEntity();
                            schema.setCode(String.valueOf(column.getId()));
                            schema.setName(column.getName());
                            schemas.add(schema);
                        });
                    }

                    break;

                case "org.starfish.PulsarTopic":
                    PulsarTopicResponseDTO topic = objectMapper.convertValue(instanceJson, new TypeReference<PulsarTopicResponseDTO>() {
                    });
                    dataset.setCode(String.valueOf(topic.getId()));
                    dataset.setName(topic.getName());

                    PulsarNamespaceResponseDTO namespace = topic.getNamespace();
                    database.setCode(String.valueOf(namespace.getId()));
                    database.setName(namespace.getName());

                    if (CollectionUtils.isNotEmpty(namespace.getTenant()) && CollectionUtils.isNotEmpty(namespace.getTenant().get(0).getAllowedClusters())) {
                        PulsarClusterResponseDTO pulsarCluster = namespace.getTenant().get(0).getAllowedClusters().get(0);
                        datasource.setType(pulsarCluster.getType());
                        datasource.setName(pulsarCluster.getName());
                        datasource.setCode(pulsarCluster.getId());

                    }

                    if (CollectionUtils.isNotEmpty(topic.getSchemas())) {
                        topic.getSchemas().stream().forEach(value -> {
                            MetaSchemaEntity schema = new MetaSchemaEntity();
                            schema.setCode(String.valueOf(value.getId()));
                            schema.setName(value.getName());
                            schemas.add(schema);
                        });
                    }

                    break;
                default:
            }
            dataset.setSchemas(schemas);
            dataset.setDatasource(datasource);
            dataset.setDatabase(database);

            return dataset;

        } catch (Exception exception) {
            throw new MetaException(exception);
        }
    }

    public Object get(String url) throws IOException {
        url = properties.getServiceUrl() + url;
        Request request = new Request.Builder().
            url(url).
            build();

        try (Response response = client.newCall(request).execute()) {
            ResultEntity<Object> resultEntity = objectMapper.readValue(response.body().string(), new TypeReference<ResultEntity<Object>>() {
            });
            if (resultEntity.isFailed()) {
                throw new UnknownServiceException(resultEntity.getMessage());
            }
            return resultEntity.getData();
        }
    }

    public Object post(String url, String body) throws IOException {
        MediaType mediatype = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(body, mediatype);

        url = properties.getServiceUrl() + url;
        Request request = new Request.Builder().
            url(url).
            post(requestBody).
            build();

        try (Response response = client.newCall(request).execute()) {
            ResultEntity<Object> resultEntity = objectMapper.readValue(response.body().string(), new TypeReference<ResultEntity<Object>>() {
            });
            if (resultEntity.isFailed()) {
                throw new UnknownServiceException(resultEntity.getMessage());
            }
            return resultEntity.getData();
        }

    }
}
