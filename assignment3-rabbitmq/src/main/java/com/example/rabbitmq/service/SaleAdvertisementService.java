package com.example.rabbitmq.service;

import com.example.rabbitmq.dto.request.SaleAdvertisementRequest;
import com.example.rabbitmq.dto.response.SaleAdvertisementResponse;

import java.util.List;

public interface SaleAdvertisementService {

    SaleAdvertisementResponse createSaleAdvertisement(SaleAdvertisementRequest saleAdvertisementRequest );
    List<SaleAdvertisementResponse> findAllSaleAdvertisements();
}
