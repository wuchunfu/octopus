package org.metahut.octopus.meta.parser.core.v1;

import org.metahut.octopus.meta.parser.domain.compile.AbstractStructModel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 */
public class ClassParserHandler {

    /**
     * 按照环境进行类加载
     * @param env
     * @param structModels
     */
    public void load(final String env,List<AbstractStructModel> structModels) {
        structModels
                .stream()
                .filter(abstractStructModel -> abstractStructModel != null)
                .collect(Collectors.toMap(
                        structModel -> String.join(".",structModel.getPackagePath(),structModel.getName()),
                        Function.identity(),
                        (key1,key2)->key2)
                );

    }
}
