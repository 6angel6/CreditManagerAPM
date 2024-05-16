package com.angel.dto.mapper;

import com.angel.dto.request.UserRequest;
import com.angel.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
@Mapping(target = "firstName", expression = "java(org.apache.commons.text.WordUtils.capitalizeFully(dto.getFirstName()))")
@Mapping(target = "lastName", expression = "java(org.apache.commons.text.WordUtils.capitalizeFully(dto.getLastName()))")
@Mapping(target = "middleName", expression = "java(org.apache.commons.text.WordUtils.capitalizeFully(dto.getMiddleName()))")
@Mapping(source = "address", target = "address")
@Mapping(source = "employmentInfo", target = "employmentInfo")
@Mapping(source = "phoneNumber", target = "phoneNumber")
User toEntity(UserRequest dto);


UserRequest toDto(User entity);
}
