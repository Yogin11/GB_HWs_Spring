package com.maximus.usersmicroservice.models;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Класс-сущность пользователь
 */
@Data
@Entity
@Table(name = "users")
public class User {

    /** Идентификатор пользователя */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**  имя пользователя */
    @Column(nullable = false)
    private String name;

    /** фаимлия пользователя */
    private String surname;

    /** email пользователя */
    private String email;

    /** роль пользователя в проекте */
    private String role;

}
