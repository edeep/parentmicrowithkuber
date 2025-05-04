package com.pradeep.kubernetes.micro.searchservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.kubernetes.micro.searchservice.exception.ResourceNotFoundException;

import reactor.core.publisher.Mono;

@RestController
public class DefaultSearchController {

	@Value(value = "${simulate.error.value}")
	private String errorStringValue;
	
	
	@Value(value = "${spring.r2dbc.username}")
	private String r2dbcUsername;
	
	 @GetMapping("/")
	    public String serviceStatus() {
	        return "Search Service is Up!";
	  }
	 
	 @GetMapping("/checkErrorString")
	    public Mono<String> checkErrorString() {
		 	if ("ResourceNotFound1".equals(errorStringValue)) {
	            throw new ResourceNotFoundException("Item with id " + errorStringValue + " not found");
	        } else {
	        	return Mono.just("No Error case... Configured property value  ->  " + errorStringValue);
	        }
		 
	       
	  }
	 
		@GetMapping("/simulateErrorUsingFeignClient")
		public String simulateErrorUsingFeignClient() {
			//this is called using Feign client
			if ("ResourceNotFound".equals(errorStringValue)) {
	            throw new ResourceNotFoundException("Item with id " + errorStringValue + " not found");
	        }
			else {
				return "Search Service Controller is up";	
			}
			
		}
	 
	 @GetMapping("/checkUserName")
	    public Mono<String> checkUserName() {
	        return Mono.just("UserName is   ->  " + r2dbcUsername);
	  }
}
