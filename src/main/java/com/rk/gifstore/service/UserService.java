package com.rk.gifstore.service;

import com.rk.gifstore.entity.UserEntity;
import com.rk.gifstore.request.AddUserRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
	Flux<UserEntity> getAllUsers();
	Mono<UserEntity> addNewUser(AddUserRequest request);
}
