package org.helloworld.app.bus;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.extern.slf4j.Slf4j;

@EnableBinding(HelloWorldBus.class)
@Slf4j
public class HelloWorldBusListener {

    @StreamListener(HelloWorldBus.INPUT)
    public void event(Event event) {
        log.info("Received {}", event);
    }

}
