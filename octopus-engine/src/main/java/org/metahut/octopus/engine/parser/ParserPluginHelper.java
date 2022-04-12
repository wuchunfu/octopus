package org.metahut.octopus.engine.parser;

import org.metahut.octopus.dao.entity.MetricsInstance;
import org.metahut.octopus.dao.entity.MetricsSample;
import org.metahut.octopus.parser.api.IParser;
import org.metahut.octopus.parser.api.IParserManager;
import org.metahut.octopus.parser.api.ParserNode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

import static org.metahut.octopus.parser.api.TypeUtils.generateKey;

@Component
public class ParserPluginHelper {

    public ParserNode generateParser(MetricsSample sample) {
        String category = "sample";
        String type = Objects.isNull(sample) ? generateKey(category, "none") : generateKey(category, "sample.getSourceCategory()", "flink", "sql");
        return ParserNode.builder()
                .type(type)
                .category(category)
                .params(sample.getParams())
                .build();
    }

    public ParserNode generateParser(MetricsInstance metrics) {
        return null;
    }


    private static final Map<String, IParserManager> parserMap = new HashMap<>();

    @PostConstruct
    public void init() {
        ServiceLoader.load(IParserManager.class).forEach(manager -> {

            String type = manager.getType();

            IParserManager parserManager = parserMap.get(type);

            if (Objects.nonNull(parserManager)) {
                throw new IllegalArgumentException(MessageFormat.format("Duplicate parser type exists: {0}", type));
            }

            parserMap.put(type, manager);

        });
    }

    public IParserManager getparser(String type) {
        return parserMap.get(type);
    }

    public IParser generateInstance(String type, String parameter) {
        IParserManager parser = getparser(type);
        if (Objects.isNull(parser)) {
            throw new IllegalArgumentException(MessageFormat.format("parser type is not exists: {0}", type));
        }
        return parser.generateInstance(parameter);
    }

}
