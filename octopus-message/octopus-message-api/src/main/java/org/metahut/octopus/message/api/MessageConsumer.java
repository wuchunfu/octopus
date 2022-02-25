package org.metahut.octopus.message.api;

import java.io.Closeable;

public interface MessageConsumer extends Closeable {

    String receive() throws Exception;
}
