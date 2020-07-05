package com.rk.gifstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableR2dbcRepositories
@EnableSwagger2
@ComponentScan(basePackages = "com.rk.gifstore")
public class WebfluxEcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxEcomApplication.class, args);
	}

}
