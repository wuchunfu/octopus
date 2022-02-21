package org.metahut.octopus.meta.parser.explore;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.commons.compiler.CompilerFactoryFactory;
import org.codehaus.commons.compiler.ICompiler;
import org.codehaus.commons.compiler.util.ResourceFinderClassLoader;
import org.codehaus.commons.compiler.util.resource.MapResourceCreator;
import org.codehaus.commons.compiler.util.resource.MapResourceFinder;
import org.codehaus.commons.compiler.util.resource.Resource;
import org.codehaus.commons.compiler.util.resource.StringResource;
import org.codehaus.janino.ScriptEvaluator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
<<<<<<< HEAD
 *
=======
 * @author XuYang
 * Create at 2022/2/17
 * @description
>>>>>>> af6836df91ef821e50f66436bb12500fa3469eed
 */
public class JaninoTest {

    /**
     * dynamic compile example from official webpage
     * this example can be the core of frame
     * @throws Exception
     */
    @Test
    public void dynamicCompileTest() throws Exception {
        ICompiler compiler = CompilerFactoryFactory.getDefaultCompilerFactory(this.getClass().getClassLoader()).newCompiler();

        // Store generated .class files in a Map:
        Map<String, byte[]> classes = new HashMap<String, byte[]>();
        compiler.setClassFileCreator(new MapResourceCreator(classes));

        // Now compile two units from strings:
        compiler.compile(new Resource[] {
                new StringResource(
                        "pkg1/A.java",
                        "package pkg1; public class A { public static int meth() { return pkg2.B.meth(); } }"
                ),
                new StringResource(
                        "pkg2/B.java",
                        "package pkg2; public class B { public static int meth() { return 77;            } }"
                ),
        });

        // Set up a class loader that uses the generated classes.
        ClassLoader cl = new ResourceFinderClassLoader(
                new MapResourceFinder(classes),    // resourceFinder
                ClassLoader.getSystemClassLoader() // parent
        );

        Assertions.assertEquals(77, cl.loadClass("pkg1.A").getDeclaredMethod("meth").invoke(null));
    }

    /**
     * Janino as a Script Evaluator example from official webpage
     */
    @Test
    public void janinoAsScriptEvaluatorTest() throws CompileException, InvocationTargetException {
        ScriptEvaluator se = new ScriptEvaluator();
        se.cook(
                ""
                        + "static void method1() {\n"
                        + "    System.out.println(1);\n"
                        + "}\n"
                        + "\n"
                        + "method1();\n"
                        + "method2();\n"
                        + "\n"
                        + "static void method2() {\n"
                        + "    System.out.println(2);\n"
                        + "}\n"
        );
        Object evaluate = se.evaluate(new Object[0]);
        System.out.println(evaluate);
    }
}
