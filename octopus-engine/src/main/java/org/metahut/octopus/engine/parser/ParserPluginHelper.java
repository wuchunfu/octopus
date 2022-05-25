package org.metahut.octopus.engine.parser;

import org.metahut.octopus.dao.entity.SampleInstance;
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

    public String generateType(String sourceCategory, SampleInstance sample) {
        String category = "sample";
        String executorTypeDefaultValue = "flink";
        return Objects.isNull(sample) ? generateKey(category, "none") : generateKey(category, sourceCategory, executorTypeDefaultValue);
    }

    public ParserNode generateParser(String sourceCategory, SampleInstance sample) {
        String category = "sample";
        String executorTypeDefaultValue = "flink";
        String type = Objects.isNull(sample) ? generateKey(category, "none") : generateKey(category, sourceCategory, executorTypeDefaultValue);
        return ParserNode.builder()
            .type(type)
            .category(category)
            .params(sample.getParameter())
            .build();
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

    public IParserManager getParser(String type) {
        return parserMap.get(type);
    }

    public IParser generateInstance(String type, String parameter) {
        IParserManager parser = getParser(type);
        if (Objects.isNull(parser)) {
            throw new IllegalArgumentException(MessageFormat.format("parser type is not exists: {0}", type));
        }
        return parser.generateInstance(parameter);
    }

}
