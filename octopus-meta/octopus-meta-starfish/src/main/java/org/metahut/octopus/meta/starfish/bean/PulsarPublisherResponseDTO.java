package org.metahut.octopus.meta.starfish.bean;

import java.util.Date;

/**
 *
 */
public class PulsarPublisherResponseDTO {

    private Long id;

    private String accessMode;

    private Double msgRateIn;

    private Double msgThroughputIn;

    private Double averageMsgSize;

    private Double chunkedMessageRate;

    private Long producerId;

    private String producerName;

    private String address;

    private String connectedSince;

    private String clientVersion;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessMode() {
        return accessMode;
    }

    public void setAccessMode(String accessMode) {
        this.accessMode = accessMode;
    }

    public Double getMsgRateIn() {
        return msgRateIn;
    }

    public void setMsgRateIn(Double msgRateIn) {
        this.msgRateIn = msgRateIn;
    }

    public Double getMsgThroughputIn() {
        return msgThroughputIn;
    }

    public void setMsgThroughputIn(Double msgThroughputIn) {
        this.msgThroughputIn = msgThroughputIn;
    }

    public Double getAverageMsgSize() {
        return averageMsgSize;
    }

    public void setAverageMsgSize(Double averageMsgSize) {
        this.averageMsgSize = averageMsgSize;
    }

    public Double getChunkedMessageRate() {
        return chunkedMessageRate;
    }

    public void setChunkedMessageRate(Double chunkedMessageRate) {
        this.chunkedMessageRate = chunkedMessageRate;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConnectedSince() {
        return connectedSince;
    }

    public void setConnectedSince(String connectedSince) {
        this.connectedSince = connectedSince;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
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
