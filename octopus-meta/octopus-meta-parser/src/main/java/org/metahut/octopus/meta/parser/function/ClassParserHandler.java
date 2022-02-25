package org.metahut.octopus.meta.parser.function;

import org.metahut.octopus.meta.parser.domain.model.AbstractStructModel;
import org.metahut.octopus.meta.parser.domain.struct.StructWorker;

import java.util.List;

/**
 *
 */
public class ClassParserHandler {

    private EnvironmentUnit environmentUnit;

    public boolean valid(List<AbstractStructModel> structModels) {

        return true;
    }

    /**
     * 按照环境进行类加载
     * @param env
     * @param structModels
     */
    public void load(String env,List<AbstractStructModel> structModels) {
        final String rewriteEnv = environmentUnit.rewrite(env);
        //1.version
        //2.class
        //3. graph  nodes(contain id)  and links and category

        //id or classFullName
        structModels
                .stream()
                .filter(abstractStructModel -> abstractStructModel != null)
                .map(abstractStructModel -> {
                    String javaResource = ClassGenerator.toClassFile(rewriteEnv, abstractStructModel);
                    StructWorker structWorker = new StructWorker();
                    structWorker.setJavaResource(javaResource);

                    return null;
                })
                ;

    }
}
