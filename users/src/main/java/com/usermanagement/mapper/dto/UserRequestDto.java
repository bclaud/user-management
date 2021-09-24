package com.usermanagement.mapper.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserRequestDto {

    @ApiModelProperty(value = "first name of the user", example = "Vatsal") private String name;
    @ApiModelProperty(value = "Surname name of the user", example = "Sheth") private String surname;
    @ApiModelProperty(value = "Address of the user", example = "5th Avenue, New York") private String address;

}
