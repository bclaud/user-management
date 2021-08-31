package com.usermanagement.users.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private static List<User> userList = new ArrayList<>();

    Optional<User> findById(Long id){
        return userList.stream()
        .filter(user -> id == user.getId())
        .findFirst();
    }

    List<User> findAll(){
        return  userList;
    }

    static List<User> getUserList(){
        return  userList;
    }

    void save(User user){
        userList.add(user);
    }
}
