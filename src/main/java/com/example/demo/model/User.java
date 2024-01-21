package com.example.demo.model;

import lombok.Data;

import java.util.Objects;

/**
 * Базовый класс Пользователь
 */

@Data
public class User {

    private int id;

    private String firstName;

    private String lastName;


}
