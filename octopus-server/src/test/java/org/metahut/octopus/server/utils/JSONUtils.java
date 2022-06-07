package org.metahut.octopus.server.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;

public class JSONUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(org.metahut.octopus.scheduler.dolphinscheduler.JSONUtils.class);

    private JSONUtils() {
    }

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

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
            LOGGER.error("JSON parse Object exception, JSON:{}, Class:{}", json, clazz, e);
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
            LOGGER.error("JSON parse Object exception, JSON:{}, TypeReference:{}", json, type, e);
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
