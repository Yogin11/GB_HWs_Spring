package com.maximus.project_management.models;

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
//@Table(name = "users_project")
//@DiscriminatorValue("UsersProject")
public class UsersProject extends EntityWithRelation {

    //    @ManyToOne
//    @JoinColumn(name="project_id") //, referencedColumnName="id")
    @Column(name = "project_id")
    private Long projectId;
    //    @ManyToOne
//    @JoinColumn(name="user_id") //, referencedColumnName="id")
    @Column(name = "user_id")
    private Long userId;

    public UsersProject() {
        super.setRelatedEntityId(1L);
    }

}
