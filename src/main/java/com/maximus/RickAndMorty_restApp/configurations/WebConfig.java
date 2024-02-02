package com.maximus.RickAndMorty_restApp.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


/**
 * класс конфигурации бинов RestTemplate и HttpHeaders
 */
@Configuration
public class WebConfig {

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}

	@Bean
	public HttpHeaders headers()
	{
		return new HttpHeaders();
	}

}

