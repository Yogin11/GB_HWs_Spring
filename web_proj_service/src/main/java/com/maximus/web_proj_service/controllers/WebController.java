package com.maximus.web_proj_service.controllers;

import com.maximus.web_proj_service.feign_clients.WebUsersFeignClient;
import com.maximus.web_proj_service.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;


@RequiredArgsConstructor
@Controller
//@RequestMapping("/general")
public class WebController {

    @Autowired
    private final WebUsersFeignClient feignClient;

    @GetMapping("/showUsers")
    public ModelAndView showUsers(){
        ModelAndView mav = new ModelAndView("list-users");
        List<User> list = feignClient.getAllUsers().getBody();
        System.out.println(list);
        mav.addObject("users",list);
        return mav;
    }
}
