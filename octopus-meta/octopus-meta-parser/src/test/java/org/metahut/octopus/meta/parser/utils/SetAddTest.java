package org.metahut.octopus.meta.parser.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author XuYang
 * Create at 2022/2/21
 * @description
 */
public class SetAddTest {

    @Test
    public void setAddTest() {
        Set<String> set = new HashSet<>();
        Assertions.assertTrue(set.add("aaa"));
        Assertions.assertFalse(set.add("aaa"));
    }
}
