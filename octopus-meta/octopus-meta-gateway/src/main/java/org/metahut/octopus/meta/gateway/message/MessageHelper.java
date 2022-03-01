package org.metahut.octopus.meta.gateway.message;

import org.metahut.octopus.message.api.MessageConsumer;
import org.metahut.octopus.message.api.MessageManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.io.IOException;

@Component
public class MessageHelper {

    private static final Logger logger = LoggerFactory.getLogger(MessageHelper.class);

    private final MessageManager messageManager;

    public MessageHelper(MessageManager messageManager) {
        this.messageManager = messageManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }

    @PostConstruct
    private void autoConsumer() {
        autoMetaEventConsumer();
    }

    @Async
    public void autoMetaEventConsumer() {
        MessageConsumer consumer = messageManager.getConsumer("");
        while (true) {
            try {
                String receive = consumer.receive();

                // TODO Store to metadata

            } catch (Exception e) {
                // TODO How to consume or handle exceptions
                logger.error(e.getMessage(), e);
            }
        }
    }

    public void close() throws IOException {
        messageManager.close();
    }
}
