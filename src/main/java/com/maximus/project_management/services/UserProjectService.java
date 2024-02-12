package com.maximus.project_management.services;

import com.maximus.project_management.aspect.TrackUserAction;
import com.maximus.project_management.models.Project;
import com.maximus.project_management.models.User;
import com.maximus.project_management.repositories.ProjectRepository;
import com.maximus.project_management.repositories.UserRepository;
import com.maximus.project_management.repositories.UsersProjectRepository;
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
     * Внедряемые зависимости репозиториев сущностей пользователь,
     * проект и пользователь-проект
     */
    private final UsersProjectRepository userProjRepo;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    /**
     * Получение списка пользователей проекта по id проекта
     *
     * @param projectId идентификатор проекта
     * @return список пользователей проекта
     */
    @TrackUserAction
    public List<User> getUsersByProjectId(Long projectId) {
        List<Long> listUserIds = userProjRepo.findByProjectId(projectId);
        List<User> userList = new ArrayList<>();
        for (Long num : listUserIds) {
            userList.add(userRepository.findById(num).orElse(null));
        }
        return userList;
    }

    /**
     * Получение списка проектов по id пользователя
     * @param userId идентификатор пользователя
     * @return список проектов пользователя
     */
    @TrackUserAction
    public List<Project> getProjectsByUserId(Long userId) {
        List<Long> listProjectIds = userProjRepo.findByUserId(userId);
        List<Project> projectList = new ArrayList<>();
        for (Long num : listProjectIds) {
            projectList.add(projectRepository.findById(num).orElse(null));
        }
        return projectList;
    }

    /**
     * Добавление пользователя в проект
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     */
    @TrackUserAction
    public void addUserToProject(Long userId, Long projectId) {
        userProjRepo.addUserToProject(userId, projectId);
    }

    /**
     * Удаление пользователя из проекта
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     */
    @TrackUserAction
    public void removeUserFromProject(Long userId, Long projectId) {
        userProjRepo.deleteUserFromProject(userId,projectId);
    }

}
