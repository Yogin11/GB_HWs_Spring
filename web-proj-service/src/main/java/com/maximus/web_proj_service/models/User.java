package com.maximus.web_proj_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public record User(Long id, String name, String password, String email, String role) {
}

