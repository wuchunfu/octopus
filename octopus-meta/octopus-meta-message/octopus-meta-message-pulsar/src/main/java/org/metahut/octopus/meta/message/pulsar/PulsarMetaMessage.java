package org.metahut.octopus.meta.message.pulsar;

import org.apache.pulsar.client.api.AuthenticationFactory;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.metahut.octupus.meta.message.api.MetaMessage;

public class PulsarMetaMessage implements MetaMessage {

    private PulsarClient client;

    public PulsarMetaMessage() {

        try {
            PulsarClient.builder()
                    .authentication(AuthenticationFactory.token("pulsarProperties.getTdcToken()"))
                    .serviceUrl("pulsarProperties.getServiceurl()")
                    .build();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }

    public Producer newProducer() {

    }
}
