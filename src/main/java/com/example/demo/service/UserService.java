package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

//    @Autowired
    private final UserRepository userRepository;

   //    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Передача id пользователя (user) в репозиторий для удаления
     *
     * @param id пользователя
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    /**
     * Передача объекта пользователя (user) в репозиторий для обновления
     *
     * @param user пользователь
     */
    public void update(User user) {
        userRepository.updateUser(user);
    }

    /**
     * Передача id для получения данных пользователя из репозитория
     *
     * @param id пользователя
     * @return объект пользователя (User)
     */
    public User getOne(int id) {
        return userRepository.getById(id);
    }

}
