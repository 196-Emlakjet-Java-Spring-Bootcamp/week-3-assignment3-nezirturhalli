package com.example.rabbitmq.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoModelMapperConfig {


    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
