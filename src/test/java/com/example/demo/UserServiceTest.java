package com.example.demo;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserRepository repo;
    private UserService service;

    @BeforeEach
    void setup() {
        repo = new UserRepository();
        var mapper = Mappers.getMapper(UserMapper.class);
        service = new UserService(repo, mapper);
        repo.clear();
    }

    @Test
    void createAndFetchUser() {
        UserCreateDto dto = new UserCreateDto();
        dto.setFirstName("Test");
        dto.setLastName("User");
        dto.setEmail("test@ex.com");
        dto.setBirthDate("2000-01-01");

        UserDto created = service.create(dto);
        assertEquals("Test User", created.getFullName());
        assertEquals("test@ex.com", created.getEmailAddress());
        assertEquals("ACTIVE", created.getStatus());

        List<UserDto> all = service.getAll();
        assertEquals(1, all.size());
    }
}
