package com.usermanagement.services;

import java.util.List;

import com.usermanagement.exceptions.DuplicatedInsertUserException;
import com.usermanagement.exceptions.UserNotFoundException;
import com.usermanagement.model.User;
import com.usermanagement.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public User insert(User user){
        
        if(isDuplicated(user)){
            throw new DuplicatedInsertUserException();
        }

        user.setId(generateId());
        user.setSecurityCode(generateSecurityCode());
        repository.save(user);
        return user;            
    }
    
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
    }
    
    public boolean isDuplicated(User user){
        
        return repository.findAll().stream()
            .anyMatch(u -> u.getName().equalsIgnoreCase(user.getName())
            && u.getSurname().equalsIgnoreCase(user.getSurname()));
    }
    
    public Long generateId(){
        final long minIdValue = 0L;
        final long maxIdValue = 50L;
        long generatedId = minIdValue + (long) (Math.random() * (maxIdValue - minIdValue));
        boolean duplicatedId = repository.findAll().stream()
        .anyMatch(u -> u.getId().equals(generatedId));
        if(duplicatedId){
            return generateId();
        }
        return generatedId;
    }

    public Long generateSecurityCode(){
        final long minIdValue = 1000L;
        final long maxIdValue = 9999L;
        return minIdValue + (long) (Math.random() * (maxIdValue - minIdValue));
    }
}