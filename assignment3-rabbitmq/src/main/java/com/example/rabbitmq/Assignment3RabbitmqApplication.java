package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class Assignment3RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(Assignment3RabbitmqApplication.class, args);
    }

}
