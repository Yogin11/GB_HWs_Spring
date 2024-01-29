package com.maximus.hw5_tasks_app.services;

import com.maximus.hw5_tasks_app.models.Task;
import com.maximus.hw5_tasks_app.models.TaskStatus;
import com.maximus.hw5_tasks_app.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Класс-сервис обработки задач, отделяет контроллер и репозиторий
 */
@Data
@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository repository;

    /**
     * Получение списка задач из репозитория
     *
     * @return список задач, полученный из репозитория
     */
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    /**
     * Добавление новой задачи в репозиторий
     *
     * @param task новая задача
     * @return новая задача, полученная из репозитрия
     */
    public Task addTask(Task task){
        if (task.getCreated()==null){
            task.setCreated(LocalDateTime.now());
        }
        return repository.save(task);
    }

    /**
     *
     * Изменение данных задачи
     *
     * @param id идентификатор задачи
     * @param task задача с обновленными данными, (полученными из контроллера)
     * @return измененная задача, сохраненная в репозитории
     */
    public Task updateTask(Long id, Task task){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task updTask = optionalTask.get();
            updTask.setId(id);
            updTask.setDescription(task.getDescription());
            updTask.setStatus(task.getStatus());
            return repository.save(updTask);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * Получение списка задач по статусу
     *
     * @param status заданный статус
     * @return список найденных задач из  репозитория
     */
    public List<Task> getTaskByStatus(TaskStatus status){
        return repository.findTasksByStatus(status);
    }

    /**
     * Удаление задачи
     * @param id - идентификатор задачи
     */
    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
