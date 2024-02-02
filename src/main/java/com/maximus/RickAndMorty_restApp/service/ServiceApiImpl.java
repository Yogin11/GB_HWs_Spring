package com.maximus.RickAndMorty_restApp.service;

import com.maximus.RickAndMorty_restApp.configurations.URLclass;
import com.maximus.RickAndMorty_restApp.domain.Character;
import com.maximus.RickAndMorty_restApp.domain.CharactersList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Класс сервис получения из веб-источника и обработки данных персонажей
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceApiImpl implements ServiceApi {

    @Autowired
    private URLclass urLclass;
    @Autowired
    private RestTemplate template;
    @Autowired
    private HttpHeaders headers;

    private Integer currentPage;


    /**
     * Получение всех данных с заданной страницы веб-ресурса
     * @param page страница
     * @return информация со страницы веб ресурса
     */
    @Override
    public CharactersList getAllCharacters(Integer page) {
        return getAllInfo(page);
    }
    /**
     * Получение списка персонажей с заданной страницы веб-ресурса
     * @param page страница
     * @return список персонажей со страницы веб ресурса
     */
    @Override
    public List<Character> showAllCharacters(Integer page) {
        return getAllInfo(page).getResults();
    }
    /**
     * Получение количества страниц веб-ресурса
     * @return количество страниц веб ресурса
     */
    @Override
    public Integer getTotalNumberOfPages() {
        return getAllInfo(1).getInfo().getPages();
    }

    /**
     * Получение всех данных с заданной страницы веб-ресурса
     * @param page запрашиваемая страница
     * @return сущность списка персонажей22
     */
    private CharactersList getAllInfo(Integer page) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        currentPage = page;
        String requestedPage = urLclass.getUrlAPI() + "/?page=" + page;
        ResponseEntity<CharactersList> response = template.exchange(requestedPage, HttpMethod.GET, entity,
                CharactersList.class);
        return response.getBody();
    }
}
