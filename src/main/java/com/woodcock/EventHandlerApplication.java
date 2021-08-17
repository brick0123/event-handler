package com.woodcock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventHandlerApplication.class, args);
    }

}
