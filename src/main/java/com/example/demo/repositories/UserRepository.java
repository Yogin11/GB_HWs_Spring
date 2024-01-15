package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;
    private RowMapper<User> userRowMapper;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable VALUES (NULL, ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    /**
     * Отправка SQL-запроса в базу данных для удаления пользователя
     * @param id пользователя
     */
    public void deleteById(int id){
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Отправка SQL-запроса в базу данных для обновления данных пользователя
     *
     * @param user - пользователь
     */
    public void updateUser(User user){
        String sql = "UPDATE userTable SET firstName = ?, lastname = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(),user.getLastName(),user.getId());
    }

    /**
     * Получение из базы данных пользователя по id пользователя
     *
     * @param id пользователя
     * @return объект пользователя (User)
     */
    public User getById(int id){
        String sql = "SELECT * FROM userTable WHERE id=?";
        return  jdbc.queryForObject(sql, userRowMapper, id);
    }

}
