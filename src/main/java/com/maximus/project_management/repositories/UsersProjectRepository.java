package com.maximus.project_management.repositories;

import com.maximus.project_management.models.UsersProject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий сущностей "пользователь-проект" - интерфейс работы с базой данных
 * */
@Transactional
@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {

    /**
     * Получение из базы данных списка идентификаторов пользователей по id проекта
     * с помощью кастомизированного запроса Query
     * @param id идентификатор проекта
     * @return список идентификаторов пользователей
     */
    @Query(value = "SELECT user_id FROM users_project p WHERE p.project_id=:id", nativeQuery = true)
    List<Long> findByProjectId(Long id);

    /**
     * Получение списка идентификаторов проектов по id пользователя
     * с помощью кастомизированного запроса Query
     * @param id идентификатор пользователя
     * @return список идентификаторов проектов
     */
    @Query(value = "SELECT project_id FROM users_project p WHERE p.user_id=:id", nativeQuery = true)
    List<Long> findByUserId(Long id);

    /**
     * Добавление связки идентификатора пользователя и проекта в базу данных с помощью
     * кастомизированного запроса Query. Здесь происходит привязывание id пользователя к id проекта
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     */
    @Modifying
    @Query(value="INSERT INTO users_project (project_id, user_id) VALUES (?2,?1)", nativeQuery = true)
    void addUserToProject(Long userId, Long projectId);

    /**
     * Удаление связки идентификатора пользователя и проекта из базы данных с помощью
     * кастомизированного запроса Query.
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     */
    @Modifying
    @Query(value = "DELETE FROM users_project WHERE project_id=:projectId AND user_id=:userId", nativeQuery = true)
    void deleteUserFromProject(Long userId, Long projectId);

}
