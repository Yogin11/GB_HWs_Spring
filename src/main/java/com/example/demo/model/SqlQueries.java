package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * Класс шаблонов SQL запросов
 */
@Configuration
@ConfigurationProperties(prefix = "sql")
@ConfigurationPropertiesScan
@PropertySource("classpath:sql.properties")
@Data
public class SqlQueries {
    private String showAllUsers;
    private String addUser;
    private String deleteUser;
    private String updateUser;
    private String getUserById;

}
