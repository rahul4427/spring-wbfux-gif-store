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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;

@RequestMapping("/giff")
public interface GiffApi {
	
	@ApiOperation(value = "Return all the Gif details", nickname = "getAllGiffs", response = Flux.class, tags = {"Giff"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Receive all giff details"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@GetMapping("/all")
	Flux<GiffEntity> getGiffs();
	
	@ApiOperation(value = "Registers a giff to be sold on the application", nickname = "uploadGiff", response = HttpStatus.class, tags = {"Giff"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Giff uploaded successfully"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@PostMapping("/sell-new")
	HttpStatus uploadGiff(@RequestParam("giff") MultipartFile file, @RequestParam("userId")long userId, @RequestParam("price")long price) throws IOException;
	
	@ApiOperation(value = "User can buy a Giff", nickname = "buyGiff", response = HttpStatus.class, tags = {"Giff"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Giff bought successfully"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@PostMapping("/buy")
	HttpStatus buyGiff(@RequestBody BuyGiffRequest request);
	
	@ApiOperation(value = "buyers and owners can download the giff", nickname = "downloadGiff", response = HttpStatus.class, tags = {"Giff"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Giff downloaded successfully"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@GetMapping("/{userId}/download/{id}")
	ResponseEntity<Resource> downloadGiff(@PathVariable("userId") long userId, @PathVariable("id") long giffId);
	
	
}
