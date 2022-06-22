/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.metahut.octopus.common.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Objects;

import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES;
import static com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS;

public class JSONUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtils.class);

    private JSONUtils() {
    }

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(ALLOW_UNQUOTED_FIELD_NAMES, true)
            .configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
            .configure(READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
            .configure(UNWRAP_SINGLE_VALUE_ARRAYS, true)
            .setDateFormat(new ZhStdDateFormat());

        SimpleModule module = new SimpleModule();
        module.addSerializer(java.util.Date.class, new DateSerializer());
        module.addSerializer(java.sql.Date.class, new SqlDateSerializer());
        OBJECT_MAPPER.registerModule(module);
    }

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

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

    public static <T> T parseObject(Object object, TypeReference<T> type) {
        if (Objects.isNull(object)) {
            return null;
        }

        try {
            return OBJECT_MAPPER.convertValue(object, type);
        } catch (Exception e) {
            LOGGER.error("Object convert exception, Object:{}, TypeReference:{}", object, type, e);
            return null;
        }
    }

    public static <T> T parseObject(InputStream is, TypeReference<T> type) {
        if (Objects.isNull(is)) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(is, type);
        } catch (Exception e) {
            LOGGER.error("InputStream convert exception, InputStream:{}, TypeReference:{}", is, type, e);
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

    private static class DateSerializer extends JsonSerializer<java.util.Date> {
        @Override
        public void serialize(java.util.Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(date);
            gen.writeString(format);
        }
    }

    private static class SqlDateSerializer extends JsonSerializer<java.sql.Date> {
        @Override
        public void serialize(java.sql.Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(date);
            gen.writeString(format);
        }
    }
}
