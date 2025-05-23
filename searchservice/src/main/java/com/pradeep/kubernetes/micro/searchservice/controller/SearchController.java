package com.pradeep.kubernetes.micro.searchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.kubernetes.micro.searchservice.exception.ResourceNotFoundException;
import com.pradeep.kubernetes.micro.searchservice.service.KeyValueService;

import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/searchservice")
public class SearchController {

	@Autowired
	private KeyValueService keyValueService;
	
	@Value(value = "${simulate.error.value}")
	private String errorStringValue;
	
	
	@GetMapping("/check")
	public String getStatus() {
		//this is called using Feign client
			return "Search Service Controller is up";	
		
	}
	
	@GetMapping("/check2")
	public Mono<String> getValueForKey(String key) {
		
		//return keyValueService.getValueForKey(key);
		return keyValueService.getValueForKey("Welcome_Message");
		//return "Search Service Controller is up";
	}
	
	 @GetMapping("/hello")
	    public Mono<String> sayHello() {
	        return Mono.just("Hello from Reactive Spring!");
	  }
	 
	
}
