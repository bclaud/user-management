package com.usermanagement.controller;

import java.util.List;

import com.usermanagement.services.UserService;
import com.usermanagements.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService service;
    
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(service.insert(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> allUsers(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public User userById(@PathVariable long id){
        return service.findById(id);
    }
}
