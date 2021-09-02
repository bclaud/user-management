package com.usermanagement.services.exceptions;

public class DuplicatedInsertUserException extends RuntimeException {
 
    public DuplicatedInsertUserException(){
        super("Duplicated user");
    }
}
