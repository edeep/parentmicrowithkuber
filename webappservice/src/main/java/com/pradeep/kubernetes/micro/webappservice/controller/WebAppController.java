package com.pradeep.kubernetes.micro.webappservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webappservice")
public class WebAppController {

	@GetMapping("/check")
	public String getStatus() {
		return "Controller is up";
	}
}
