package com.usermanagement;

import com.usermanagement.model.User;

public class UserInsertDTO {
    
    private String name;
    private String surname;
    private String address;

    public UserInsertDTO(){

    }

    public UserInsertDTO(User user){

    }
    
    public UserInsertDTO(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }        
}
