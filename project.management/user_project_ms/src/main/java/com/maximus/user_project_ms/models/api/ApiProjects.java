package com.maximus.user_project_ms.models.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("api.projects")
public class ApiProjects {

    private String basicUri;
}
