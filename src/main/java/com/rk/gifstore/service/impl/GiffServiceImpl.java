package com.rk.gifstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.gifstore.entity.GiffEntity;
import com.rk.gifstore.entity.GiffPurchaseEntity;
import com.rk.gifstore.exception.GiffStoreForbiddenException;
import com.rk.gifstore.exception.GiffStoreNoDataFoundException;
import com.rk.gifstore.repository.GiffPurchaseRepository;
import com.rk.gifstore.repository.GiffRepository;
import com.rk.gifstore.request.BuyGiffRequest;
import com.rk.gifstore.service.GiffService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GiffServiceImpl implements GiffService {

	@Autowired
	GiffRepository giffRepository;

	@Autowired
	GiffPurchaseRepository giffPurchaseRepository;

	@Override
	public Flux<GiffEntity> getAllGiffs() {
		return giffRepository.findAll();
	}

	@Override
	public Mono<GiffEntity> uploadGiff(byte[] file, long userId, long price) {
		return giffRepository.save(new GiffEntity(file, userId, price));
	}

	@Override
	public Mono<GiffPurchaseEntity> butGiff(BuyGiffRequest request) {
		return giffPurchaseRepository.save(new GiffPurchaseEntity(request.getUserId(), request.getGiffId()));
	}

	@Override
	public Mono<GiffEntity> downloadGiff(long userId, long giffId) {
		Mono<GiffPurchaseEntity> giffPrchsEntity = giffPurchaseRepository.findByUserIdAndGiffId(userId, giffId);
		Mono<GiffEntity> result = giffRepository.findById(giffId);
		GiffEntity entity = result.block();
		if(entity==null) {
			throw new GiffStoreNoDataFoundException("Giff doesn't exist");
		}
		if (giffPrchsEntity.block() == null && entity.getOwnerId()!=userId) {
			throw new GiffStoreForbiddenException("You don't have ownership of this GIF");
		}
		return result;
	}

}
