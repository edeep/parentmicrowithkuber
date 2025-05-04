package com.pradeep.kubernetes.micro.webappservice.inferfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.pradeep.kubernetes.micro.webappservice.config.FeignClientConfig;

//@FeignClient(name ="search-service", url = "http://search-service:80", configuration = FeignClientConfig.class)
@FeignClient(name ="search-service", url = "http://localhost:8033", configuration = FeignClientConfig.class)
public interface SearchFeignClient {

	@GetMapping("/searchservice/check")
	public String getStatus();
	
	@GetMapping("/simulateErrorUsingFeignClient")
	public String simulateErrorUsingFeignClient();
	
    
}
