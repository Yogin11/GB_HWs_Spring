package com.maximus.RickAndMorty_restApp.domain;

import lombok.Data;

import java.util.List;

/**
 * Класс сущность список персонажей с информацией о странице
 */

@Data
public class CharactersList {

    Info info;
    List<Character> results;
}
