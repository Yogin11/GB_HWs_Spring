package com.maximus.user_project_ms.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


/**
 * Класс-сущность пользователь-проект
 */
@Getter
@Setter
@Entity
public class UsersProject extends EntityWithRelation {

    /** Идентификатор проекта */
    @Column(name = "project_id")
    private Long projectId;

    /** Идентификатор пользователя */
    @Column(name = "user_id")
    private Long userId;

    /** Конструктор класса с установкой идентификатора RelatedEntityId */
    public UsersProject() {
        super.setRelatedEntityId(1L);
    }

}
