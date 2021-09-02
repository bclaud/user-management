package com.usermanagement.users.errorhandler;

import com.usermanagement.users.services.exceptions.DuplicatedInsertUserException;
import com.usermanagement.users.services.exceptions.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserServiceAdvice {
    
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UserNotFoundHandler(UserNotFoundException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DuplicatedInsertUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String InvalidUserHandler(DuplicatedInsertUserException e){
        return e.getMessage();
    }
}
