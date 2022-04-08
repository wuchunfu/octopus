package org.metahut.octopus.parser.metrics.custom.script;

import org.metahut.octopus.parser.api.IParser;
import org.metahut.octopus.parser.api.IParserManager;
import org.metahut.octopus.parser.api.TypeUtils;

public class MetricsCustomScriptParserManager implements IParserManager {
    @Override
    public String getType() {
        return TypeUtils.generateKey("metrics", "custom-script");
    }

    @Override
    public IParser generateInstance(String parameter) {
        return null;
    }
}
