package com.usermanagement.mapper;

import com.usermanagement.mapper.dto.UserDto;
import com.usermanagement.mapper.dto.UserRequestDto;
import com.usermanagement.model.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    public UserDto userToUserDto(User user);

    public User userRequestDtoToUser(UserRequestDto userRequestDto);

    public UserRequestDto userToUserRequestDto(User user);
}
