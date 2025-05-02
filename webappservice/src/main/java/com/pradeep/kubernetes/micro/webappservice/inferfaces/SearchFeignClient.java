package com.pradeep.kubernetes.micro.webappservice.inferfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="search-service", url = "http://search-service:80")
public interface SearchFeignClient {

	@GetMapping("/searchservice/check")
	public String getStatus();
	
	
    
}
