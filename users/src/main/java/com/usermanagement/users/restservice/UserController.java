package com.usermanagement.users.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.usermanagement.users.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Random generator = new Random(1);
    List<User> list = new ArrayList<>();
    
    @PostMapping("/users") //Request estao no head, passar para o body
    public User addUser(@RequestParam(value = "name") String name,@RequestParam(value = "surname") String surname, @RequestParam(value = "address", defaultValue = "") String address){
        if(address != ""){
            User u = new User(generator.nextInt(10), name, surname, address);
            list.add(u);
            return u;
        }else{
            User u = new User(generator.nextInt(10), name, surname);
            list.add(u);
            return u;
        }
    }

    @GetMapping("/users")
    public List<User> allUsers(){
        return list;
    }

    @GetMapping("/users/{id}")
    public <list>User userById(@PathVariable int id){

        User userById = list.stream()
        .filter(p -> p.getId() == id)
        .collect(Collectors.toList())
        .get(0);
        return userById;
    }
    

}
