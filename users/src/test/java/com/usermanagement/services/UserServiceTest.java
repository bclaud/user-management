package com.usermanagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.usermanagement.mapper.UserMapper;
import com.usermanagement.mapper.dto.UserDto;
import com.usermanagement.mapper.dto.UserRequestDto;
import com.usermanagement.model.User;
import com.usermanagement.repositories.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks 
    UserService service;
    
    @Mock
    UserRepository repository;

    @Mock
    UserMapper mapper;

    User user = new User();
    UserRequestDto userRequestDto = new UserRequestDto();
    UserDto userDto = new UserDto();

    @BeforeEach
    public void init(){
        user.setId(1L);
        user.setName("test");
        user.setSurname("test");
        user.setAddress("Test street");
        user.setSecurityCode(1111L);

        userRequestDto.setName("test");
        userRequestDto.setSurname("test");
        userRequestDto.setAddress("Test street");

        userDto.setId(1L);
        userDto.setName("test");
        userDto.setSurname("test");
    }

    @Test
    public void insert_ReturnUserDto() {

        when(repository.save(user)).thenReturn(user);
        when(mapper.userRequestDtoToUser(userRequestDto)).thenReturn(user);
        when(mapper.userToUserDto(user)).thenReturn(userDto);
        when(service.insert(userRequestDto)).thenReturn(userDto);

        assertEquals(user.getName(), service.insert(userRequestDto).getName());
    }
    
    @Test
    public void findAll_ReturnListOfUsers() { 
        when(repository.findAll()).thenReturn(List.of(user));    
        
        assertEquals(1, service.findAll().size());
    }
    
    @Test
    public void findById_ReturnUserDto_notNull() {

        when(repository.findById(1L)).thenReturn(Optional.of(user));
        when(mapper.userToUserDto(user)).thenReturn(userDto);        
        when(service.findById(1L)).thenReturn(userDto);

        assertNotNull(service.findById(1L));
    }

    @Test
    public void isDuplicated_SameNameAndSurname_true(){

        when(repository.findAll()).thenReturn(List.of(user));

        assertTrue(service.isDuplicated(user));
    }

    @Test
    public void generateId_ReturnLongBetweenMinAndMax_true() {
        
        when(repository.findAll()).thenReturn(List.of(user));
        final long minIdValue = 0L;
        final long maxIdValue = 50L;
        Long id = service.generateId();
        boolean validId = false;
        if(id >= minIdValue && id <= maxIdValue){
            validId = true;
        }
        
        assertTrue(validId);
    }

    @Test
    public void generateSecurityCodeReturnLongBetweenMinAndMax_true(){
        when(repository.findAll()).thenReturn(List.of(user));

        final long minSecurityCodeValue = 1000L;
        final long maxSecurityCodeValue = 9999L;
        Long id = service.generateSecurityCode();
        boolean validSecurityCode = false;
        if(id >= minSecurityCodeValue && id <= maxSecurityCodeValue){
            validSecurityCode = true;
        }
        
        assertTrue(validSecurityCode);
    }
}
