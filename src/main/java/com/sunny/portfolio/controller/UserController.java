package com.sunny.portfolio.controller;

import com.sunny.portfolio.entity.UserEntity;
import com.sunny.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String timeStamp()
    {
        return LocalDateTime.now().toString();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {

        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userRepository.save(user);
        return "User Created";
    }

}