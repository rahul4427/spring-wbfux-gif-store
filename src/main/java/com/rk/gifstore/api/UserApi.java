package com.rk.gifstore.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rk.gifstore.entity.UserEntity;
import com.rk.gifstore.request.AddUserRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("user")
public interface UserApi {

	@ApiOperation(value = "Fetch all users details", nickname = "getUsers", response = Flux.class, tags = {"User"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Users fetched successfully"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@GetMapping("/all")
	Flux<UserEntity> getAllUser();
	
	@ApiOperation(value = "Registers a new user", nickname = "addUser", response = Mono.class, tags = {"User"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User registration successful"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@PostMapping("/add")
	Mono<UserEntity> addUser(@RequestBody AddUserRequest request);
	
	
}
