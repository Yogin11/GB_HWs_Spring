package com.maximus.web_proj_service.controllers;

import com.maximus.web_proj_service.feign_clients.WebUsersFeignClient;
import com.maximus.web_proj_service.models.User;
import com.maximus.web_proj_service.services.FileGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Component("WebUsersControl")
public class WebUsersController implements UIEndpointParsing {

    @Autowired
    private final WebUsersFeignClient feignClient;

    private final FileGateway fileGateway;

    public ModelAndView showData() {
        ModelAndView mav = new ModelAndView("list-users");
        List<User> list = feignClient.getAllUsers().getBody();
        mav.addObject("users", list);
        return mav;
    }

    public ModelAndView addDataForm() {
        ModelAndView mav = new ModelAndView("add-user-form");
        User newUser = new User(0L, "", "", "", "");
        String page_name = "Добавить пользователя";
        mav.addObject("page_name",page_name);
        mav.addObject("user", newUser);
        return mav;
    }

    public void saveData(Object obj) {
        if (((User) obj).id() == 0L) {
            fileGateway.writeToFile("user_table_actions.txt", "Пользователь '" + ((User) obj).name() + "' добавлен в БД в " +
                    LocalDateTime.now());
        }
        feignClient.addUser((User) obj);
    }

    public ModelAndView updateDataForm(Long userId) {
        ModelAndView mav = new ModelAndView("add-user-form");
        User updUser = feignClient.getUserById(userId).getBody();
        String page_name = "Обновить данные пользователя";
        mav.addObject("page_name",page_name);
        mav.addObject("user", updUser);
        fileGateway.writeToFile("user_table_actions.txt", "Данные пользователя с id='" + userId + "' обновлены в " +
                LocalDateTime.now());
        return mav;
    }

    public void deleteData(Long userId) {
        String delUser= feignClient.getUserById(userId).getBody().name();
        fileGateway.writeToFile("user_table_actions.txt", "Данные пользователя '" + delUser + "' с id='" +
                userId + "' удалены в " + LocalDateTime.now());
        feignClient.removeUser(userId);
    }

}
