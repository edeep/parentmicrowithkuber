package com.pradeep.kubernetes.micro.webappservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pradeep.kubernetes.micro.webappservice.inferfaces.SearchFeignClient;

import reactor.core.publisher.Mono;

@Service
public class SearchService {
	private static final Logger logger = LoggerFactory.getLogger(SearchService.class);

	 private final WebClient webClient;
	 private final SearchFeignClient searchFeignClient;
	 
	 public SearchService(WebClient webClient, SearchFeignClient searchFeignClient) {
		 this.webClient = webClient;
		 this.searchFeignClient = searchFeignClient;
	 }
	 
	 public Mono<String> getMessageFromDB() {
		 logger.debug("Inside SearchService getMessageFromDB");
	        return webClient.get()
	                .uri("/searchservice/check2") // endpoint of the other microservice
	                .retrieve()
	                .bodyToMono(String.class);
	    }
	 
	 public String getStatusUsingFeignClient() {
		 logger.debug("Inside SearchService getStatusUsingFeignClient");
			return searchFeignClient.getStatus() ;
		}
}
