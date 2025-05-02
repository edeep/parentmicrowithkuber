package com.pradeep.kubernetes.micro.searchservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pradeep.kubernetes.micro.searchservice.entity.KeyAndValue;
import com.pradeep.kubernetes.micro.searchservice.repository.KeyValueRepository;

import reactor.core.publisher.Mono;

@Service
public class KeyValueService {
	
	@Autowired
	private KeyValueRepository keyValueRepository;
	
	public Mono<String> getValueForKey(String key) {
		Mono<KeyAndValue> resultAsMono = keyValueRepository.findByKey(key);
		Mono<String> resultAsMonoString = resultAsMono.map(keyAndValue->keyAndValue.getValue());
		return resultAsMonoString ;
			
	}

}
