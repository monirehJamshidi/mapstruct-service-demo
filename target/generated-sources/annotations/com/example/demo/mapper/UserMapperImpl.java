package com.example.demo.mapper;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-05T15:14:14+0330",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    private final DateTimeFormatter dateTimeFormatter_dd_MM_yyyy_1156787200 = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setEmailAddress( user.getEmail() );
        if ( user.getBirthDate() != null ) {
            userDto.setBirthDateString( dateTimeFormatter_dd_MM_yyyy_1156787200.format( user.getBirthDate() ) );
        }

        userDto.setStatus( "ACTIVE" );
        userDto.setFullName( user.getFirstName() + " " + user.getLastName() );

        return userDto;
    }

    @Override
    public User toEntity(UserCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setBirthDate( LocalDate.parse(dto.getBirthDate()) );

        return user;
    }
}
