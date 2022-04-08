package org.metahut.octopus.parser.sample.none;

import org.metahut.octopus.parser.api.IParser;
import org.metahut.octopus.parser.api.IParserManager;

public class SampleNoneParserManager implements IParserManager {

    @Override
    public String getType() {
        return "sample-none";
    }

    @Override
    public IParser generateInstance(String parameter) {
        return null;
    }
}
