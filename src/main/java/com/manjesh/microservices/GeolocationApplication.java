package com.manjesh.microservices;

import com.manjesh.microservices.network.Zookeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GeolocationApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(GeolocationApplication.class, args);
        new Zookeeper("192.168.99.100", 2181).register();

    }
}
