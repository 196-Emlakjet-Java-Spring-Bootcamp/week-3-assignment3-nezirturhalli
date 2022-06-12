package com.example.rabbitmq.service.impl;

import com.example.rabbitmq.entity.SaleAdvertisement;
import com.example.rabbitmq.repository.SaleAdvertisementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaleAdvertisementConsumerServiceImpl {
    private final SaleAdvertisementRepository saleAdvertisementRepository;

    @RabbitListener(queues = {"${sample.rabbitmq.queue}"})
    public void listenProducer(@Payload SaleAdvertisement saleAdvertisement) throws
            InterruptedException {
        Thread.sleep(3L * 1000);
        saleAdvertisement.setPriceGraphPath("Created by Worker");
        saleAdvertisementRepository.save(saleAdvertisement);

    }

}
