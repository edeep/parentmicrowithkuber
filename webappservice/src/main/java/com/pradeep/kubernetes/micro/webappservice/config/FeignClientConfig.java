package com.pradeep.kubernetes.micro.webappservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pradeep.kubernetes.micro.webappservice.exception.CustomFeignErrorDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomFeignErrorDecoder();
    }
}