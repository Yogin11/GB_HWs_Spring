package com.maximus.user_project_ms.services;

import com.maximus.user_project_ms.feign_clients.UserProjectFeignClient;
import com.maximus.user_project_ms.repositories.UsersProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-сервис обработки сущностей пользователь-проект
 */
@RequiredArgsConstructor
@Service
public class UserProjectService {

    /**
     * Внедряемая зависимость репозитория пользователь-проект
     */
    private final UsersProjectRepository userProjRepo;

    /**
     * Внедряемая зависимость интерфейса feignClient
     */
    private final UserProjectFeignClient feignClient;


    /**
     * Получение списка пользователей проекта по id проекта
     *
     * @param projectId идентификатор проекта
     * @return список пользователей проекта
     */
    public List<Object> getUsersByProjectId(Long projectId) {
        List<Long> listUserIds = userProjRepo.findByProjectId(projectId);
        List<Object> userList = new ArrayList<>();
        for (Long num : listUserIds) {

            userList.add(feignClient.getUserById(num).getBody());
        }
        return userList;
    }

    /**
     * Получение списка проектов по id пользователя
     * @param userId идентификатор пользователя
     * @return список проектов пользователя
     */
    public List<Object> getProjectsByUserId(Long userId) {
        List<Long> listProjectIds = userProjRepo.findByUserId(userId);
        List<Object> projectList = new ArrayList<>();
        for (Long num : listProjectIds) {
            projectList.add(feignClient.getProjectById(num).getBody());
        }
        return projectList;
    }

    /**
     * Добавление пользователя в проект
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     */
    public void addUserToProject(Long userId, Long projectId) {
        userProjRepo.addUserToProject(userId, projectId);
    }

    /**
     * Удаление пользователя из проекта
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     */
    public void removeUserFromProject(Long userId, Long projectId) {
        userProjRepo.deleteUserFromProject(userId,projectId);
    }

}
