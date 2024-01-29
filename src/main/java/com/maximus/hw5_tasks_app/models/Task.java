package com.maximus.hw5_tasks_app.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Класс-сущность задача
 */
@Data
@Entity
@Table(name = "tasks")
public class Task {

    /** Идентификатор задачи */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    /** Описание задачи */
    @Column(nullable = false)
    private String description;

    /**Статус задачи из класса энумератора статусов TaskStatus */
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    /**Дата и время создания задачи */
    private LocalDateTime created;
}


