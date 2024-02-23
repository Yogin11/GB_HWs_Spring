package com.maximus.usersmicroservice.services;

import com.maximus.usersmicroservice.models.User;
import com.maximus.usersmicroservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Timer;

/**
 * Класс-сервис обработки пользователей
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;

//    @Autowired
//    private final Timer timer;

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
//    @TrackUserAction
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
//    @TrackUserAction
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
//    @TrackUserAction
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (userDetails.getName() != null) {
                user.setName(userDetails.getName());
            }
            user.setName(userDetails.getName());
            if (userDetails.getPassword() != null) {
                user.setPassword(userDetails.getPassword());
            }
            if (userDetails.getEmail() != null) {
                user.setEmail(userDetails.getEmail());
            }
            if (userDetails.getRole() != null) {
                user.setRole(userDetails.getRole());
            }
            return userRepo.save(user);
        } else {
            throw new IllegalArgumentException("Пользователь с id " + id + " не найден");
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
