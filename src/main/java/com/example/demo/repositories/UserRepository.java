package com.example.demo.repositories;

import com.example.demo.model.SqlQueries;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Класс хранения и получения данных
 */

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;
    private RowMapper<User> userRowMapper;

    /**
     * Класс шаблонов SQL запросов, Dependency Injection в данный класс
     */
    private final SqlQueries queries;


    /**
     * Отправка SQL-запроса в базу данных для получения всех пользователей
     * @return список объектов пользователя
     */
    public List<User> findAll() {

        userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(queries.getShowAllUsers(), userRowMapper);
    }

    /**
     * Отправка SQL-запроса в базу данных для сохранения пользователя
     * @param user объект пользователя
     * @return
     */

    public User save(User user) {
        jdbc.update(queries.getAddUser(), user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Отправка SQL-запроса в базу данных для удаления пользователя
     *
     * @param id пользователя
     */
    public void deleteById(int id) {
        jdbc.update(queries.getDeleteUser(), id);
    }

    /**
     * Отправка SQL-запроса в базу данных для обновления данных пользователя
     *
     * @param user - объект пользователя
     */
    public void updateUser(User user) {
        jdbc.update(queries.getUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
    }

    /**
     * Получение из базы данных пользователя по id пользователя
     *
     * @param id пользователя
     * @return объект пользователя (User)
     */
    public User getById(int id) {
        return jdbc.queryForObject(queries.getGetUserById(), userRowMapper, id);
    }

}
