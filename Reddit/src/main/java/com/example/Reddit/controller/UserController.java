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
    public User getUserById(@PathVariable(value = "id") Long userId){
        return this.userRepository.findById(userId)
                .orElseThrow( () -> new RuntimeException("User not found with id : "+userId));
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @GetMapping("/test")
    public String test(){
        return "User api endpoint works!";
    }

}
