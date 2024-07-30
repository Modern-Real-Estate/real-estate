package com.loinguyen1905.realestate.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.loinguyen1905.realestate.interceptor.ObserverInterceptor;
import com.loinguyen1905.realestate.interceptor.RestTemplateFilter;

@Configuration
@SuppressWarnings("null")
public class ApplicationConfiguration implements WebMvcConfigurer {
    @Value("${realestate.upload-file.base-uri}")
    private String uri;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ObserverInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/storage/**")
                .addResourceLocations(this.uri);
    }

    @Bean
    public RestTemplate restTemplate() {
        final RestTemplate restTemplate = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        restTemplate.setInterceptors(Collections.singletonList(new RestTemplateFilter()));
        return restTemplate;
    }
}