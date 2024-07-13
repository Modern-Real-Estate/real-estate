package com.loinguyen1905.realestate.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configurable
@Configuration
public class ModelMapperConfig {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}