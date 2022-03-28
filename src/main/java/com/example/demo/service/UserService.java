package com.example.demo.service;


import com.example.demo.model.User;

public interface UserService {

    User login(String email, String password);

    User save(User user);

    void delete(long id);

    User update(User user, long id);
}
