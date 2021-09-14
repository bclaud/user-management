package com.usermanagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.usermanagement.mapper.UserMapper;
import com.usermanagement.mapper.dto.UserDto;
import com.usermanagement.mapper.dto.UserRequestDto;
import com.usermanagement.model.User;
import com.usermanagement.repositories.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceTest {
    
    @Autowired
    private UserService service;

    @Autowired
    private UserMapper userMapper;

    @MockBean
    private UserRepository repository;

    @MockBean
    private UserDto userDto;

    @MockBean
    private UserRequestDto userRequestDto;

    @MockBean
    private User user;

    @Test
    public void findAll_ReturnListOfUsers() { 
        when(repository.findAll()).thenReturn(Stream.of(new User("test", "user"))
        .collect((Collectors.toList())));    

        assertEquals(1, service.findAll().size());
    }

    @Test
    public void insert_ValidUser_AddUser(){
        UserRequestDto userRequestDto = new UserRequestDto("test", "user", "test street");
        User user = userMapper.userRequestDtoToUser(userRequestDto);

        when(repository.save(user)).thenReturn(user);
        when(service.insert(userRequestDto)).thenReturn(new UserDto(user));

        assertEquals(user.getName(), service.insert(userRequestDto).getName());
    }

    @Test
    public void isDuplicated_SameNameAndSurname_true(){

        User user = new User("test", "user");

        when(repository.findAll()).thenReturn(Stream.of(new User("test", "user"))
        .collect(Collectors.toList()));

        assertTrue(service.isDuplicated(user));
    }

    @Test
    public void generateId_ReturnNotDuplicatedLongId(){
        
        when(repository.findAll()).thenReturn(Stream.of(new User(1L,"test","user"))
        .collect(Collectors.toList()));
        
        when(service.generateId()).thenReturn(30L);
    }

    @Test
    public void generatedSecurityCode_ReturnNotDuplicatedLongSecurityCode(){

        when(repository.findAll()).thenReturn(Stream.of(new User(1L,"test","user", 1000L))
        .collect(Collectors.toList()));

        when(service.generateSecurityCode()).thenReturn(1111L);
    }

    @Test
    public void findById_ReturnValidUserDto(){
        User user = new User(1L, "test", "test");
        user.setAddress("test address");
        user.setSecurityCode(1111L);
        UserDto userDto = userMapper.userToUserDto(user);

        when(repository.save(user)).thenReturn(user);
        when(service.findById(1L)).thenReturn(userDto);
        
        assertNotNull(userDto);
    }
}
