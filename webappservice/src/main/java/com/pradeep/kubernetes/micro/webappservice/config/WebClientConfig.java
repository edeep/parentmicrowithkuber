package com.pradeep.kubernetes.micro.webappservice.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:8033") // Default base URL (optional)
                .build();
    }
    
    /*@Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://search-service:80") // Default base URL (optional)
                .build();
    }*/
}
