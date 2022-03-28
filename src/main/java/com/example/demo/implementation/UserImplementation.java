package com.example.demo.implementation;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImplementation implements UserService {
    private final UserRepository repository;

    public UserImplementation(UserRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public User login(String email, String password) {
        return repository.login(email, password)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Credentials",
                        "User",
                        ("Email: " + email + ", Password: " + password)
                ));
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(long id) {
        var user = repository.findById(id);
        if (user.isPresent())
            repository.deleteById(id);
    }

    @Override
    public User update(User user, long id) {
        var us = repository.findById(id);
        if (us.isPresent()) {
            User aux = us.get();
            aux.setEmail(user.getEmail());
            aux.setImage_path(user.getImage_path());
            aux.setPassword(user.getPassword());
            aux.setEmail(user.getEmail());
            return repository.save(aux);
        }
        return null;
    }
}
