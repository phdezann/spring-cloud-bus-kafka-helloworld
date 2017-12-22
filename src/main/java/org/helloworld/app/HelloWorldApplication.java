package org.helloworld.app;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class HelloWorldApplication {

    public static void main(String... args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}
