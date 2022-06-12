package com.example.rabbitmq.controller;

import com.example.rabbitmq.dto.request.SaleAdvertisementRequest;
import com.example.rabbitmq.dto.response.SaleAdvertisementResponse;
import com.example.rabbitmq.service.SaleAdvertisementService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/rabbitmq")

public class SaleAdvertisementRestController {
    private final SaleAdvertisementService saleAdvertisementService ;

    public SaleAdvertisementRestController(SaleAdvertisementService saleAdvertisementService) {
        this.saleAdvertisementService = saleAdvertisementService;
    }

    @PostMapping("/sale-advertisement")
    public String createSaleAdvertisement (@RequestBody SaleAdvertisementRequest saleAdvertisementRequest ){
        saleAdvertisementService.createSaleAdvertisement(saleAdvertisementRequest);
        return "Your request has been received!";
    }

    @GetMapping("/all")
    public List<SaleAdvertisementResponse> findAllSaleAdvertisements(){
        return saleAdvertisementService.findAllSaleAdvertisements();
    }
}
