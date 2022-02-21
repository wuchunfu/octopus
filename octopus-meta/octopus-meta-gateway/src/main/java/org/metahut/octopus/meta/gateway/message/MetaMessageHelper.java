package org.metahut.octopus.meta.gateway.message;

import org.metahut.octopus.meta.message.api.MetaMessageConsumer;
import org.metahut.octopus.meta.message.api.MetaMessageManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.io.IOException;

@Component
public class MetaMessageHelper {

    private static final Logger logger = LoggerFactory.getLogger(MetaMessageHelper.class);

    private final MetaMessageManager metaMessageManager;

    public MetaMessageHelper(MetaMessageManager metaMessageManager) {
        this.metaMessageManager = metaMessageManager;
    }

    public MetaMessageManager getMetaMessageManager() {
        return metaMessageManager;
    }

    @PostConstruct
    private void autoConsumer() {
        autoMetaEventConsumer();
    }

    @Async
    public void autoMetaEventConsumer() {
        MetaMessageConsumer consumer = metaMessageManager.getConsumer("");
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
        metaMessageManager.close();
    }
}
