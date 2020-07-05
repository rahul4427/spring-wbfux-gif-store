package com.rk.gifstore.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.rk.gifstore.entity.GiffPurchaseEntity;

import reactor.core.publisher.Mono;

public interface GiffPurchaseRepository extends R2dbcRepository<GiffPurchaseEntity, Long> {
	
	Mono<GiffPurchaseEntity> findByUserIdAndGiffId(long userId, long giffId);

}
