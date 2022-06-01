package org.metahut.octopus.meta.starfish.bean;


import java.util.Date;
import java.util.List;

/**
 *
 */
public class HiveTableResponseDTO {

    private Long id;

    private String name;

    private String description;

    private String owner;

    private String lastAccessTime;

    private List<String> partitionKeys;

    private String tableType;

    private Date createTime;

    private Date updateTime;

    private HiveDBResponseDTO db;

    private List<HiveColumnResponseDTO> columns;

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

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public List<String> getPartitionKeys() {
        return partitionKeys;
    }

    public void setPartitionKeys(List<String> partitionKeys) {
        this.partitionKeys = partitionKeys;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
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

    public HiveDBResponseDTO getDb() {
        return db;
    }

    public void setDb(HiveDBResponseDTO db) {
        this.db = db;
    }

    public void setColumns(List<HiveColumnResponseDTO> columns) {
        this.columns = columns;
    }

    public List<HiveColumnResponseDTO> getColumns() {
        return columns;
    }
}
