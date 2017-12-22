package org.helloworld.app.api;

import javax.inject.Inject;

import org.helloworld.app.bus.HelloWorldBusProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldApi {

    @Inject
    private HelloWorldBusProducer helloWorldBusProducer;

    @GetMapping("/hello")
    public void sayHelloWorld() {
        helloWorldBusProducer.sendEvent();
    }

}
