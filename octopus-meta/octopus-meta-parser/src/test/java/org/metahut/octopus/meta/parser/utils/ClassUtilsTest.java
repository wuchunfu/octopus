package org.metahut.octopus.meta.parser.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 */
public class ClassUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "Object",
            "java.lang.String",
            "int  [ ] ",
            "String ",
            "CharacterData02"
    })
    public void test(String className) {
        boolean flag = ClassUtils.isBasicClassType(className);
        Assertions.assertTrue(flag);
    }

}
