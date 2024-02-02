package com.maximus.RickAndMorty_restApp.domain;

import lombok.Data;

import java.util.Date;

/**
 * Класс сущность персонаж
 */

@Data
public class Character {

        private Integer id;
        private String name;
        private String status;
        private String species;
        private String type;
        private String gender;
        private CharOrigin origin;
        private CharLocation location;
        private String image;
        private String url;
        private Date created;

}
