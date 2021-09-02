package com.usermanagement.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.usermanagements.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();

    public Optional<User> findById(Long id){
        return userList.stream()
        .filter(user -> id == user.getId())
        .findFirst();
    }

    public List<User> findAll(){
        return  userList;
    }

    public void save(User user){
        userList.add(user);
    }
}
