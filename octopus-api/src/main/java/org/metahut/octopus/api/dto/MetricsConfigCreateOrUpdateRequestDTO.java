package org.metahut.octopus.api.dto;

import org.metahut.octopus.common.enums.CreateTypeEnum;
import org.metahut.octopus.common.enums.SubjectCategoryEnum;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;

@ApiModel(description = "metrics config create or update request dto")
public class MetricsConfigCreateOrUpdateRequestDTO {

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

    @Deprecated
    public static class JSONUtils {

        private static final Logger logger = LoggerFactory.getLogger(JSONUtils.class);

        private JSONUtils() {
        }

        private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
                .configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
                .configure(READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

        public static <T> T parseObject(String json, Class<T> clazz) {
            if (StringUtils.isEmpty(json) || Objects.isNull(clazz)) {
                return null;
            }

            try {
                return OBJECT_MAPPER.readValue(json, clazz);
            } catch (Exception e) {
                logger.error("JSON parse Object exception, JSON:{}, Class:{}", json, clazz, e);
                return null;
            }
        }

        public static <T> T parseObject(String json, TypeReference<T> type) {
            if (StringUtils.isEmpty(json) || Objects.isNull(type)) {
                return null;
            }

            try {
                return OBJECT_MAPPER.readValue(json, type);
            } catch (Exception e) {
                logger.error("JSON parse Object exception, JSON:{}, TypeReference:{}", json, type, e);
                return null;
            }
        }

        public static String toJSONString(Object object) {
            try {
                return OBJECT_MAPPER.writeValueAsString(object);
            } catch (Exception e) {
                throw new RuntimeException("Object json deserialization exception.", e);
            }
        }

    }
}
