package com.maximus.user_project_ms.services;

//import com.maximus.user_project_ms.aspect.TrackUserAction;
//import com.maximus.user_project_ms.models.Project;
//import com.maximus.user_project_ms.models.User;
//import com.maximus.user_project_ms.repositories.ProjectRepository;
//import com.maximus.user_project_ms.repositories.UserRepository;
import com.maximus.user_project_ms.models.api.ApiProjects;
import com.maximus.user_project_ms.models.api.ApiUsers;
import com.maximus.user_project_ms.repositories.UsersProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private final ApiProjects projectsApi;
    private final ApiUsers usersApi;

//    private final UserRepository userRepository;
//    private final ProjectRepository projectRepository;

    /**
     * Получение списка пользователей проекта по id проекта
     *
     * @param projectId идентификатор проекта
     * @return список пользователей проекта
     */
//    @TrackUserAction
    public List<Object> getUsersByProjectId(Long projectId) {
        List<Long> listUserIds = userProjRepo.findByProjectId(projectId);
        List<Object> userList = new ArrayList<>();
        RestTemplate template = new RestTemplate();
//        String requestPage = "http://127.0.0.1:8081/users";
        for (Long num : listUserIds) {
            ResponseEntity<Object> response = template.getForEntity(usersApi.getBasicUri() +num, Object.class);
            userList.add(response.getBody());
        }
        return userList;
    }

    /**
     * Получение списка проектов по id пользователя
     * @param userId идентификатор пользователя
     * @return список проектов пользователя
     */
//    @TrackUserAction
    public List<Object> getProjectsByUserId(Long userId) {
        List<Long> listProjectIds = userProjRepo.findByUserId(userId);
        List<Object> projectList = new ArrayList<>();
        RestTemplate template = new RestTemplate();
//        String requestPage = "http://127.0.0.1:8082/projects";
        for (Long num : listProjectIds) {
            ResponseEntity<Object> response = template.getForEntity(projectsApi.getBasicUri()+num, Object.class);
            projectList.add(response.getBody());
        }
        return projectList;
    }

    /**
     * Добавление пользователя в проект
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     */
//    @TrackUserAction
    public void addUserToProject(Long userId, Long projectId) {
        userProjRepo.addUserToProject(userId, projectId);
    }

    /**
     * Удаление пользователя из проекта
     * @param userId идентификатор пользователя
     * @param projectId идентификатор проекта
     */
//    @TrackUserAction
    public void removeUserFromProject(Long userId, Long projectId) {
        userProjRepo.deleteUserFromProject(userId,projectId);
    }

}
