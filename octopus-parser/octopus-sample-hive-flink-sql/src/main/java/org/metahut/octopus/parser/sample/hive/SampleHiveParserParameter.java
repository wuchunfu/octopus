package org.metahut.octopus.parser.sample.hive;

import org.metahut.octopus.parser.api.AbstractParameter;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "method", visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = BlockSampleHiveParserParameter.class, name = "BLOCK")})
public class SampleHiveParserParameter extends AbstractParameter {

    private SampleMethodEnum method;

    @Override
    public void setDefaultValue() {

    }

    @Override
    public boolean checkParameter() {
        return true;
    }

    public SampleMethodEnum getMethod() {
        return method;
    }

    public void setMethod(SampleMethodEnum method) {
        this.method = method;
    }
}
