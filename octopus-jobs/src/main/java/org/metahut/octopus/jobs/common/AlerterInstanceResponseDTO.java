package org.metahut.octopus.jobs.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;
import java.util.Date;

@ApiModel(description = "alerter instance response dto")
public class AlerterInstanceResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "alerter source response dto")
    private AlerterSourceResponseDTO source;

    @ApiModelProperty(value = "parameter")
    private String parameter;

    @ApiModelProperty(value = "creator")
    private Long creator;

    @ApiModelProperty(value = "operator")
    private Long operator;

    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "createTime")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "updateTime")
    private Date updateTime;

    @Deprecated
    @ApiModelProperty(value = "users")
    private Collection<UserResponseDTO> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlerterSourceResponseDTO getSource() {
        return source;
    }

    public void setSource(AlerterSourceResponseDTO source) {
        this.source = source;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
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

    @Deprecated
    public Collection<UserResponseDTO> getUsers() {
        return users;
    }

    @Deprecated
    public void setUsers(Collection<UserResponseDTO> users) {
        this.users = users;
    }
}
