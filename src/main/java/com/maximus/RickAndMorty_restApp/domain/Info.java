package com.maximus.RickAndMorty_restApp.domain;

import lombok.Data;

/**
 * Класс сущность информация о списке вызываемых данных
 */

@Data
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
