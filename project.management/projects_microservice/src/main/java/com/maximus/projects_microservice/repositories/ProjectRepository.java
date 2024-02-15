package com.maximus.projects_microservice.repositories;

import com.maximus.projects_microservice.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Репозиторий проектов - интерфейс работы с базой данных
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
