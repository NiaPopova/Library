package com.subd.library.controller;

import com.subd.library.entity.UserDTO;
import com.subd.library.entity.UserEntity;
import com.subd.library.mapper.UserMapper;
import com.subd.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> signUp(@RequestParam(name = "email") String email,
                                          @RequestParam(name = "password") String password) {
        UserEntity result = userService.signUp(email, password);
        return ResponseEntity.ok(userMapper.mapUserToDTO(result));
    }
}
