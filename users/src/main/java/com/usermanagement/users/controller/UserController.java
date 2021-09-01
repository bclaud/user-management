package com.usermanagement.users.controller;

import java.util.List;

import com.usermanagement.users.model.User;
import com.usermanagement.users.repositories.UserRepository;
import com.usermanagement.users.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }
    
    @PostMapping("api/v1/users")
    public ResponseEntity<?> addUser(@RequestBody User user){

        if(UserService.isValidUser(user)){
            user.setId(UserService.generateId());
            repository.save(user);
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<String>("Duplicated request", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<List<User>> allUsers(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/api/v1/users/{id}")
    public User userById(@PathVariable long id){
        return repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
    }
}
