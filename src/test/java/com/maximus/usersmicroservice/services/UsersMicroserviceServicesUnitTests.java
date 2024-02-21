package com.maximus.usersmicroservice.services;

import com.maximus.usersmicroservice.models.User;
import com.maximus.usersmicroservice.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Класс для юнит-тестов UserService
 */
@ExtendWith(MockitoExtension.class)
class UsersMicroserviceServicesUnitTests {

	static User user;

	/**
	 * Создание mock-объекта репозитория
	 */
	@Mock
	private UserRepository userRepository;


	@InjectMocks
	private UserService userService;

	/**
	 * Инициализация общих входных данных для тестов
	 */
	@BeforeAll
	static void init(){
		user = new User();
		user.setId(1L);
		user.setName("Иннокентий");
		user.setRole("историк");
	}


	/**
	 * Тест метода addUser.
	 * Проверка запуска сохранения пользователя в репозиторий при вызове метода addUser
	 */
	@Test
	public void addUserFunctionWorksFine() {

		given(userRepository.save(user)).willReturn(user);

		userService.addUser(user);

		verify(userRepository).save(user);
	}

	/**
	 * Тест метода updateUser.
	 * При выполнении метода у пользователя должно обновиться имя на новое.
	 */
	@Test
	public void updateUserFunctionWorksFine() {
		User updatedDataUser = new User();
		updatedDataUser.setName("Проктор");

		given(userRepository.save(user)).willReturn(user);
		given(userRepository.findById(1L)).willReturn(Optional.ofNullable(user));

		userService.addUser(user);
		User updatedUser = userService.updateUser(1L, updatedDataUser);

		Assertions.assertEquals(updatedUser.getName(),"Проктор");
	}

	/**
	 * Тест метода updateUser.
	 * При отсутствии в репозитории запрошенного id должен выбросить исключение IllegalArgumentException
	 */
	@Test
	public void updateUserFunctionThrowsException() {
		User updatedDataUser = new User();
		updatedDataUser.setName("Проктор");

		//userRepository - пустой
		when(userRepository.findById(1L)).thenThrow(IllegalArgumentException.class);

		assertThrows(IllegalArgumentException.class,()-> userService.updateUser(1L, updatedDataUser));
	}

}
