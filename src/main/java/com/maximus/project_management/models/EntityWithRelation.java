package com.maximus.project_management.models;

import jakarta.persistence.*;
import lombok.Setter;

import java.lang.annotation.Inherited;

/**
 * Абстрактный класс "сущность со связью"
 */
@Entity
public abstract class EntityWithRelation {

    /** Идентификатор связи */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /** Идентификатор связанной сущности */
    @Setter
    protected Long relatedEntityId;

}
