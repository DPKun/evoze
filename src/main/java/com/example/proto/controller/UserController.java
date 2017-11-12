package com.example.proto.controller;

import com.example.proto.model.Travel;
import com.example.proto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){this.userService=userService;}

    @RequestMapping(value = "/travels",produces = "application/json")
    public List<Travel> listTravels(){
        return userService.listTravels("a@b.com");
    }
}
