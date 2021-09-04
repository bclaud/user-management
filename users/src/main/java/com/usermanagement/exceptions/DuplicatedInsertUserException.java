package com.usermanagement.exceptions;

public class DuplicatedInsertUserException extends RuntimeException {
 
    public DuplicatedInsertUserException(){
        super("Duplicated user");
    }
}
