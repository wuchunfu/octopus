package org.metahut.octopus.meta.parser.explore;

import org.codehaus.commons.compiler.CompilerFactoryFactory;
import org.codehaus.commons.compiler.ICompiler;
import org.codehaus.commons.compiler.util.ResourceFinderClassLoader;
import org.codehaus.commons.compiler.util.resource.MapResourceCreator;
import org.codehaus.commons.compiler.util.resource.MapResourceFinder;
import org.codehaus.commons.compiler.util.resource.Resource;
import org.codehaus.commons.compiler.util.resource.StringResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class JaninoExtensionTest {


    /**
     * test lombok (just a guess)
     *
     * @throws Exception
     */
    @Test
    public void dynamicCompileLombokWorkingTest() {
        try {
            ICompiler compiler = CompilerFactoryFactory.getDefaultCompilerFactory(this.getClass().getClassLoader()).newCompiler();

            // Store generated .class files in a Map:
            Map<String, byte[]> classes = new HashMap<String, byte[]>();
            compiler.setClassFileCreator(new MapResourceCreator(classes));

            // Now compile two units from strings:
            compiler.compile(new Resource[]{
                    new StringResource(
                            "octopus/model/HiveModel.java",
                            "package octopus.model;\n"
                                    + "import octopus.attribute.HiveAttribute;\n"
                                    + "import lombok.Data;\n"
                                    + "@Data\n"
                                    + "public class HiveModel { private HiveAttribute hiveAttribute; }"
                    ),
                    new StringResource(
                            "octopus/attribute/HiveAttribute.java",
                            "package octopus.attribute;\n"
                                    + "import lombok.Data;\n"
                                    + "@Data\n"
                                    + "public class HiveAttribute {private String tableName;}"
                    ),
            });

            // Set up a class loader that uses the generated classes.
            ClassLoader cl = new ResourceFinderClassLoader(
                    new MapResourceFinder(classes),    // resourceFinder
                    ClassLoader.getSystemClassLoader() // parent
            );
            Object hiveModel = cl.loadClass("octopus.model.HiveModel").newInstance();
            Object hiveAttribute = cl.loadClass("octopus.attribute.HiveAttribute").newInstance();
            hiveAttribute.getClass().getMethod("setTableName",String.class).invoke(hiveAttribute, "testHiveTableName");
            hiveModel.getClass().getMethod("setHiveAttribute").invoke(hiveModel, hiveAttribute);
            Assertions.fail("octopus.attribute.HiveAttribute.setTableName()");
        } catch (Exception exception) {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(exception.getMessage(),"octopus.attribute.HiveAttribute.setTableName(java.lang.String)"),
                    () -> Assertions.assertNull(exception.getCause())
            );
        }
    }

    /**
     * test init class instance
     *
     * @throws Exception
     */
    @Test
    public void dynamicCompileInitialClassInstanceTest() throws Exception{
        ICompiler compiler = CompilerFactoryFactory.getDefaultCompilerFactory(this.getClass().getClassLoader()).newCompiler();

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

        // Set up a class loader that uses the generated classes.
        ClassLoader cl = new ResourceFinderClassLoader(
                new MapResourceFinder(classes),    // resourceFinder
                ClassLoader.getSystemClassLoader() // parent
        );
        String tableName = "testHiveTableName";
        Object hiveModel = cl.loadClass("octopus.model.HiveModel").newInstance();
        Object hiveAttribute = cl.loadClass("octopus.attribute.HiveAttribute").newInstance();
        hiveAttribute.getClass().getMethod("setTableName",String.class).invoke(hiveAttribute, tableName);
        hiveModel.getClass().getMethod("setHiveAttribute",hiveAttribute.getClass()).invoke(hiveModel, hiveAttribute);
        Object reflectHiveAttribute = hiveModel.getClass().getMethod("getHiveAttribute").invoke(hiveModel);
        Object reflectString = reflectHiveAttribute.getClass().getMethod("getTableName").invoke(reflectHiveAttribute);
        Assertions.assertAll(
                () -> Assertions.assertEquals(hiveAttribute,reflectHiveAttribute),
                () -> Assertions.assertEquals(tableName,reflectString)
        );
    }
}
