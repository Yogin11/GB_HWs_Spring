package com.maximus.web_proj_service.controllers;

import org.springframework.web.servlet.ModelAndView;

public interface UIEndpointParsing {
    ModelAndView showData();
    ModelAndView addDataForm();
    ModelAndView updateDataForm(Long id);

    void saveData(Object obj);
    void deleteData(Long id);


}