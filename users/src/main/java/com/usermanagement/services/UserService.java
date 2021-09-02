package com.usermanagement.services;

import java.util.List;

import com.usermanagement.repositories.UserRepository;
import com.usermanagement.services.exceptions.DuplicatedInsertUserException;
import com.usermanagement.services.exceptions.UserNotFoundException;
import com.usermanagements.model.User;

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
        
        return repository.findAll().stream()
            .noneMatch(u -> u.getName().equalsIgnoreCase(user.getName())
            && u.getSurname().equalsIgnoreCase(user.getSurname()));
    }
    
    public Long generateId(){
        final long minIdValue = 1L;
        final long maxIdValue = 10L;
        return minIdValue + (long) (Math.random() * (maxIdValue - minIdValue));
    }
}