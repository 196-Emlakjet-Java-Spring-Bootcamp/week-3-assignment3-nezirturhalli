package com.example.rabbitmq.service.impl;

import com.example.rabbitmq.dto.request.SaleAdvertisementRequest;
import com.example.rabbitmq.dto.response.SaleAdvertisementResponse;
import com.example.rabbitmq.entity.SaleAdvertisement;
import com.example.rabbitmq.repository.SaleAdvertisementRepository;
import com.example.rabbitmq.service.SaleAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SaleAdvertisementProducerServiceImpl implements SaleAdvertisementService {

    private final SaleAdvertisementRepository saleAdvertisementRepository;
    private final ModelMapper modelMapper;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Override
    public SaleAdvertisementResponse createSaleAdvertisement(SaleAdvertisementRequest saleAdvertisementRequest) {
        var newSaleAdvertisement = modelMapper.map(saleAdvertisementRequest, SaleAdvertisement.class);
        var advToRabbit = saleAdvertisementRepository.save(newSaleAdvertisement);
        //send rabbitmq queue(producer)
        rabbitTemplate.convertAndSend(queue.getName(), newSaleAdvertisement);
        return modelMapper.map(advToRabbit, SaleAdvertisementResponse.class);
    }

    @Override
    public List<SaleAdvertisementResponse> findAllSaleAdvertisements() {
        return saleAdvertisementRepository.findAll().stream()
                .map(saleAdvertisement -> modelMapper.map(saleAdvertisement, SaleAdvertisementResponse.class))
                .toList();
    }
}
