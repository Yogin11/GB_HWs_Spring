package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
    // !!Used in case application config is not assigning routes to services!
//	@Bean   //
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("Users-ms", r -> r.path("/users/**")
//						.uri("http://192.168.1.52:8081/"))
//				.route("Projects-ms", r -> r.path("/projects/**")
//						.uri("http://localhost:8082/"))
//				.route("User-project-ms", r -> r.path("/user-project/**")
//						.uri("http://localhost:8083/")).build();
//	}
}
