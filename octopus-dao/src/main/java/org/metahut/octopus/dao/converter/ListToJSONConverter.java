package org.metahut.octopus.dao.converter;

import org.metahut.octopus.dao.utils.JSONUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import javax.persistence.AttributeConverter;

import java.util.List;

public class ListToJSONConverter implements AttributeConverter<List<Object>, String> {

    @Override
    public String convertToDatabaseColumn(List<Object> ts) {
        return JSONUtils.toJSONString(ts);
    }

    @Override
    public List<Object> convertToEntityAttribute(String s) {
        return JSONUtils.parseObject(s, new TypeReference<List<Object>>() {
        });
    }
}
