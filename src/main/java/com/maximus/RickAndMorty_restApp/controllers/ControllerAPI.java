package com.maximus.RickAndMorty_restApp.controllers;

import com.maximus.RickAndMorty_restApp.domain.CharactersList;
import com.maximus.RickAndMorty_restApp.service.ServiceApi;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Класс контроллер получения данных по API
 */
@RestController
@RequestMapping("/restAPI")
public class ControllerAPI {

//    @Autowired
    private final ServiceApi serviceApi;
    private final Integer maximumPagesNumber;

    public ControllerAPI(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
        this.maximumPagesNumber = serviceApi.getTotalNumberOfPages();
    }

    /**
     * Получение сущности списка персонажей с заданной страницы по Get-запросу с эндпоинта "/RestAPI/{page}"
     * @param page заданная страница
     * @return объект с сущностью списка персонажей
     */
    @GetMapping("/{page}")
    public ResponseEntity<CharactersList> getCharacters(@PathVariable("page") Integer page) {
        if (page <= 0) page = maximumPagesNumber;
        else if (page >= maximumPagesNumber+1) page = 1;
        return new ResponseEntity<>(serviceApi.getAllCharacters(page), HttpStatus.OK);
    }

    /**
     * Перенаправление ответа клиенту с основного эндпоинта "/restAPI" на ответ
     * с другого эндпоинта (первой страницы)
     * @param response объект ответа сервлета
     * @throws IOException исключение ввода/вывода
     */
    @GetMapping
    void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/restAPI/1");
    }
}
