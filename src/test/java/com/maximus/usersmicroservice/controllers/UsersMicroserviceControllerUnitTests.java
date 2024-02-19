package com.maximus.usersmicroservice.controllers;

import com.maximus.usersmicroservice.models.User;
import com.maximus.usersmicroservice.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


/**
 * Класс для юнит-тестов UserController
 */
@ExtendWith(MockitoExtension.class)
public class UsersMicroserviceControllerUnitTests {
    /**
     * Создание mock-объекта сервиса
     */
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    /**
     * Тестирование метода контроллера для получения пользователя по id
     */
    @Test
    public void getUserByIdSuccessTest(){
        User user = new User();
        user.setName("Данил");

        given(userService.getUserById(1L)).willReturn(user);

        User newUser = userController.getUserById(1L);

        assertEquals(newUser.getName(), "Данил");
    }

    /**
     * Проверка получения объекта пользователя при отсутствии запрошенного id
     */
    @Test
    public void getUserByIdTestFail(){

        given(userService.getUserById(1L)).willReturn(null);

        User newUser = userController.getUserById(1L);

        assertNull(newUser);
    }

    /**
     * Проверка успешного обновления данных пользователя
     */
    @Test
    public void updateUserSuccessTest(){
        User existingUser = new User();
        existingUser.setId(1L);
        existingUser.setName("Глеб");
        User userData = new User();
        userData.setName("Данил");
        existingUser.setName(userData.getName());

        given(userService.updateUser(1L,userData)).willReturn(existingUser);

        User newUser = userController.updateUser(1L,userData);

        assertEquals("Данил",newUser.getName());
    }

    /**
     * Проверка вызова исключения при обновлении данных пользователя с несуществующим id
     */
    @Test
    public void updateUserTestFail(){
        User userData = new User();

        given(userService.updateUser(1L,userData)).willThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class,()-> userController.updateUser(1L, userData));
    }

}
