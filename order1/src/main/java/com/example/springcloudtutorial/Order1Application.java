package com.example.springcloudtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Order1Application {

    @PostMapping("/order/create/{userId}")
    public String create(@PathVariable("userId") String userId) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return "userId: " + userId + " create an order! server: order1";
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable("id") String id) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(600);
        return "order: " + id + " server: order1";
    }

    @Autowired
    private Environment env;

    @GetMapping("getConfig")
    public Object getConfig() {
        return "getConfig: " + env.getProperty("site.name") + " " + env.getProperty("spring.application.name");
    }

    public static void main(String[] args) {
        SpringApplication.run(Order1Application.class, args);
    }
}
