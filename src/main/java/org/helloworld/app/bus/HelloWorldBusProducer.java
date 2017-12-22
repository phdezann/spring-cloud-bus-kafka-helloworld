package org.helloworld.app.bus;

import java.util.UUID;

import javax.inject.Inject;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import lombok.extern.slf4j.Slf4j;

@EnableBinding(HelloWorldBus.class)
@Slf4j
public class HelloWorldBusProducer {

    @Inject
    private MessageChannel output;

    public void sendEvent() {
        Event event = new Event(UUID.randomUUID());
        try {
            // this call blocks thanks to:
            // spring.cloud.stream.kafka.bindings.output.producer.sync: true
            output.send(MessageBuilder.withPayload(event).build());
        } catch (Exception ex) {
            log.warn("Got an exception while sending message", ex);
            throw ex; // should we retry instead?
        }
    }

}
