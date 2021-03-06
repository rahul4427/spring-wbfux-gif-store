package com.rk.gifstore.service;

import com.rk.gifstore.entity.GiffEntity;
import com.rk.gifstore.entity.GiffPurchaseEntity;
import com.rk.gifstore.request.BuyGiffRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GiffService {
	Flux<GiffEntity> getAllGiffs();
	Mono<GiffEntity> uploadGiff(byte[] file, long userId, long price);
	Mono<GiffPurchaseEntity> butGiff(BuyGiffRequest request);
	Mono<GiffEntity> downloadGiff(long userId, long giffId);
}
