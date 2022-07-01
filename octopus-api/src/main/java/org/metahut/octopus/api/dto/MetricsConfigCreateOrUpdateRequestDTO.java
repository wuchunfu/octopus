package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.CreateTypeEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;
import org.metahut.octopus.common.utils.JSONUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.HashMap;
import java.util.Map;

@ApiModel(description = "metrics config create or update request dto")
public class MetricsConfigCreateOrUpdateRequestDTO {

    public interface Create {
    }

    public interface Update {
    }

    @ApiModelProperty(value = "id")
    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    private Integer id;

    @ApiModelProperty(value = "sourceCategory")
    @NotEmpty(message = "{parameter.not.null}")
    private String sourceCategory;

    @ApiModelProperty(value = "code")
    @NotNull(message = "{parameter.not.null}", groups = Update.class)
    private Long code;

    @ApiModelProperty(value = "metricsCode")
    @NotEmpty(message = "{parameter.not.null}")
    private String metricsCode;

    @ApiModelProperty(value = "createType")
    private CreateTypeEnum createType;

    @ApiModelProperty(value = "metricsParams")
    //@NotEmpty(message = "{parameter.not.null}")
    private String metricsParams;

    @ApiModelProperty(value = "subjectCategory")
    @NotNull(message = "{parameter.not.null}")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "description")
    private String description;

    @Deprecated
    @ApiModelProperty(value = "executorType")
    private String executorType;

    @Deprecated
    @ApiModelProperty(value = "executorScript")
    private String executorScript;

    @ApiModelProperty(value = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceCategory() {
        return sourceCategory;
    }

    public void setSourceCategory(String sourceCategory) {
        this.sourceCategory = sourceCategory;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMetricsCode() {
        return metricsCode;
    }

    public void setMetricsCode(String metricsCode) {
        this.metricsCode = metricsCode;
    }

    public CreateTypeEnum getCreateType() {
        return createType;
    }

    public void setCreateType(CreateTypeEnum createType) {
        this.createType = createType;
    }

    public String getMetricsParams() {
        Map<String, Object> map = new HashMap<>();
        map.put(EXECUTOR_TYPE_STR, getExecutorType());
        map.put(EXECUTOR_SCRIPT_STR, getExecutorScript());
        return JSONUtils.toJSONString(map);
    }

    public void setMetricsParams(String metricsParams) {
        this.metricsParams = metricsParams;
    }

    public SubjectCategoryEnum getSubjectCategory() {
        return subjectCategory;
    }

    public void setSubjectCategory(SubjectCategoryEnum subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Deprecated
    public String getExecutorType() {
        return executorType;
    }

    @Deprecated
    public void setExecutorType(String executorType) {
        this.executorType = executorType;
    }

    @Deprecated
    public String getExecutorScript() {
        return executorScript;
    }

    @Deprecated
    public void setExecutorScript(String executorScript) {
        this.executorScript = executorScript;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Deprecated
    public static final String EXECUTOR_TYPE_STR = "executorType";

    @Deprecated
    public static final String EXECUTOR_SCRIPT_STR = "executorScript";
}
