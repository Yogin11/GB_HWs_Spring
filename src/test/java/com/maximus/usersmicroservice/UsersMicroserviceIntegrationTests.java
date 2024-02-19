package com.maximus.usersmicroservice;

import com.maximus.usersmicroservice.controllers.UserController;
import com.maximus.usersmicroservice.models.User;
import com.maximus.usersmicroservice.repositories.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Класс интеграционного тестирования приложения
 */
@SpringBootTest
public class UsersMicroserviceIntegrationTests {

    /**
     * Создание mock-объекта бина репозитория
     */
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserController userController;


    /**
     * Проверка успешного обновления данных пользователя
     */
    @Test
    void updateUserSuccess(){
        User user = new User();
        user.setId(10L);
        user.setName("Юлия");
        user.setRole("дизайнер");

        User newDataUser = new User();
        newDataUser.setRole("бухгалтер");

        User newDataAddedUSer = new User();
        newDataAddedUSer.setId(user.getId());
        newDataAddedUSer.setName("Юлия");
        newDataAddedUSer.setRole(newDataUser.getRole());

        when(userRepository.save(user)).thenReturn(user).thenReturn(newDataAddedUSer);
        when(userRepository.findById(10L)).thenReturn(Optional.of(user));

        userController.addUser(user);
        User updatedUser = userController.updateUser(10L,newDataUser);

        verify(userRepository, times(2)).save(user);

        assertEquals("бухгалтер", updatedUser.getRole());
        assertEquals("Юлия", updatedUser.getName());

    }
    /**
     * Проверка неудачного обновления данных пользователя, если не существует пользователя с таким id
     */
    @Test
    void updateUserFail(){
        User newDataUser = new User();
        newDataUser.setRole("бухгалтер");

        when(userRepository.findById(10L)).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class,()-> userController.updateUser(10L, newDataUser));
    }
}
