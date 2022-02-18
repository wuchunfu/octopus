package org.metahut.octupus.meta.message.api;

public enum MetaMessageType {

    KAFKA,
    PULSAR,
    NONE;

    private MetaMessageType() {
    }
}
