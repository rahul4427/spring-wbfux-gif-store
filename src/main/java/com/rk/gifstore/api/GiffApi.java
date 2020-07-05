package com.rk.gifstore.api;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rk.gifstore.entity.GiffEntity;
import com.rk.gifstore.request.BuyGiffRequest;
import com.rk.gifstore.request.UploadGiffRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;

@RequestMapping("/giff")
public interface GiffApi {
	
	@ApiOperation(value = "Registers a message for a user and make request to send notification", nickname = "sendNotification", response = Flux.class, tags = {"Giff"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Receive msg for a user and send notification"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@GetMapping("/all")
	Flux<GiffEntity> getGiffs();
	
	@ApiOperation(value = "Registers a message for a user and make request to send notification", nickname = "sendNotification", response = HttpStatus.class, tags = {"Giff"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Receive msg for a user and send notification"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@PostMapping("/sell-new")
	HttpStatus uploadGiff(@RequestParam("giff") MultipartFile file, @RequestBody UploadGiffRequest request) throws IOException;
	
	@ApiOperation(value = "Registers a message for a user and make request to send notification", nickname = "sendNotification", response = HttpStatus.class, tags = {"Giff"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Receive msg for a user and send notification"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@PostMapping("/buy")
	HttpStatus buyGiff(@RequestBody BuyGiffRequest request);
	
	@ApiOperation(value = "Registers a message for a user and make request to send notification", nickname = "sendNotification", response = HttpStatus.class, tags = {"Giff"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Receive msg for a user and send notification"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@GetMapping("/{userId}/download/{id}")
	ResponseEntity<Resource> downloadGiff(@PathVariable("userId") long userId, @PathVariable("id") long giffId);
	
	
}
