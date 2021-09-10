package com.usermanagement.mapper.dto;

import com.usermanagement.model.User;

import io.swagger.annotations.ApiModelProperty;

public class UserRequestDto {

    @ApiModelProperty(notes = "Can't be equals another Users name and surname", required = true)
    private String name;
    @ApiModelProperty(notes = "Can't be equals another Users name and surname", required = true)
    private String surname;
    @ApiModelProperty(required = true)
    private String address;

    public UserRequestDto(){

    }

    public UserRequestDto(User user){

    }
    
    public UserRequestDto(String name, String surname, String address) {
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
