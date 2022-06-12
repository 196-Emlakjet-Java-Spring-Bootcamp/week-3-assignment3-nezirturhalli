package com.example.rabbitmq.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleAdvertisementRequest {
    private UserRequest userRequest;
    private String title;
    private String photo;
    private String detailMessage;
    private String priceGraphPath;

}
