package com.rk.gifstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.gifstore.entity.UserEntity;
import com.rk.gifstore.repository.UserRepository;
import com.rk.gifstore.request.AddUserRequest;
import com.rk.gifstore.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Flux<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Mono<UserEntity> addNewUser(AddUserRequest request) {
		return userRepository.save(new UserEntity(request.getUserName()));
	}

}
