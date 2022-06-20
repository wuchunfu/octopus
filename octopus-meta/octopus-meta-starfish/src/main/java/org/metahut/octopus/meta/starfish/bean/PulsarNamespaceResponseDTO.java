package org.metahut.octopus.meta.starfish.bean;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class PulsarNamespaceResponseDTO {

    private Long id;

    private String name;

    private PulsarTenantResponseDTO tenant;

    private Integer messageTTL;

    private List<PulsarTopicResponseDTO> topics;

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

    public PulsarTenantResponseDTO getTenant() {
        return tenant;
    }

    public void setTenant(PulsarTenantResponseDTO tenant) {
        this.tenant = tenant;
    }

    public Integer getMessageTTL() {
        return messageTTL;
    }

    public void setMessageTTL(Integer messageTTL) {
        this.messageTTL = messageTTL;
    }

    public List<PulsarTopicResponseDTO> getTopics() {
        return topics;
    }

    public void setTopics(List<PulsarTopicResponseDTO> topics) {
        this.topics = topics;
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
}
