package com.usermanagement.users.services;

import java.util.List;

import com.usermanagement.users.model.User;
import com.usermanagement.users.repositories.UserRepository;
import com.usermanagement.users.services.exceptions.DuplicatedInsertUserException;
import com.usermanagement.users.services.exceptions.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public void insert(User user){

        if(isNotDuplicated(user)){
            user.setId(generateId());
            repository.save(user);            
        }else{
            throw new DuplicatedInsertUserException();
        }    
    }
    
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
    }
    
    public boolean isNotDuplicated(User user){
        boolean isNotDuplicated = true;
    
        for (User u : repository.findAll()){
            if(user.getName().equalsIgnoreCase(u.getName())
            && user.getSurname().equalsIgnoreCase(u.getSurname())){
                isNotDuplicated = false;
            }
        }
        
        return isNotDuplicated;
    }
    
    public Long generateId(){
        final long minIdValue = 1L;
        final long maxIdValue = 10L;
        return minIdValue + (long) (Math.random() * (maxIdValue - minIdValue));
    }
}
