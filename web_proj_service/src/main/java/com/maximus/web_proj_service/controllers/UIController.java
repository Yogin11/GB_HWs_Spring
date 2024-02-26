package com.maximus.web_proj_service.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@RequiredArgsConstructor
@Data
@Controller
public class UIController {

    @Autowired
    private UIEndpointParsing uiInterface;

    @Autowired
    private WebUsersController usersController;


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
        return "redirect:/allData";
    }

    @GetMapping("/allData")
    public ModelAndView showAllData() {
        return uiInterface.showData();
    }

    @GetMapping("/addData")
    public ModelAndView addData() {
        return uiInterface.addDataForm();
    }

    @GetMapping("/updateData")
    public ModelAndView updateData(@RequestParam("id") Long id) {
        return uiInterface.updateDataForm(id);

    }
}
