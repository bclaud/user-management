package com.usermanagement.users.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.usermanagement.users.models.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Random generator = new Random(1);
    List<User> list = new ArrayList<>();
    
    
    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user){
        boolean duplicated = false;

        for(User u : list){
            if(u.equals(user)){
                duplicated = true;
            }
        }

        if(!duplicated){
            int id = generator.nextInt(10);
            user.setId(id);
            list.add(user);
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>("Duplicated request", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> allUsers(){
        return ResponseEntity.ok(list);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> userById(@PathVariable int id){
        try{
            User userById = list.stream()
            .filter(p -> p.getId() == id)
            .collect(Collectors.toList())
            .get(0);
            return ResponseEntity.ok(userById);
        }catch (RuntimeException e){
            return new ResponseEntity<>("User not found for ID " + id, HttpStatus.NOT_FOUND);
        }
    }
    

}
