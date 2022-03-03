package org.metahut.octopus.meta.parser.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class RandomTest {
    @Test
    public void nextLongTest() {
        Assertions.assertAll(
                () -> Assertions.assertNotNull(ThreadLocalRandom.current().nextLong()),
                () -> Assertions.assertNotEquals(0L,ThreadLocalRandom.current().nextLong())
        );
    }
}
