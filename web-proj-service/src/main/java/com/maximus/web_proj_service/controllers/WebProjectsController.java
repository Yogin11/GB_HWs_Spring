package com.maximus.web_proj_service.controllers;

import com.maximus.web_proj_service.feign_clients.WebUsersFeignClient;
import com.maximus.web_proj_service.models.Project;
import com.maximus.web_proj_service.models.User;
import com.maximus.web_proj_service.services.FileGateway;
import com.thoughtworks.xstream.converters.time.LocalDateConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component("WebProjectsControl")
public class WebProjectsController implements UIEndpointParsing{

        @Autowired
        private final WebUsersFeignClient feignClient;

        private final FileGateway fileGateway;

        public ModelAndView showData() {
            ModelAndView mav = new ModelAndView("list-projects");
            List<Project> list = feignClient.getAllProjects().getBody();
            mav.addObject("projects", list);
            return mav;
        }

        public ModelAndView addDataForm() {
            ModelAndView mav = new ModelAndView("add-project-form");
            Project newProject = new Project(0L, "", "", LocalDate.now());
            String page_name = "Добавить проект";
            mav.addObject("page_name",page_name);
            mav.addObject("project", newProject);
            return mav;
        }

        public void saveData(Object obj) {
            if (((Project) obj).id() == 0L) {
                fileGateway.writeToFile("project_table_actions.txt", "Проект '" + ((Project) obj).name() + "' добавлен в БД в " +
                        LocalDateTime.now());
            }
            feignClient.addProject((Project) obj);
        }

        public ModelAndView updateDataForm(Long projectId) {
            ModelAndView mav = new ModelAndView("add-project-form");
            Project updProject = feignClient.getProjectById(projectId).getBody();
            String page_name = "Обновить данные проекта";
            mav.addObject("page_name",page_name);
            mav.addObject("project", updProject);
            fileGateway.writeToFile("project_table_actions.txt", "Данные проекта с id='" + projectId + "' обновлены в " +
                    LocalDateTime.now());
            return mav;
        }

        public void deleteData(Long projectId) {
            String delProject= feignClient.getProjectById(projectId).getBody().name();
            fileGateway.writeToFile("project_table_actions.txt", "Данные проекта '" + delProject + "' с id='" +
                    projectId + "' удалены в " + LocalDateTime.now());
            feignClient.removeProject(projectId);
        }
}
