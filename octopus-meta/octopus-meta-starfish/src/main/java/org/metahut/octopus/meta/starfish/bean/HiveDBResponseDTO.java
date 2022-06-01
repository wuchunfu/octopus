package org.metahut.octopus.meta.starfish.bean;

import java.util.Date;
import java.util.Map;

/**
 *
 */
public class HiveDBResponseDTO {

    private Long id;

    private String name;

    private String description;

    private String owner;

    private String location;

    private Map parameters;

    private HiveClusterResponseDTO cluster;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map getParameters() {
        return parameters;
    }

    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }

    public HiveClusterResponseDTO getCluster() {
        return cluster;
    }

    public void setCluster(HiveClusterResponseDTO cluster) {
        this.cluster = cluster;
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
