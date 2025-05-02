package com.pradeep.kubernetes.micro.webappservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebAppServiceApplication {

	public static void main(String[] args) {
		 SpringApplication.run(WebAppServiceApplication.class, args);

	}

}
