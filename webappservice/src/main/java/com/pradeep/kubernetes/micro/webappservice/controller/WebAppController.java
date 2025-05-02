package com.pradeep.kubernetes.micro.webappservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.kubernetes.micro.webappservice.service.SearchService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webappservice")
public class WebAppController {

	private final SearchService searchService;

	public WebAppController(SearchService searchService) {
	        this.searchService = searchService;
	    }
	        
	@GetMapping("/check")
	public String getStatus() {
		return "Controller is up" ;
	}
	
	@GetMapping("/check2")
	public String getStatus2() {
		return searchService.getStatusUsingFeignClient();
	}
	
	@GetMapping("/check3")
	public Mono<String> getMessageFromDB() {
		return searchService.getMessageFromDB();
	}
}
