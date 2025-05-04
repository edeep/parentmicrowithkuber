package com.pradeep.kubernetes.micro.webappservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.kubernetes.micro.webappservice.exception.CustomResourceNotFoundException;
import com.pradeep.kubernetes.micro.webappservice.service.SearchService;

import reactor.core.publisher.Mono;

@RestController
public class WebAppDefaultController {
	private static final Logger logger = LoggerFactory.getLogger(WebAppDefaultController.class);


	private final SearchService searchService;

	public WebAppDefaultController(SearchService searchService) {
	        this.searchService = searchService;
	    }
	
	@GetMapping("/")
	public String defaultControllerMethod() {
		logger.debug("Inside defaultControllerMethod ");
		return "Webservice Controller is up" ;
	}
	
	
	@GetMapping("/simulateErrorUsingWebClient")
	public Mono<ResponseEntity<String>> simulateErrorUsingWebClient() {
		logger.debug("Inside  simulateErrorUsingFeignClient");
		return searchService.getErrorStringFromSearchService().map(ResponseEntity::ok)
		        .onErrorResume(CustomResourceNotFoundException.class, ex ->
	            Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()))
	        );
	}
	
	@GetMapping("/simulateErrorUsingFeignClient")
	public String simulateErrorUsingFeignClient() {
		logger.debug("Inside simulateErrorUsingFeignClient");
		return searchService.simulateErrorUsingFeignClient();
	}
}
