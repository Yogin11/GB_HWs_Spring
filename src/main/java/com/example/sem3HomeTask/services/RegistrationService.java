package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    //Поля UserService, NotificationService

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    //Метод processRegistration
    public void processRegistration(String name, int age, String email){
        User newUser = userService.createUser(name,age,email);
        dataProcessingService.addUserToList(newUser);
    }
}
