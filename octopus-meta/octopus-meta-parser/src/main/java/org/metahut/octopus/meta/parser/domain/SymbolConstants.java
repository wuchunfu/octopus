package org.metahut.octopus.meta.parser.domain;

import org.metahut.octopus.meta.parser.function.ClassGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author XuYang
 * Create at 2022/2/23
 * @description
 */
public class SymbolConstants {
    public static final Logger LOG = LoggerFactory.getLogger(ClassGenerator.class);

    public static final String PREFIX = "v";

    public static final String LIST_IMPORT = "import java.util.List;\n";

    public static final String PACKAGE_SPLIT = ".";

    public static final String LINE_TAIL = ";\n";

    public static final String INDENT = "\t\t";

    public static final String IMPORT = "import ";
}
