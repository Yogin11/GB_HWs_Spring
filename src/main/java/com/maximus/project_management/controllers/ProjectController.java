package com.maximus.project_management.controllers;

import com.maximus.project_management.models.Project;
import com.maximus.project_management.models.Project;
import com.maximus.project_management.services.ProjectService;
import com.maximus.project_management.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс-контроллер проектов
 * */
@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    /**
     * Получение списка всех проектов по Get-запросу с эндпоинта "/projects"
     * @return список всех проектов
     */
    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    /**
     * Получение проекта по ID по Get-запросу c эндпоинта "/projects/id"
     * @param id идентификатор проекта
     * @return запрошенный проект
     */
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id);
    }

    /**
     * Добавление нового проекта из тела Post-запроса с эндпоинта "/projects"
     * @param project новый проект
     * @return добавленный проект
     */
    @PostMapping
    public Project addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }

    /**
     * Изменение данных проекта из тела Put-запроса
     * с эндпоинта "/project/id"
     * @param id идентификатор проекта
     * @param project проект с измененными данными
     * @return измененный проект
     */
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project){
        return projectService.updateProject(id, project);
    }

    /**
     * Удаление проекта по DELETE-запросу
     *      * с эндпоинта "/project/id
     * @param id идентификатор проекта
     */
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }

}