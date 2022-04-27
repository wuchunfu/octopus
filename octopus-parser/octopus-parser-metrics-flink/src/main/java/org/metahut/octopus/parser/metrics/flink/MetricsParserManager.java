package org.metahut.octopus.parser.metrics.flink;

import org.metahut.octopus.parser.api.IParser;
import org.metahut.octopus.parser.api.IParserManager;

public class MetricsParserManager implements IParserManager {
    @Override
    public String getType() {
        return "metrics-flink";
    }

    @Override
    public IParser generateInstance(String parameter) {
        return null;
    }
}
