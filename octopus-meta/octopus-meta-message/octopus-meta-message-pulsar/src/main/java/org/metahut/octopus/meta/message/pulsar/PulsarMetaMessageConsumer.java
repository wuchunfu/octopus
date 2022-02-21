package org.metahut.octopus.meta.message.pulsar;

import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClientException;
import org.metahut.octopus.meta.message.api.MetaMessageConsumer;

import org.apache.pulsar.client.api.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

public class PulsarMetaMessageConsumer implements MetaMessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PulsarMetaMessageConsumer.class);

    private final Consumer consumer;

    public PulsarMetaMessageConsumer(Consumer consumer) {
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
