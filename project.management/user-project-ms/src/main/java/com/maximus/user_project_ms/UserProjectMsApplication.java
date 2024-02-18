package com.maximus.user_project_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserProjectMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProjectMsApplication.class, args);
    }

}
