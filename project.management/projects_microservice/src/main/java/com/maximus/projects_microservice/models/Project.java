package com.maximus.projects_microservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Класс-сущность проект
 */
@Data
@Entity
@Table(name = "projects")
public class Project {

    /** идентификтор пользователя */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** название проекта */
    private String name;

    /** описание проекта */
    private String description;

    /** дата создания проекта */
    @Column(name = "created_date")
    private LocalDate createdDate;
}
