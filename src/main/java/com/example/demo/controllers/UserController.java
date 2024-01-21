package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Основной класс-контроллер приложения
 */
@Controller
@AllArgsConstructor
@Log
public class UserController {

    private final UserService userService;

    /**
     * Запрос списка всех пользователей в userService, его передача в форму user-list,
     * вызов страницы с формой user-list
     * @param model объект Model, заполняющийся данными для передачи шаблонизатору
     * @return страница "user-list"
     */
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.info("Показываем всех пользователей из списка: " + users);
        return "user-list";
    }

    /**
     * Вызов формы создания нового пользователя
     * @param user объект пользователя, принимающий данные из формы
     * @return страница c формой создания нового пользователя
     */

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        log.info("Отправление формы для создания пользователя: " + user);
        return "user-create";
    }

    /**
     * Создание нового пользователя с помощью данных из формы и передача его на сохранение в БД
     * @param user объект пользователя, принимающий данные из формы
     * @return главная страница
     */
    @PostMapping("/user-create")
    public String createUser(User user) {
        log.info("Cоздание пользователя: " + user);
        userService.saveUser(user);
        log.info("Cохранение пользователя: " + user);
        return "redirect:/users";
    }

    /**
     * Метод, принимающий id пользователя для удаления, и передающий его на удаление в БД
     * @param id пользователя
     * @return главная страница
     */

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        log.info("Удаление пользователя с id: " + id);
        userService.deleteById(id);
        return "redirect:/users";
    }

    /**
     * Передача attribute "user" cтранице с формой user-update и вызов этой страницы
     *
     * @param id пользователя
     * @param model объект Model, заполняющийся данными для передачи шаблонизатору
     * @return страница с формой update
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        log.info("Отправление формы для изменения данных пользователя с id " + id );
        model.addAttribute("user", userService.getOne(id));
        return "user-update";
    }

    /**
     * Отправка измененных данных со страницы user-update в базу данных через объект userService и
     * переход на страницу /users
     *
     * @param user пользователь
     * @return обновленная страница
     */

    @PostMapping("/user-update")
    public String updateUser(User user) {
        log.info("Изменение данных пользователя: " + user);
        userService.update(user);
        return "redirect:/users";
    }

}
