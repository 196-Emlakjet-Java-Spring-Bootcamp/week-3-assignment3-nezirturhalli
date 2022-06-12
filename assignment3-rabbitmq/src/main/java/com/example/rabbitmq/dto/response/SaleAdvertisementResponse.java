package com.example.rabbitmq.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleAdvertisementResponse {
    private String title;
    private String photo;
    private String detailMessage;
    private String priceGraphPath;
}
