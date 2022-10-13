package com.ampada.taskmanagementwithmongo.service;


import com.ampada.taskmanagementwithmongo.model.User;
import com.ampada.taskmanagementwithmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(User user) {
        return userRepository.save(user).getId();
    }


}
