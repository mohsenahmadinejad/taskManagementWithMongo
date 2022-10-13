package com.ampada.taskmanagementwithmongo.service;


import com.ampada.taskmanagementwithmongo.dto.UserDto;
import com.ampada.taskmanagementwithmongo.model.User;
import com.ampada.taskmanagementwithmongo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {
        User user = new User();
        user=modelMapper.map(userDto,User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }


}
