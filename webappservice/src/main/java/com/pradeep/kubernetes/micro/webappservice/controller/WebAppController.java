package com.pradeep.kubernetes.micro.webappservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.kubernetes.micro.webappservice.service.SearchService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webappservice")
public class WebAppController {
	private static final Logger logger = LoggerFactory.getLogger(WebAppController.class);

	private final SearchService searchService;

	public WebAppController(SearchService searchService) {
	        this.searchService = searchService;
	    }
	        
	@GetMapping("/check")
	public String getStatus() {
		logger.debug("Inside check getStatus");
		return "Controller is up" ;
	}
	
	@GetMapping("/check2")
	public String getStatus2() {
		logger.debug("Inside check2 getStatus2");
		return searchService.getStatusUsingFeignClient();
	}
	
	@GetMapping("/check3")
	public Mono<String> getMessageFromDB() {
		logger.debug("Inside check3 getMessageFromDB");
		return searchService.getMessageFromDB();
	}
	
	
}
