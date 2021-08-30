package com.usermanagement.users.restservice;

import java.util.Random;

import com.usermanagement.users.models.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Random generator = new Random(1);
    
    @PostMapping("/users")
    public User user(@RequestParam(value = "name") String name,@RequestParam(value = "surname") String surname, @RequestParam(value = "address", defaultValue = "") String address){
        if(address != ""){
            return new User(generator.nextInt(10), name, surname, address);
        }else{
            return new User(generator.nextInt(10), name, surname);
        }
    }

}
