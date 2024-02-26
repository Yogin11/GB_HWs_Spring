package com.maximus.web_proj_service.models;

import java.time.LocalDate;

public record Project(Long id, String name, String description, LocalDate createdDate) {
}
