package com.maximus.project_management.services;

import com.maximus.project_management.models.User;
import com.maximus.project_management.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Класс-сервис обработки пользователей
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;

    /**
     * Получение списка пользователей
     *
     * @return список всех пользователей
     */
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    /**
     * Получение пользователя по ID
     *
     * @param id идентификатор пользователя
     * @return запрошенный пользователь
     */
    public User getUserById(Long id) {
        Optional<User> optUser = userRepo.findById(id);
        return optUser.orElse(null);
    }

    /**
     * Добавление нового пользователя
     *
     * @param user новый пользователь
     * @return добавленный пользователь
     */
    public User addUser(User user) {
        return userRepo.save(user);
    }

    /**
     * Изменение данных пользователя
     *
     * @param id          идентификатор пользователя
     * @param userDetails пользователь с обновленными данными, (полученными из контроллера)
     * @return измененный пользователь
     */
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            return userRepo.save(user);
        } else {
            throw new IllegalArgumentException("Пользователь с id" + id + "не найден");
        }
    }

    /**
     * Удаление пользователя по ID
     *
     * @param id идентификатор пользователя
     */
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }


}
