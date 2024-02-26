package com.maximus.web_proj_service.controllers;

import com.maximus.web_proj_service.feign_clients.WebUsersFeignClient;
import com.maximus.web_proj_service.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;


@RequiredArgsConstructor
@Controller
//@RequestMapping("/general")
public class WebController {

    @Autowired
    private final WebUsersFeignClient feignClient;

    @GetMapping("/showUsers")
    public ModelAndView showUsers() {
        ModelAndView mav = new ModelAndView("list-users");
        List<User> list = feignClient.getAllUsers().getBody();
        mav.addObject("users", list);
        return mav;
    }

    @GetMapping("/addUserForm")
    public ModelAndView addUserForm() {
        ModelAndView mav = new ModelAndView("add-user-form");
        User newUser = new User(0L, "", "", "", "");
        mav.addObject("user", newUser);
        return mav;
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
        feignClient.addUser(user);
        return "redirect:/showUsers";

    }

    @GetMapping("/updateUserForm")
    public ModelAndView showUpdateForm(@RequestParam("id") Long userId) {
        ModelAndView mav = new ModelAndView("add-user-form");
        User updUser = feignClient.getUserById(userId).getBody();
        mav.addObject("user", updUser);
        return mav;

    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long userId) {
        feignClient.removeUser(userId);
        return "redirect:/showUsers";
    }

}
