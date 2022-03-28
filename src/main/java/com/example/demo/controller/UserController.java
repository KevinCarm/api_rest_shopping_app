package com.example.demo.controller;

import com.example.demo.implementation.UserImplementation;
import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserImplementation implementation;

    public UserController(UserImplementation implementation) {
        this.implementation = implementation;
    }

    @GetMapping(value = "/users/login", params = {"email", "password"})
    public ResponseEntity<User> login(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password) {
        return new ResponseEntity<>(
                implementation.login(email, password),
                HttpStatus.OK
        );
    }

    @PostMapping(value = "users/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(
                implementation.save(user),
                HttpStatus.OK
        );
    }
}
