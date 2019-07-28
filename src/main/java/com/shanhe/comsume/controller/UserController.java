package com.shanhe.comsume.controller;

import com.shanhe.comsume.entity.User;
import com.shanhe.comsume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService ;

    @RequestMapping("/getUser")
    public List<User> getUser(){
        return userService.getUser();
    }



}
