package com.subd.library.controller;

import com.subd.library.entity.User;
import com.subd.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
