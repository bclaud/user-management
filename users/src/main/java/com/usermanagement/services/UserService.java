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
            .allMatch(u -> u.getName().toLowerCase() == user.getName().toLowerCase()
            && u.getSurname().toLowerCase() == user.getSurname().toLowerCase());
    }
    
    public Long generateId(){
        final long minIdValue = 1L;
        final long maxIdValue = 10L;
        return minIdValue + (long) (Math.random() * (maxIdValue - minIdValue));
    }
}
