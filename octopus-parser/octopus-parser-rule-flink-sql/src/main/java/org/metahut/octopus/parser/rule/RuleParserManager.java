package org.metahut.octopus.parser.rule;

import org.metahut.octopus.parser.api.IParser;
import org.metahut.octopus.parser.api.IParserManager;

public class RuleParserManager implements IParserManager {
    @Override
    public String getType() {
        return "rule-flink-sql";
    }

    @Override
    public IParser generateInstance(String parameter) {
        return null;
    }
}
