package com.pradeep.kubernetes.micro.webappservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pradeep.kubernetes.micro.webappservice.inferfaces.SearchFeignClient;

import reactor.core.publisher.Mono;

@Service
public class SearchService {

	 private final WebClient webClient;
	 private final SearchFeignClient searchFeignClient;
	 
	 public SearchService(WebClient webClient, SearchFeignClient searchFeignClient) {
		 this.webClient = webClient;
		 this.searchFeignClient = searchFeignClient;
	 }
	 
	 public Mono<String> getMessageFromDB() {
	        return webClient.get()
	                .uri("/searchservice/check2") // endpoint of the other microservice
	                .retrieve()
	                .bodyToMono(String.class);
	    }
	 
	 public String getStatusUsingFeignClient() {
			return searchFeignClient.getStatus() ;
		}
}
