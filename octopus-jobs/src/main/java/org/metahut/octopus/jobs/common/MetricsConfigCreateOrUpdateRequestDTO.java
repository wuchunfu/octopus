package org.metahut.octopus.jobs.common;

import org.metahut.octopus.common.utils.JSONUtils;
import org.metahut.octopus.jobs.enums.CreateTypeEnum;
import org.metahut.octopus.jobs.enums.SubjectCategoryEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@ApiModel(description = "metrics config create or update request dto")
public class MetricsConfigCreateOrUpdateRequestDTO {

    public interface Create {
    }

    public interface Update {
    }

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "sourceCategory")
    private String sourceCategory;

    @ApiModelProperty(value = "code")
    private Long code;

    @ApiModelProperty(value = "metricsCode")
    private String metricsCode;

    @ApiModelProperty(value = "createType")
    private CreateTypeEnum createType;

    @ApiModelProperty(value = "metricsParams")
    private String metricsParams;

    @ApiModelProperty(value = "subjectCategory")
    private SubjectCategoryEnum subjectCategory;

    @ApiModelProperty(value = "description")
    private String description;

    @Deprecated
    @ApiModelProperty(value = "executorType")
    private String executorType;

    @Deprecated
    @ApiModelProperty(value = "executorScript")
    private String executorScript;

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
        if (StringUtils.isBlank(metricsParams)) {
            Map<String, Object> map = new HashMap<>();
            map.put(EXECUTOR_TYPE_STR, getExecutorType());
            map.put(EXECUTOR_SCRIPT_STR, getExecutorScript());
            metricsParams = JSONUtils.toJSONString(map);
        }
        return metricsParams;
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

    @Deprecated
    public static final String EXECUTOR_TYPE_STR = "executorType";

    @Deprecated
    public static final String EXECUTOR_SCRIPT_STR = "executorScript";
}
