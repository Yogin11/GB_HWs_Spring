package com.maximus.RickAndMorty_restApp.service;

import com.maximus.RickAndMorty_restApp.domain.Character;
import com.maximus.RickAndMorty_restApp.domain.CharactersList;

import java.util.List;

/**
 * Интерфейс обработки данных
 */

public interface ServiceApi {
    CharactersList getAllCharacters(Integer page);

    //    Character getCharacterByName(String name);
    List<Character> showAllCharacters(Integer page);

    Integer getCurrentPage();

    Integer getTotalNumberOfPages();
}
