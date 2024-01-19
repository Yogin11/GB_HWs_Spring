package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {


    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().addUserToList(user);
        return "User added from body!";
    }

    /**
     * Метод создания пользователя из параметров HTTP запроса, например
     * localhost:8080/user/add?name=Георгий&age=35&email=pochta@yandex.ru
     *
     * @param name имя
     * @param age возраст
     * @param email email
     * @return данные добавленного пользователя в виде строки
     */
    @PostMapping("/add")
    public String userAddFromParam(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email){
        service.processRegistration(name, age, email);
        return name + " " + Integer.toString(age) + " " + email;
    }

}
