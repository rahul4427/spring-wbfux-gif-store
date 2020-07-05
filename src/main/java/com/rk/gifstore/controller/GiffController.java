package com.rk.gifstore.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rk.gifstore.api.GiffApi;
import com.rk.gifstore.entity.GiffEntity;
import com.rk.gifstore.entity.GiffPurchaseEntity;
import com.rk.gifstore.exception.GiffStoreBadRequestException;
import com.rk.gifstore.request.BuyGiffRequest;
import com.rk.gifstore.request.UploadGiffRequest;
import com.rk.gifstore.service.GiffService;

import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(tags = "Giff")
public class GiffController implements GiffApi{

	@Autowired
	GiffService giffService;
	
	@Override
	public Flux<GiffEntity> getGiffs() {
		return giffService.getAllGiffs();
	}

	@Override
	public HttpStatus uploadGiff(MultipartFile file, UploadGiffRequest request) throws IOException {
		if(!file.getContentType().equalsIgnoreCase(".gif")) {
			throw new GiffStoreBadRequestException("Please enter a valid gif");
		}
		Mono<GiffEntity> result = giffService.uploadGiff(file.getBytes(), request);
		result.block();
		return HttpStatus.OK;
	}

	@Override
	public HttpStatus buyGiff(BuyGiffRequest request) {
		Mono<GiffPurchaseEntity> response = giffService.butGiff(request);
		response.block();
		return HttpStatus.OK;
	}

	@Override
	public ResponseEntity<Resource> downloadGiff(long userId, long giffId) {
		Mono<GiffEntity> entity = giffService.downloadGiff(userId, giffId);		
		byte[] gif = entity.block().getGiff();
		Resource response = new ByteArrayResource(gif);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=download.gif");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/octet-stream")).body(response);
	}

}
