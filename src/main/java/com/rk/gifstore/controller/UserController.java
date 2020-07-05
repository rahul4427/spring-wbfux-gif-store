package com.rk.gifstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rk.gifstore.api.UserApi;
import com.rk.gifstore.entity.UserEntity;
import com.rk.gifstore.request.AddUserRequest;
import com.rk.gifstore.service.UserService;

import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(tags = "User")
public class UserController implements UserApi{

	@Autowired
	UserService userService;
	
	@Override
	public Flux<UserEntity> getAllUser() {
		return userService.getAllUsers();
	}

	@Override
	public Mono<UserEntity> addUser(AddUserRequest request) {
		return userService.addNewUser(request);
	}

}
