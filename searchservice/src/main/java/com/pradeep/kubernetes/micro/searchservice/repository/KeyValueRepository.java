package com.pradeep.kubernetes.micro.searchservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.pradeep.kubernetes.micro.searchservice.entity.KeyAndValue;

import reactor.core.publisher.Mono;

public interface KeyValueRepository extends ReactiveCrudRepository<KeyAndValue, Long> {

	Mono<KeyAndValue> findByKey(String name);
}
