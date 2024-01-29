package com.maximus.hw5_tasks_app.repositories;

import com.maximus.hw5_tasks_app.models.Task;
import com.maximus.hw5_tasks_app.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий задач
 * - интерфейс работы с базой данных 
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Возвращает список задач по заданному статусу
     *
     * @param status заданный статус задачи
     * @return список задач
     */
    List<Task> findTasksByStatus(TaskStatus status);

}
