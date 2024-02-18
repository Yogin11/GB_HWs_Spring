package com.maximus.projects_microservice.services;

import com.maximus.projects_microservice.models.Project;
import com.maximus.projects_microservice.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Класс-сервис обработки проектов
 */

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepo;

    /**
     * Получение списка всех проектов
     * @return список всех проектов
     */
    public List<Project> getAllProjects(){
        return projectRepo.findAll();
    }

    /**
     * Получение проекта по ID
     * @param id идентификатор проекта
     * @return запрошенный проект
     */
//    @TrackUserAction
    public Project getProjectById(Long id){
        Optional<Project> optProject = projectRepo.findById(id);
        return optProject.orElse(null);
    }

    /**
     * Добавление нового проекта
     * @param project новый проект
     * @return добавленный проект
     */
//    @TrackUserAction
    public Project addProject(Project project){
        if (project.getCreatedDate()==null){
            project.setCreatedDate(LocalDate.now());
        }
        return projectRepo.save(project);
    }

    /**
     * Изменение данных проекта
     * @param id идентификатор проекта
     * @param projectDetails проекта с обновленными данными, (полученными из контроллера)
     * @return измененный проект
     */
//    @TrackUserAction
    public Project updateProject (Long id, Project projectDetails){
        Optional<Project> optionalProject = projectRepo.findById(id);
        if (optionalProject.isPresent()){
            Project project = optionalProject.get();
            project.setName(projectDetails.getName());

            project.setDescription(projectDetails.getDescription());
            return projectRepo.save(project);
        } else {
            throw new IllegalArgumentException("Проект с id " + id + "не найден");
        }
    }

    /**
     * Удаление проекта по ID
     * @param id идентификатор проекта
     */
//    @TrackUserAction
    public void deleteProject(Long id){
        projectRepo.deleteById(id);
    }


 }
