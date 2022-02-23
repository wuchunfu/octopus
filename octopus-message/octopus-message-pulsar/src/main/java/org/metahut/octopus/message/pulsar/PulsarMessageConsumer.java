package org.metahut.octopus.message.pulsar;

import org.metahut.octopus.message.api.MessageConsumer;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

public class PulsarMessageConsumer implements MessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PulsarMessageConsumer.class);

    private final Consumer consumer;

    public PulsarMessageConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public String receive() throws Exception {
        // Wait for a message
        Message msg = consumer.receive();
        String data = null;
        try {
            data = new String(msg.getData());
            // Acknowledge the message so that it can be deleted by the message broker
            consumer.acknowledge(msg);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // Message failed to process, redeliver later
            consumer.negativeAcknowledge(msg);
        }
        return data;
    }

    @Override
    public void close() throws IOException {
        if (Objects.nonNull(consumer)) {
            consumer.close();
        }
    }
}
