package org.metahut.octopus.meta.message.api;

import java.io.Closeable;

public interface MetaMessageManager extends Closeable {

    MetaMessageProducer getProducer(String name);

    MetaMessageConsumer getConsumer(String name);
}
