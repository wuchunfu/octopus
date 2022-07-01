package org.metahut.octopus.meta.starfish;

import org.metahut.octopus.common.utils.JSONUtils;
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
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class StarfishMeta implements IMeta {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarfishMeta.class);

    private final OkHttpClient client;
    private final MetaProperties.Starfish properties;

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
            if (resultJson == null) {
                return PageResponseDTO.of(datasourceTypeRequest.getPageNo(), datasourceTypeRequest.getPageSize(), 0L, null);
            }
            PageResponseDTO<SourceResponseDTO> data = JSONUtils.parseObject(resultJson, new TypeReference<PageResponseDTO<SourceResponseDTO>>() {
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
                if (resultJson == null) {
                    return PageResponseDTO.of(metaDatasourceRequest.getPageNo(), metaDatasourceRequest.getPageSize(), 0L, null);
                }
                PageResponseDTO<HiveClusterResponseDTO> data = JSONUtils.parseObject(resultJson, new TypeReference<PageResponseDTO<HiveClusterResponseDTO>>() {
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
                if (resultJson == null) {
                    return PageResponseDTO.of(metaDatasourceRequest.getPageNo(), metaDatasourceRequest.getPageSize(), 0L, null);
                }
                PageResponseDTO<PulsarClusterResponseDTO> data = JSONUtils.parseObject(resultJson, new TypeReference<PageResponseDTO<PulsarClusterResponseDTO>>() {
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
                    get(MessageFormat.format("/entity/hiveDbs?clusterId={0}&id={1}&name={2}&pageNo={3}&pageSize={4}",
                        StringUtils.isEmpty(request.getDatasourceCode()) ? "" : request.getDatasourceCode(),
                        Objects.isNull(request.getCode()) ? "" : String.valueOf(request.getCode()),
                        StringUtils.isEmpty(request.getName()) ? "" : request.getName(),
                        request.getPageNo(), request.getPageSize()));
                if (resultJson == null) {
                    return PageResponseDTO.of(request.getPageNo(), request.getPageSize(), 0L, null);
                }
                PageResponseDTO<HiveDBResponseDTO> data = JSONUtils.parseObject(resultJson, new TypeReference<PageResponseDTO<HiveDBResponseDTO>>() {
                });

                return PageResponseDTO.of(data.getPageNo(), data.getPageSize(), data.getTotal(), data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                    MetaDatabaseEntity entity = new MetaDatabaseEntity();
                    entity.setCode(String.valueOf(sourceResponseDTO.getId()));
                    entity.setName(sourceResponseDTO.getName());

                    HiveClusterResponseDTO cluster = sourceResponseDTO.getCluster();
                    if (Objects.nonNull(cluster)) {
                        MetaDatasourceEntity datasource = new MetaDatasourceEntity();
                        datasource.setType(cluster.getType());
                        datasource.setName(cluster.getName());
                        datasource.setCode(cluster.getId());
                        entity.setDatasource(datasource);
                    }


                    return entity;
                }).collect(Collectors.toList()));

            } else if ("Pulsar".equals(request.getDataSourceType())) {
                Object resultJson =
                    get(MessageFormat.format("/entity/pulsarNamespaces?id={0}&name={1}&pageNo={2}&pageSize={3}",
                        Objects.isNull(request.getCode()) ? "" : request.getCode(),
                        StringUtils.isEmpty(request.getName()) ? "" : request.getName(),
                        request.getPageNo(), request.getPageSize()));
                if (resultJson == null) {
                    return PageResponseDTO.of(request.getPageNo(), request.getPageSize(), 0L, null);
                }
                PageResponseDTO<PulsarNamespaceResponseDTO> data = JSONUtils.parseObject(resultJson, new TypeReference<PageResponseDTO<PulsarNamespaceResponseDTO>>() {
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
                    get(MessageFormat.format("/entity/hiveTables?hiveClusterId={0}&hiveDbCode={1}&hiveTableName={2}&pageNo={3}&pageSize={4}",
                        StringUtils.isEmpty(request.getDatasourceCode()) ? "" : request.getDatasourceCode(),
                        StringUtils.isEmpty(request.getDatabaseCode()) ? "" : request.getDatabaseCode(),
                        StringUtils.isEmpty(request.getName()) ? "" : request.getName(),
                        request.getPageNo(), request.getPageSize()));
                if (resultJson == null) {
                    return PageResponseDTO.of(request.getPageNo(), request.getPageSize(), 0L, null);
                }
                PageResponseDTO<HiveTableResponseDTO> data = JSONUtils.parseObject(resultJson, new TypeReference<PageResponseDTO<HiveTableResponseDTO>>() {
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

                    List<HiveColumnResponseDTO> columns = CollectionUtils.isNotEmpty(sourceResponseDTO.getColumns()) ? sourceResponseDTO.getColumns() : Collections.emptyList();
                    columns.addAll(CollectionUtils.isNotEmpty(sourceResponseDTO.getPartitionKeys()) ? sourceResponseDTO.getPartitionKeys() : Collections.emptyList());
                    columns.stream().forEach(column -> {
                        MetaSchemaEntity schema = new MetaSchemaEntity();
                        schema.setName(column.getName());
                        schema.setCode(String.valueOf(column.getId()));
                        schemas.add(schema);
                    });
                    entity.setSchemas(schemas);
                    return entity;
                }).collect(Collectors.toList()));

            } else if ("Pulsar".equals(request.getDataSourceType())) {
                Object resultJson =
                    get(MessageFormat.format("/entity/pulsarTopics?clusterId={0}&topicName={1}&pageNo={2}&pageSize={3}",
                        StringUtils.isEmpty(request.getDatasourceCode()) ? "" : request.getDatasourceCode(),
                        StringUtils.isEmpty(request.getName()) ? "" : request.getName(),
                        request.getPageNo(),
                        request.getPageSize()));
                if (resultJson == null) {
                    return PageResponseDTO.of(request.getPageNo(), request.getPageSize(), 0L, null);
                }
                PageResponseDTO<PulsarTopicResponseDTO> data = JSONUtils.parseObject(resultJson, new TypeReference<PageResponseDTO<PulsarTopicResponseDTO>>() {
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

                    PulsarTenantResponseDTO tenant = namespace.getTenant();
                    if (Objects.nonNull(tenant) && CollectionUtils.isNotEmpty(tenant.getAllowedClusters())) {
                        Optional<PulsarClusterResponseDTO> first = tenant.getAllowedClusters().stream().filter(Objects::nonNull).findFirst();
                        if (first.isPresent()) {
                            PulsarClusterResponseDTO cluster = first.get();
                            datasource.setType(cluster.getType());
                            datasource.setName(cluster.getName());
                            datasource.setCode(cluster.getId());
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
            if (typeJson == null) {
                return null;
            }
            Class clazz = JSONUtils.parseObject(typeJson, new TypeReference<Class>() {
            });
            String className = clazz.fullClassName();

            String body;
            if ("org.starfish.HiveTable".equals(className)) {
                body =
                        "{\"eachPointers\": {\"db\" : {\"relationType\": \"CHILD\", \"category\":\"RELATIONSHIP\", \"eachPointers\": {\"cluster\" : {\"relationType\": \"CHILD\", \"category\":\"RELATIONSHIP\", \"eachPointers\": {} } } }, "
                                + "\"columns\": {\"relationType\": \"CHILD\", \"category\":\"RELATIONSHIP\", \"eachPointers\": {} } }, \"id\": " + code + ", \"typeName\": \"org.starfish.HiveTable\"}";
            } else {
                body =
                        "{\"eachPointers\": {\"namespace\" : {\"relationType\": \"CHILD\", \"category\":\"RELATIONSHIP\", \"eachPointers\": {\"tenant\" : {\"relationType\": \"CHILD\", \"category\":\"RELATIONSHIP\", \"eachPointers\": {\"allowedClusters\" : "
                                + "{\"relationType\": \"CHILD\", \"category\":\"RELATIONSHIP\", \"eachPointers\": { } } } } } }, \"schemas\": {\"relationType\": \"CHILD\", \"category\":\"RELATIONSHIP\", \"eachPointers\": {} } }, \"id\": "
                                + code + " , \"typeName\": \"org.starfish.PulsarTopic\"}";
            }

            Object instanceJson = post("/entity/queryByIdAndTypeNameAndCondition", body);
            if (Objects.isNull(instanceJson)) {
                return null;
            }
            List<MetaSchemaEntity> schemas = new ArrayList<>();
            MetaDatasetEntity dataset = new MetaDatasetEntity();
            MetaDatabaseEntity database = new MetaDatabaseEntity();
            MetaDatasourceEntity datasource = new MetaDatasourceEntity();
            switch (className) {
                case "org.starfish.HiveTable":
                    HiveTableResponseDTO table = JSONUtils.parseObject(instanceJson, new TypeReference<HiveTableResponseDTO>() {
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

                    List<HiveColumnResponseDTO> columns = CollectionUtils.isNotEmpty(table.getColumns()) ? table.getColumns() : Collections.emptyList();
                    columns.addAll(CollectionUtils.isNotEmpty(table.getPartitionKeys()) ? table.getPartitionKeys() : Collections.emptyList());
                    columns.stream().forEach(column -> {
                        MetaSchemaEntity schema = new MetaSchemaEntity();
                        schema.setName(column.getName());
                        schema.setCode(String.valueOf(column.getId()));
                        schemas.add(schema);
                    });

                    break;

                case "org.starfish.PulsarTopic":
                    PulsarTopicResponseDTO topic = JSONUtils.parseObject(instanceJson, new TypeReference<PulsarTopicResponseDTO>() {
                    });
                    dataset.setCode(String.valueOf(topic.getId()));
                    dataset.setName(topic.getName());

                    PulsarNamespaceResponseDTO namespace = topic.getNamespace();
                    database.setCode(String.valueOf(namespace.getId()));
                    database.setName(namespace.getName());

                    PulsarTenantResponseDTO tenant = namespace.getTenant();
                    if (Objects.nonNull(tenant) && CollectionUtils.isNotEmpty(tenant.getAllowedClusters())) {
                        Optional<PulsarClusterResponseDTO> optional = tenant.getAllowedClusters().stream().filter(Objects::nonNull).findFirst();
                        if (optional.isPresent()) {
                            PulsarClusterResponseDTO pulsarCluster = optional.get();
                            datasource.setType(pulsarCluster.getType());
                            datasource.setName(pulsarCluster.getName());
                            datasource.setCode(pulsarCluster.getId());
                        }
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
            ResultEntity<Object> resultEntity = JSONUtils.parseObject(response.body().string(), new TypeReference<ResultEntity<Object>>() {
            });
            if (resultEntity.isFailed()) {
                LOGGER.error("url:{}; message:{}", url, resultEntity.getMessage());
                return null;
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
            ResultEntity<Object> resultEntity = JSONUtils.parseObject(response.body().string(), new TypeReference<ResultEntity<Object>>() {
            });
            if (resultEntity.isFailed()) {
                LOGGER.error("url:{}; message:{}", url, resultEntity.getMessage());
                return null;
            }
            return resultEntity.getData();
        }

    }
}
