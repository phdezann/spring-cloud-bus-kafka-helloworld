package org.helloworld.app.bus;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface HelloWorldBus {

    String INPUT = "input";

    String OUTPUT = "output";

    @Input(INPUT)
    MessageChannel input();

    @Output(OUTPUT)
    MessageChannel output();

}
