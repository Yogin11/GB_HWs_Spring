package com.maximus.project_management.controllers;

import com.maximus.project_management.models.Project;
import com.maximus.project_management.models.User;
import com.maximus.project_management.services.UserProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Класс-контроллер сущностей пользователь-проект
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/user_project")
public class UserProjectController {


    /**
     * Внедрение зависимости репозитория сущностей пользователь-проект
     */
    private final UserProjectService userProjectService;

    /**
     * Получение списка пользователей по id проекта по GET-запросу с эндпоинта "/user_project/projects/{projectId}"
     * @param projectId идентификатор проекта
     * @return объект списка пользователей с ответом сервера
     */
    @GetMapping("/projects/{projectId}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable("projectId") Long projectId) {
        return new ResponseEntity<>(userProjectService.getUsersByProjectId(projectId), HttpStatus.OK);
    }

    /**
     * Получение списка проектов по id пользователя по GET-запросу с эндпоинта "/user_project/users/{userId}"
     * @param userId идентификатор пользователя
     * @return объект списка проектов с ответом сервера
     */
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(userProjectService.getProjectsByUserId(userId), HttpStatus.OK);
    }

    /**
     * Добавление сущности, связывающей проект и пользователя по их id
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     * @return пустой объект с ответом сервера
     */
    @PostMapping("/projects/{projectId}/{userId}")
    public ResponseEntity<Void> addUserToProject(@PathVariable("userId")Long userId,@PathVariable("projectId") Long projectId) {
            userProjectService.addUserToProject(userId,projectId);
        return ResponseEntity.ok().build();
    }

    /**
     * Удаление сущности, связывающей проект и пользователя по их id
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     * @return пустой объект с ответом сервера
     */
    @DeleteMapping("/projects/{projectId}/{userId}")
    public ResponseEntity<Void> removeUserFromProject(@PathVariable("userId")Long userId,@PathVariable("projectId") Long projectId) {
        userProjectService.removeUserFromProject(userId,projectId);
        return ResponseEntity.ok().build();
    }
}
