package com.maximus.usersmicroservice.controllers;


import com.maximus.usersmicroservice.models.User;
import com.maximus.usersmicroservice.services.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс контроллер пользователей
 */

@Data
@RestController
@RequestMapping("/users")
//@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Получение списка всех пользователей по Get-запросу с эндпоинта "/users"
     *
     * @return список всех пользователей
     */
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    /**
     * Получение пользователя по ID по Get-запросу c эндпоинта "/users/id"
     * @param id идентификатор пользователя
     * @return запрашиваемый пользователь
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    /**
     * Добавление нового пользователя из тела Post-запроса с эндпоинта "/users"
     * @param user новый пользователь
     * @return добавленный пользователь
     */
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    /**
     * Изменение данных пользователя из тела Put-запроса
     * с эндпоинта "/users/id"
     * @param id идентификатор пользователя
     * @param user пользователь с обновленными данными
     * @return обновленный пользователь
     */
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    /**
     * Удаление пользователя по DELETE-запросу
     *      * с эндпоинта "/users/{id}
     * @param id идентификатор пользователя
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
