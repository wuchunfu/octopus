package org.metahut.octopus.meta.parser.function;

import org.metahut.octopus.meta.parser.domain.SymbolConstants;
import org.metahut.octopus.meta.parser.domain.model.AbstractStructModel;
import org.metahut.octopus.meta.parser.domain.model.AttributeModel;
import org.metahut.octopus.meta.parser.domain.model.ClassModel;
import org.metahut.octopus.meta.parser.domain.struct.StructWorker;
import org.metahut.octopus.meta.parser.exception.AbstractMetaParserException;
import org.metahut.octopus.meta.parser.exception.DataValidExceptionMeta;
import org.metahut.octopus.meta.parser.exception.ModelValidExceptionMeta;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class ModelParserHandler {

    private EnvironmentUnit environmentUnit;

    private MetaStorage metaStorage;

    public void valid(List<AbstractStructModel> structModels) throws AbstractMetaParserException {
        if (structModels == null || structModels.size() == 0) {
            throw new DataValidExceptionMeta("Non data in ,please check.");
        }
        Set<String> packages = new HashSet<>();
        for (AbstractStructModel structModel : structModels) {
            if (structModel.getPackagePath() == null || !structModel.getPackagePath().matches(SymbolConstants.PACKAGE_REGEX)) {
                throw new ModelValidExceptionMeta();
            }
            if (structModel.getName() == null || !structModel.getName().matches(SymbolConstants.CLASS_NAME_REGEX)) {
                throw new ModelValidExceptionMeta("ClassName not biaozhun");
            }
            if (!packages.add(structModel.getPackagePath())) {
                throw new ModelValidExceptionMeta("Repeat class");
            }
            if (structModel instanceof ClassModel) {
                ClassModel classModel = (ClassModel) structModel;
                if (classModel.getAttributeModels() == null || classModel.getAttributeModels().size() == 0) {
                    throw new ModelValidExceptionMeta();
                }
                for (AttributeModel attributeModel : classModel.getAttributeModels()) {
                    if (attributeModel.getClassName() == null || !attributeModel.getClassName().matches(SymbolConstants.FULL_CLASS_REGEX)) {
                        throw new ModelValidExceptionMeta();
                    }
                }
            }
        }
    }

    /**
     * 按照环境进行类加载
     * @param env
     * @param structModels
     */
    public void loadModels(String env,List<AbstractStructModel> structModels) {
        final String rewriteEnv = environmentUnit.rewrite(env);
        //1.version 没用 class按照类名来的
        //2.class
        //3. graph  nodes(contain id)  and links and category
        //classFullName
        structModels
                .stream()
                .filter(abstractStructModel -> abstractStructModel != null)
                .map(abstractStructModel -> {
                    String javaResource = ModelGenerator.toClassFile(rewriteEnv, abstractStructModel);
                    StructWorker structWorker = new StructWorker();
                    structWorker.setJavaResource(javaResource);

                    return null;
                })
                ;

        metaStorage.put(rewriteEnv,new MetaMap(structModels));
    }

    public void loadInstances(String env,List<?> insances) {

    }
}
