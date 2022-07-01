package org.metahut.octopus.dao.converter;

import javax.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class ListToStringConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return attribute == null ? null : String.join(",", attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return dbData == null ? null : Arrays.asList(dbData.split(","));
    }
}