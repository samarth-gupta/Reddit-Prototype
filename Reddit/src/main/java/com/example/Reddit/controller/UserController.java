package com.example.Reddit.controller;

import com.example.Reddit.model.User;
import com.example.Reddit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get all
    @GetMapping
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    // get by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long UserId){
        return this.userRepository.findById(UserId)
                .orElseThrow( () -> new RuntimeException("User not found with id : "+UserId));
    }


}
