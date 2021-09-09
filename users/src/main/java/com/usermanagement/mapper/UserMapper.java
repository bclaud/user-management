package com.usermanagement.mapper;

import com.usermanagement.mapper.dto.UserDto;
import com.usermanagement.mapper.dto.UserRequestDto;
import com.usermanagement.model.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDto userToUserDto(User user);

    User userRequestDtoToUser(UserRequestDto userRequestDto);
}
