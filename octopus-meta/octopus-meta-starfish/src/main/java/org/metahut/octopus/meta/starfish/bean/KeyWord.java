package org.metahut.octopus.meta.starfish.bean;

/**
 *
 */
public enum KeyWord {
    /**
     *
     */
    CLASS("_class");

    private String value;

    public String getValue() {
        return value;
    }

    KeyWord(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
