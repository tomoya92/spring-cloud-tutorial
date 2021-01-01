package com.example.springcloudtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Order2Application {

    @PostMapping("/order/create")
    public String create(String userId) {
        return "userId: " + userId + " create an order! server: order2";
    }

    public static void main(String[] args) {
        SpringApplication.run(Order2Application.class, args);
    }
}
