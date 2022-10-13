package com.ampada.taskmanagementwithmongo.controller;

import com.ampada.taskmanagementwithmongo.dto.UserDto;
import com.ampada.taskmanagementwithmongo.security.entity.AuthRequest;
import com.ampada.taskmanagementwithmongo.security.util.JwtUtil;
import com.ampada.taskmanagementwithmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/signIn")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }


    @PostMapping("/signUp")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
       return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userDto));
    }


}