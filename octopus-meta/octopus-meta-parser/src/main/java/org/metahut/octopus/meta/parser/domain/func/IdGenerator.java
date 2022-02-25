package org.metahut.octopus.meta.parser.domain.func;

/**
 *
 */
public interface IdGenerator {

    /**
     * Dea
     * @return
     */
    default String generate() {
        return "V";
    }
}
