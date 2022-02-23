package org.metahut.octopus.message.pulsar;

import org.metahut.octopus.message.api.MessageProducer;

import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClientException;

import java.io.IOException;
import java.util.Objects;

public class PulsarMessageProducer implements MessageProducer {

    private final Producer producer;

    public PulsarMessageProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void send(String key, String value) {
        try {
            MessageId send = producer.newMessage()
                    .key(key)
                    .value(value.getBytes())
                    .send();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        if (Objects.nonNull(producer)) {
            producer.close();
        }

    }
}
