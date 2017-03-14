package com.manjesh.microservices.lb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/14/2017.
 */
@SpringBootApplication
public class GeolocationZkLoadBalancer {
    public static void main(String[] args) {
        SpringApplication.run(GeolocationZkLoadBalancer.class, args);
    }
}
