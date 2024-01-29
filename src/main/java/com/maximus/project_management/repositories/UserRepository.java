package com.maximus.project_management.repositories;

import com.maximus.project_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий пользователей
 * - интерфейс работы с базой данных
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
