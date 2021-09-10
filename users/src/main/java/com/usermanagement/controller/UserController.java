package com.usermanagement.controller;

import java.util.List;

import com.usermanagement.mapper.dto.UserDto;
import com.usermanagement.mapper.dto.UserRequestDto;
import com.usermanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/v1/users")
@Api(value = "API REST Users")
public class UserController {

    @Autowired
    private UserService service;
    
    @PostMapping
    @ApiOperation(value = "Add new User")
    public ResponseEntity<UserDto> addUser(@RequestBody UserRequestDto user){
        return ResponseEntity.ok(service.insert(user));
    }

    @GetMapping
    @ApiOperation(value = "Return all users")
    public ResponseEntity<List<UserDto>> allUsers(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Search user by ID", notes = "You can search any User by ID")
    @ApiResponses({
        @ApiResponse(code = 404, message = "User not Found")
    })
    public UserDto userById(@PathVariable long id){
        return service.findById(id);
    }
}
