package com.maximus.hw4_part1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BasicController {

    @RequestMapping("/intro")
    public String greeting(){
        return "intro.html";
    }

    @GetMapping("/staff")
    public String showStaff(Model model){
        Map<String, String> people = new HashMap<>();
        people.put("Менеджер", "Чингачгук");
        people.put("Бухгалтер", "Зверобой");
        people.put("Оператор", "Джонстон");
        model.addAttribute("people", people);
        return "simple_thyme";
    }



}
