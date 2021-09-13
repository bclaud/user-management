package com.usermanagement.errorhandler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.usermanagement.exceptions.DuplicatedInsertUserException;
import com.usermanagement.exceptions.StandardError;
import com.usermanagement.exceptions.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserServiceAdvice {

    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> UserNotFoundHandler(UserNotFoundException e, HttpServletRequest request){
        String error = "User not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error,
         e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DuplicatedInsertUserException.class)
    public ResponseEntity<StandardError> InvalidUserHandler(DuplicatedInsertUserException e, HttpServletRequest request){
        String error = "Duplicated User";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error,
         e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
