package org.metahut.octopus.meta.parser.core.function;

import org.codehaus.commons.compiler.CompilerFactoryFactory;
import org.codehaus.commons.compiler.ICompiler;
import org.codehaus.commons.compiler.util.resource.MapResourceCreator;
import org.codehaus.commons.compiler.util.resource.Resource;
import org.codehaus.commons.compiler.util.resource.StringResource;
import org.metahut.octopus.meta.parser.domain.compile.AbstractStructModel;
import org.metahut.octopus.meta.parser.domain.compile.ClassModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * import constant pool
 */
public class ClassGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(ClassGenerator.class);

    public static final void load(String classInfo) throws Exception {
        ICompiler compiler = CompilerFactoryFactory.getDefaultCompilerFactory(ClassGenerator.class.getClassLoader()).newCompiler();

        // Store generated .class files in a Map:
        Map<String, byte[]> classes = new HashMap<String, byte[]>();
        compiler.setClassFileCreator(new MapResourceCreator(classes));

        // Now compile two units from strings:
        compiler.compile(new Resource[]{
                new StringResource(
                        "octopus/model/HiveModel.java",
                        "package octopus.model;\n"
                                + "import octopus.attribute.HiveAttribute;\n"
                                + "public class HiveModel {\n"
                                + "\t\tprivate HiveAttribute hiveAttribute;\n"
                                + "\t\tpublic void setHiveAttribute(HiveAttribute hiveAttribute) {\n"
                                + "\t\t\t\tthis.hiveAttribute = hiveAttribute;\n"
                                + "\t\t}\n"
                                + "\t\tpublic HiveAttribute getHiveAttribute(){\n"
                                + "\t\t\t\treturn this.hiveAttribute;\n"
                                + "\t\t}\n"
                                + "}\n"
                ),
                new StringResource(
                        "octopus/attribute/HiveAttribute.java",
                        "package octopus.attribute;\n"
                                + "public class HiveAttribute {"
                                + "\t\tprivate String tableName;\n"
                                + "\t\tpublic void setTableName(String tableName) {\n"
                                + "\t\t\t\tthis.tableName = tableName;\n"
                                + "\t\t}\n"
                                + "\t\tpublic String getTableName(){\n"
                                + "\t\t\t\treturn this.tableName;\n"
                                + "\t\t}\n"
                                + "}\n"
                ),
        });
    }

    public static final String toClassFile(String env, AbstractStructModel model) {
        if (model instanceof ClassModel) {
            ClassModel classModel = (ClassModel)model;
            LineStringBuilder packageBuilder = new LineStringBuilder();
            packageBuilder.appendLine("package ",env,".",model.getPackagePath(),";\n");
            LineStringBuilder importBuilder = new LineStringBuilder();
            LineStringBuilder classNameBuilder = new LineStringBuilder()
                    .appendLine("public class ",classModel.getName() ," {\n");
            LineStringBuilder attributesBuilder = new LineStringBuilder();
            Set<String> imports = new HashSet<>();
            //attribute -> import how o（n）
            classModel.getAttributeModels()
                    .stream()
                    .filter(attributeModel -> attributeModel != null
                            && attributeModel.getClassName() != null)
                    .forEach(attributeModel -> {
                        int index = attributeModel.getClassName().lastIndexOf(".");
                        if (index == -1) {
                            attributesBuilder.appendLine("\t\t",attributeModel.getClassName()," ",attributeModel.getName(),";\n");
                        } else {
                            String className = attributeModel.getClassName().substring(index + 1);
                            if (imports.add(className)) {
                                importBuilder.appendLine("import ",attributeModel.getClassName(),";\n");
                            }
                            attributesBuilder.appendLine("\t\t",className," ",attributeModel.getName(),";\n");
                        }
                    });
            return new LineStringBuilder()
                    .union(packageBuilder)
                    .union(importBuilder)
                    .union(classNameBuilder)
                    .union(attributesBuilder)
                    .append('}')
                    .toString();
        } else {
            LOG.error("No support Model type[{}]", model.getClass());
        }
        return "";
    }

    //TODO 常量池
}
