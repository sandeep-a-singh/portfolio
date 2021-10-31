package com.sunny.portfolio.controller;

import com.sunny.portfolio.entity.UserEntity;
import com.sunny.portfolio.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserControllerTest {

    @Container
    MySQLContainer mySQLContainer = (MySQLContainer) new MySQLContainer("mysql:latest")
            .withDatabaseName("spring-reddit-test-db")
            .withUsername("testuser")
            .withPassword("pass");

    @Autowired
    private UserRepository userRepository;

    @Test
    void addNewUserTest()
    {
        UserEntity user = new UserEntity();
        user.setFirstName("Sunny");
        user.setLastName("Singh");
        user.setEmail("Sunny080593@gmail.com");
        UserEntity userSaved = userRepository.save(user);

        Assertions.assertNotNull(userSaved);
    }

}
