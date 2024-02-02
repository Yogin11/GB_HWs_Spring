package com.maximus.RickAndMorty_restApp.controllers;


import com.maximus.RickAndMorty_restApp.domain.Character;
import com.maximus.RickAndMorty_restApp.service.ServiceApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Класс контроллер обработки запросов c web-страницы
 */
@Controller
public class WebController {

    private final ServiceApi serviceApi;
    private final Integer maximumPagesNumber;

    /**
     * Конструктор класса
     * @param serviceApi внедряемый класc сервиса обработки
     */
    public WebController(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
        this.maximumPagesNumber = serviceApi.getTotalNumberOfPages();
    }

    /**
     * Перенаправление с главной страницы "Welcome" на первую страницу списка персонажей
     * @return переадресация на первую страницу списка персонажей
     */
    @GetMapping("/welcome")
    public String redirectToOne() {
        return "redirect:/welcome/1";
    }

    /**
     * Получение и отправка в форму данных по персонажам с заданной в запросе страницы
     * @param page заданная страница
     * @param model объект модель
     * @return шаблон-представление "main" с выведением списка персонажей
     */
    @GetMapping("/welcome/{page}")
    public String getCharacters(@PathVariable("page") Integer page, Model model) {
        if (page <= 0) page = maximumPagesNumber;
        else if (page >= maximumPagesNumber+1) page = 1;
        model.addAttribute("characters", serviceApi.showAllCharacters(page));
        model.addAttribute("page_number", serviceApi.getCurrentPage());

        return "main";
    }

    /**
     * Получение данных персонажа с заданным в запросе id
     * @param id идентификатор персонажа
     * @param model объект модель
     * @return шаблон-представление "main" с выведением данных по персонажу
     */
    @GetMapping("/welcome/members/{id}")
    public String getCharacter(@PathVariable(name = "id") Integer id, Model model) {
        Integer currPage = serviceApi.getCurrentPage();
        Character character = serviceApi.showAllCharacters(currPage).get((id - 1) % 20);
        model.addAttribute("character", character);
        return "char";
    }

}
