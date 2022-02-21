package org.metahut.octopus.meta.message.api;

import java.io.Closeable;

public interface MetaMessageProducer extends Closeable {

   void send(String key, String value);
}
