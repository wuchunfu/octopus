package org.metahut.octopus.meta.parser.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URI;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 
 */
public class ClassUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ClassUtils.class);
    private static final String SPECIAL_PACKAGE_NAME = "java.lang";

    private static final Set<String> filteredClassNameOrPackage = new HashSet<>();

    static {
        filteredClassNameOrPackage.addAll(Arrays.asList(
                "boolean",
                "byte",
                "short",
                "char",
                "int",
                "long",
                "float",
                "double",
                "boolean[]",
                "byte[]",
                "short[]",
                "char[]",
                "int[]",
                "long[]",
                "float[]",
                "double[]"
        ));
        getLangClassSet(filteredClassNameOrPackage,SPECIAL_PACKAGE_NAME);

    }

    private static void getLangClassSet(Set<String> classSet, String packageName) {
        try {
            String path = Object.class.getResource("Object.class").getPath().replace("!/java/lang/Object.class", "");
            ZipFile z = new ZipFile(new File(new URI(path)));
            Enumeration<? extends ZipEntry> e = z.entries();
            while (e.hasMoreElements()) {
                String n = e.nextElement().getName();
                if (n.matches("java/lang/\\w+\\.class")) {
                    String fullName = n.substring(0,n.lastIndexOf(".")).replaceAll("/",".");
                    classSet.add(fullName);
                    classSet.add(fullName.substring(fullName.lastIndexOf(".")+1));
                }
            }
        } catch (Exception e) {
            LOG.error("Could not find class",e);
        }

    }

    public static final boolean isBasicClassType (String className) {
        return filteredClassNameOrPackage.contains(className.replaceAll(" ",""));
    }
}
