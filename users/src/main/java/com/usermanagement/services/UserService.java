package com.usermanagement.services;

import java.util.List;
import java.util.stream.Collectors;

import com.usermanagement.dto.UserDto;
import com.usermanagement.dto.UserRequestDto;
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
    
    public UserDto insert(UserRequestDto dto){
        User user = new User(dto.getName(), dto.getSurname(), dto.getAddress());
        if(isDuplicated(user)){
            throw new DuplicatedInsertUserException();
        }
        
        user.setId(generateId());
        user.setSecurityCode(generateSecurityCode());
        repository.save(user);
        return new UserDto(user);            
    }
    
    public List<UserDto> findAll(){
        List<User> list = repository.findAll();
        return list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
    }

    public UserDto findById(Long id){
        return repository.findById(id).stream().map(x -> new UserDto(x)).findFirst()
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