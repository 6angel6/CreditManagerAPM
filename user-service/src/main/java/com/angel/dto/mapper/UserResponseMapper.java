package com.angel.dto.mapper;

import com.angel.dto.response.UserResponse;
import com.angel.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  UserResponseMapper {

	User toEntity(UserResponse dto);

	UserResponse toDto(User entity);

}
