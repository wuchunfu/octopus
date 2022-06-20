package org.metahut.octopus.meta.starfish.bean;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class PulsarTopicResponseDTO {

    private Long id;

    private String name;

    private Long storageSize;

    private Long backlogSize;

    private PulsarNamespaceResponseDTO namespace;

    private List<PulsarSchemaResponseDTO> schemas;

    private List<PulsarPartitionResponseDTO> partitions;

    private List<PulsarPublisherResponseDTO> publishers;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(Long storageSize) {
        this.storageSize = storageSize;
    }

    public Long getBacklogSize() {
        return backlogSize;
    }

    public void setBacklogSize(Long backlogSize) {
        this.backlogSize = backlogSize;
    }

    public PulsarNamespaceResponseDTO getNamespace() {
        return namespace;
    }

    public void setNamespace(PulsarNamespaceResponseDTO namespace) {
        this.namespace = namespace;
    }

    public List<PulsarSchemaResponseDTO> getSchemas() {
        return schemas;
    }

    public void setSchemas(List<PulsarSchemaResponseDTO> schemas) {
        this.schemas = schemas;
    }

    public List<PulsarPartitionResponseDTO> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<PulsarPartitionResponseDTO> partitions) {
        this.partitions = partitions;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<PulsarPublisherResponseDTO> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<PulsarPublisherResponseDTO> publishers) {
        this.publishers = publishers;
    }
}
