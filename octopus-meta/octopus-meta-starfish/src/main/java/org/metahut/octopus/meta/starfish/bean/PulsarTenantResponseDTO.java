package org.metahut.octopus.meta.starfish.bean;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class PulsarTenantResponseDTO {

    private Long id;

    private String name;

    private List<PulsarClusterResponseDTO> allowedClusters;

    private List<PulsarNamespaceResponseDTO> namespaces;

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

    public List<PulsarClusterResponseDTO> getAllowedClusters() {
        return allowedClusters;
    }

    public void setAllowedClusters(List<PulsarClusterResponseDTO> allowedClusters) {
        this.allowedClusters = allowedClusters;
    }

    public List<PulsarNamespaceResponseDTO> getNamespaces() {
        return namespaces;
    }

    public void setNamespaces(List<PulsarNamespaceResponseDTO> namespaces) {
        this.namespaces = namespaces;
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
