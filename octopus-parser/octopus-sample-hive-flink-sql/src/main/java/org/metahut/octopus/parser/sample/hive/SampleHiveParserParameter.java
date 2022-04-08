package org.metahut.octopus.parser.sample.hive;

import org.metahut.octopus.parser.api.AbstractParameter;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "method", visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = BlockSampleHiveParserParameter.class, name = "Block")})
public class SampleHiveParserParameter extends AbstractParameter {

    private SampleMethod method;

    @Override
    public void setDefaultValue() {

    }

    @Override
    public boolean checkParameter() {
        return true;
    }

    public SampleMethod getMethod() {
        return method;
    }

    public void setMethod(SampleMethod method) {
        this.method = method;
    }
}
