package org.metahut.octopus.parser.api;

public class TypeUtils {

    private TypeUtils() {
    }

    private static final String parser_CATEGORY_SAMPLE = "sample";

    private static final String parser_CATEGORY_METRICS = "metrics";

    private static final String parser_CATEGORY_RULE = "rule";

    private static final String TYPE_NONE = "none";

    public static String generateKey(String... args) {
        return String.join("-", args);
    }
}
