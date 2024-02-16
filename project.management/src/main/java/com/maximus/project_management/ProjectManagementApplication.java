package com.maximus.project_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("Users-ms", r -> r.path("/users/**")
						.uri("http://localhost:8081/"))
				.route("Projects-ms", r -> r.path("/projects/**")
						.uri("http://localhost:8082/"))
				.route("User-project-ms", r -> r.path("/user-project/**")
						.uri("http://localhost:8083/")).build();
	}
}
