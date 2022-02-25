package org.metahut.octopus.message.api;

import java.io.Closeable;

public interface MessageProducer extends Closeable {

   void send(String key, String value);
}
