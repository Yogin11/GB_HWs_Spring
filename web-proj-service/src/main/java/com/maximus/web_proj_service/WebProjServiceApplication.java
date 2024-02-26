package com.maximus.web_proj_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebProjServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebProjServiceApplication.class, args);
	}

}
