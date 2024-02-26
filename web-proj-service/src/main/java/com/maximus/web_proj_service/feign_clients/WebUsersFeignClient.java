package com.maximus.web_proj_service.feign_clients;

import com.maximus.web_proj_service.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Интерфейс Feign для связи с другими сервисами
 */
@FeignClient(name= "web-service",url="http://127.0.0.1:8765" ) //url="http://127.0.0.1:8765")
public interface WebUsersFeignClient {

    /**
     * Получение экземплярa проекта по id в объекте ResponseEntity
     * @param id идентификатор проекта
     * @return экземпляр проекта в объекте ResponseEntity
     */
    @GetMapping("/projects/{id}")
    ResponseEntity<Object> getProjectById(@PathVariable("id") Long id);

    /**
     * Получение экземплярa пользователя по id в объекте ResponseEntity
     * @param id идентификатор пользователя
     * @return экземпляр пользователя в объекте ResponseEntity
     */
    @GetMapping("/users/{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") Long id);

    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsers();

    @PostMapping("/users")
    User addUser(User user);

    @DeleteMapping("/users/{id}")
    void removeUser(@PathVariable("id") Long id);

}
