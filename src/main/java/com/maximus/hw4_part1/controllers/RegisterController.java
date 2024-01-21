package com.maximus.hw4_part1.controllers;

import com.maximus.hw4_part1.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RegisterController {


    @GetMapping("/index")
    public String welcome() {
        return "index";
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        List<String> occupationList = Arrays.asList("Разработчик", "Студент", "Преподаватель",
                "Менеджер", "Руководитель", "Собственник");
        model.addAttribute("occupationList", occupationList);
        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("user") User user) {
        return "register_done";
    }

}
