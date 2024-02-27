package com.maximus.web_proj_service.controllers;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UIEndpointParsing {
    ModelAndView showData();
    ModelAndView addDataForm();
    ModelAndView updateDataForm(Long id);

    void saveData(Object obj);
    void deleteData(Long id);

    ModelAndView addDataDetailsForm(Long id);

    ModelAndView addUsersToProjectForm(Long projectId);

    void addUsersToProject(Long projectID, List<Long> Ids);

    void removeUserFromProject(Long userId, Long projectId);

}
