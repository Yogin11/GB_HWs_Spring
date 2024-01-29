package com.maximus.project_management.models;

import jakarta.persistence.*;
import lombok.Setter;

import java.lang.annotation.Inherited;

/**
 * Абстрактный класс "сущность со связью"
 */
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn
public abstract class EntityWithRelation {

    /** Идентификатор связи */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

//    @Column(name="related_entity_id")
    /** Идентификатор связанной сущности */
    @Setter
    protected Long relatedEntityId;

}
