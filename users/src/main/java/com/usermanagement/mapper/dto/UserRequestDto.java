package com.usermanagement.mapper.dto;

import com.usermanagement.model.User;

import io.swagger.annotations.ApiModelProperty;

public class UserRequestDto {

    @ApiModelProperty(value = "first name of the user", example = "Vatsal") private String name;
    @ApiModelProperty(value = "Surname name of the user", example = "Sheth") private String surname;
    @ApiModelProperty(value = "Addres of the user", example = "5th Avenue, New York") private String address;

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
