package com.usermanagement.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id){
        super("User not found. Id " + id);
    }
    
}
