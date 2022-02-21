package org.metahut.octopus.meta.message.api;

import java.io.Closeable;

public interface MetaMessageConsumer extends Closeable {

    String receive() throws Exception;
}
