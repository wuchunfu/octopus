package org.metahut.octopus.meta.parser.domain.enums;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * Create at 2022/2/18
 * @description
 */
public class MultiTypeTest {

    @Test
    public void genericsNameTest() {
        Map<String,Object> map = new HashMap<>();
        String name = map.getClass().getName();
        System.out.println(name);
    }

}
