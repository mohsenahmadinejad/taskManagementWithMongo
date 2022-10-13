package com.ampada.taskmanagementwithmongo.controller;

import com.ampada.taskmanagementwithmongo.model.User;
import com.ampada.taskmanagementwithmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;




    @PostMapping("/signUp")
    public ResponseEntity<String> addUser(@RequestBody User user) {
       return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }


}