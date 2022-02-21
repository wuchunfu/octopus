package org.metahut.octopus.meta.message.api;

public enum MetaMessageType {

    KAFKA,
    PULSAR,
    NONE;

    private MetaMessageType() {
    }
}
