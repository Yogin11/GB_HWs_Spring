package com.maximus.user_project_ms.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Интерфейс Feign для связи с другими сервисами
 */
@FeignClient(name= "project-service", url="http://127.0.0.1:8765")
public interface UserProjectFeignClient {

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
    ResponseEntity<Object> getUserById(@PathVariable("id") Long id);
}
