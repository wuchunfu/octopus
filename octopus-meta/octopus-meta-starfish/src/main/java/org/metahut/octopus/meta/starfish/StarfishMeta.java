package org.metahut.octopus.meta.starfish;

import org.metahut.octopus.meta.api.IMeta;
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
import org.metahut.octopus.meta.starfish.bean.HiveClusterResponseDTO;
import org.metahut.octopus.meta.starfish.bean.PulsarClusterResponseDTO;
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
            String url = get(MessageFormat.format("/meta/entity/sources?name={0}&pageNo={1}&pageSize={2}",
                    datasourceTypeRequest.getName(),datasourceTypeRequest.getPageNo(),datasourceTypeRequest.getPageSize()));
            String resultJson = get(url);
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
                String url = get(MessageFormat.format("/meta/entity/hiveClusters?clusterName={0}&pageNo={1}&pageSize={2}",
                        metaDatasourceRequest.getName(),
                        metaDatasourceRequest.getPageNo(),
                        metaDatasourceRequest.getPageSize()));
                String resultJson = get(url);
                ResultEntity<PageResponseDTO<HiveClusterResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<HiveClusterResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<HiveClusterResponseDTO> data = resultEntity.getData();
                    return PageResponseDTO.of(data.getPageNo(),data.getPageSize(),data.getTotal(),
                            data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                                MetaDatasourceEntity entity = new MetaDatasourceEntity();
                                entity.setCode(sourceResponseDTO.getId());
                                entity.setName(sourceResponseDTO.getName());
                                return entity;
                            }).collect(Collectors.toList()));
                }
            } else if ("Pulsar".equals(metaDatasourceRequest.getDataSourceType())) {
                String url = get(MessageFormat.format("/meta/entity/pulsarClusters?name={0}&pageNo={1}&pageSize={2}",
                        metaDatasourceRequest.getName(),
                        metaDatasourceRequest.getPageNo(),
                        metaDatasourceRequest.getPageSize()));
                String resultJson = get(url);
                ResultEntity<PageResponseDTO<PulsarClusterResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<PulsarClusterResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<PulsarClusterResponseDTO> data = resultEntity.getData();
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
    public PageResponseDTO<MetaDatasetEntity> queryDatasetListPage(MetaDatasetRequest request) {
        try {
            if ("Hive".equals(request.getDataSourceType())) {
                String url = get(MessageFormat.format("/meta/entity/hiveClusters?hiveClusterId={0}&hiveTableName={2}&pageNo={3}&pageSize={4}",
                        request.getDataSourceCode(),
                        request.getName(),
                        request.getPageNo(),
                        request.getPageSize()));
                String resultJson = get(url);
                ResultEntity<PageResponseDTO<HiveClusterResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<HiveClusterResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<HiveClusterResponseDTO> data = resultEntity.getData();
                    return PageResponseDTO.of(data.getPageNo(),data.getPageSize(),data.getTotal(),
                            data.getData() == null ? null : data.getData().stream().map(sourceResponseDTO -> {
                                MetaDatasourceEntity entity = new MetaDatasourceEntity();
                                entity.setCode(sourceResponseDTO.getId());
                                entity.setName(sourceResponseDTO.getName());
                                return entity;
                            }).collect(Collectors.toList()));
                }
            } else if ("Pulsar".equals(request.getDataSourceType())) {
                String url = get(MessageFormat.format("/meta/entity/pulsarClusters?clusterId={0}&topicName={1}&pageNo={2}&pageSize={3}",
                        request.getDataSourceCode(),
                        request.getName(),
                        request.getPageNo(),
                        request.getPageSize()));
                String resultJson = get(url);
                ResultEntity<PageResponseDTO<PulsarClusterResponseDTO>> resultEntity = new ObjectMapper().readValue(resultJson,
                        new TypeReference<ResultEntity<PageResponseDTO<PulsarClusterResponseDTO>>>() {});
                if (resultEntity.isSuccess()) {
                    PageResponseDTO<PulsarClusterResponseDTO> data = resultEntity.getData();
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
        MetaDatasetEntity metaDatasetEntity1 = new MetaDatasetEntity();
        metaDatasetEntity1.setCode("01");
        metaDatasetEntity1.setName("dwd_im_1");

        MetaDatasourceEntity metaDatasourceEntity1 = new MetaDatasourceEntity();
        metaDatasourceEntity1.setCode("01");
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
