package com.maximus.hw5_tasks_app.controllers;

import com.maximus.hw5_tasks_app.models.Task;
import com.maximus.hw5_tasks_app.models.TaskStatus;
import com.maximus.hw5_tasks_app.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер задач
 */
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    /**
     * Внедренный объект класса сервиса
     */
    private TaskService taskService;

    /**
     * Получение списка всех задач по Get-запросу с эндпоинта "/tasks"
     *
     * @return список всех задач
     */
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    /**
     * Добавление новой задачи из тела Post-запроса с эндпоинта "/tasks"
     *
     * @param task новая задача
     * @return добавленная задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    /**
     * Получение списка задач с запрашиваемым статусом по Get-запросу
     * с эндпоинта "/tasks/status/{status}"
     *
     * @param status запрошенный статус
     * @return список задач с данным статусом
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.getTaskByStatus(status);
    }

    /**
     * Изменение данных задачи из тела Put-запроса
     * с эндпоинта "/tasks/{id}"
     *
     * @param id идентификатор задачи
     * @param task задача с обновленными данными в теле запроса
     * @return обновленная задача
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    /**
     * Удаление задачи по DELETE-запросу
     * с эндпоинта "/tasks/{id}"
     *
     * @param id идентификатор задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
