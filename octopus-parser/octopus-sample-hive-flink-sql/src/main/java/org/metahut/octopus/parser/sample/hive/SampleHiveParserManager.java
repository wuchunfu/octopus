package org.metahut.octopus.parser.sample.hive;

import org.metahut.octopus.parser.api.IParser;
import org.metahut.octopus.parser.api.IParserManager;
import org.metahut.octopus.parser.api.ParserException;
import org.metahut.octopus.parser.api.TypeUtils;

import java.util.Objects;

public class SampleHiveParserManager implements IParserManager {

    @Override
    public String getType() {
        return TypeUtils.generateKey("sample", "hive", "flink-sql");
    }

    @Override
    public IParser generateInstance(String parameter) {
        SampleHiveParserParameter sampleHiveParserParameter = JSONUtils.parseObject(parameter, SampleHiveParserParameter.class);

        if (Objects.isNull(sampleHiveParserParameter)) {
            throw new ParserException("Invalid parameters to convert");
        }
        if (!sampleHiveParserParameter.checkParameter()) {
            throw new ParserException("The incoming parameter can not be empty");
        }
        sampleHiveParserParameter.setDefaultValue();

        switch (sampleHiveParserParameter.getMethod()) {
            case Block:
                return new BlockSampleHiveParser(sampleHiveParserParameter);
            default:
                throw new ParserException("");
        }
    }


}
