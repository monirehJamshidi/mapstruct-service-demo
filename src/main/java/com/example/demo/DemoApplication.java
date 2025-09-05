package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(UserRepository repo) {
        return args -> {
            repo.save(User.builder()
                    .firstName("Sara")
                    .lastName("Ahmadi")
                    .email("sara@example.com")
                    .birthDate(LocalDate.of(1995, 5, 20))
                    .build());
            repo.save(User.builder()
                    .firstName("Ali")
                    .lastName("Karimi")
                    .email("ali.karimi@example.com")
                    .birthDate(LocalDate.of(1990, 1, 10))
                    .build());
            repo.save(User.builder()
                    .firstName("Monire")
                    .lastName("Jamshidi")
                    .email("monire@example.com")
                    .birthDate(LocalDate.of(1994, 3, 21))
                    .build());
        };
    }
}
