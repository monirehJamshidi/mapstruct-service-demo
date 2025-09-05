package com.example.demo.mapper;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Mapper(componentModel = "spring", imports = {LocalDate.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "emailAddress")
    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "fullName", expression = "java(user.getFirstName() + \" \" + user.getLastName())")
    @Mapping(source = "birthDate", target = "birthDateString", dateFormat = "dd-MM-yyyy")
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "birthDate", expression = "java(LocalDate.parse(dto.getBirthDate()))")
    User toEntity(UserCreateDto dto);
}
