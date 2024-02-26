package com.maximus.web_proj_service.controllers;

import com.maximus.web_proj_service.models.Project;
import com.maximus.web_proj_service.models.User;
import com.maximus.web_proj_service.services.FileGateway;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@RequiredArgsConstructor
@Data
@Controller
public class UIController {

    public final String REDIRECT_STRING = "redirect:/allData";
    @Qualifier("WebUsersControl")
    @Autowired
    private UIEndpointParsing uiInterface;

    @Autowired
    @Qualifier("WebUsersControl")
    private UIEndpointParsing usersController;

    @Autowired
    @Qualifier("WebProjectsControl")
    private UIEndpointParsing projectsController;

    private final FileGateway fileGateway;

    public void setUiController(UIEndpointParsing uiInterface) {
        this.uiInterface = uiInterface;
    }

    @GetMapping("/")
    public String mainPageRedirect(Model model) {
        return "main";
    }

    @GetMapping("/users-data")
    public String redirectUsersPage() {
        setUiController(usersController);
        return REDIRECT_STRING;
    }

    @GetMapping("/projects-data")
    public String redirectProjectsPage() {
        setUiController(projectsController);
        return REDIRECT_STRING;
    }

    @GetMapping("/allData")
    public ModelAndView showAllData() {
        return uiInterface.showData();
    }

    @GetMapping("/addData")
    public ModelAndView addData() {
        return uiInterface.addDataForm();
    }

    @PostMapping("/saveDataUser")
    public String saveData(@ModelAttribute User user) {
        uiInterface.saveData(user);
        return REDIRECT_STRING;
    }

    @PostMapping("/saveDataProject")
    public String saveData(@ModelAttribute Project project) {
        uiInterface.saveData(project);
        return REDIRECT_STRING;
    }

    @GetMapping("/updateData")
    public ModelAndView updateData(@RequestParam("id") Long id) {
        return uiInterface.updateDataForm(id);
    }
    @GetMapping("/deleteData")
    public String deleteData(@RequestParam("id") Long id) {
        uiInterface.deleteData(id);
        return REDIRECT_STRING;
    }

}
