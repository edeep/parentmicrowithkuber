package com.pradeep.kubernetes.micro.searchservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/searchservice")
public class SearchController {

	@GetMapping("/check")
	public String getStatus() {
		return "Search Service Controller is up";
	}
}
