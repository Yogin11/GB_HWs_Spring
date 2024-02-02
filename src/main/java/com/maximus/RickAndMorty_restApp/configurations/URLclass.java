package com.maximus.RickAndMorty_restApp.configurations;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * Вспомогательный класс параметров конфигурации, хранящий
 * константы в файле web.properties
 */
@Configuration
@ConfigurationProperties(prefix = "web")
@ConfigurationPropertiesScan
@PropertySource("classpath:web.properties")
@Data
public class URLclass {
    private String urlAPI;
}
