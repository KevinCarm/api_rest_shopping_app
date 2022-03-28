package com.example.demo.controller;

import com.example.demo.implementation.MyShopsImplementation;
import com.example.demo.model.MyShops;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyShopsController {
    private final MyShopsImplementation implementation;

    public MyShopsController(MyShopsImplementation implementation) {
        super();
        this.implementation = implementation;
    }

    @GetMapping("/shopping/myshops/{id}")
    public List<MyShops> getMyShops(@PathVariable("id") long id) {
        return implementation.getMyShops(id);
    }
}
