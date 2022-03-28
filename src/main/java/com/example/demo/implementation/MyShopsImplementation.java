package com.example.demo.implementation;

import com.example.demo.model.MyShops;
import com.example.demo.repository.MyShopsRepository;
import com.example.demo.service.MyShopsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyShopsImplementation implements MyShopsService {
    private MyShopsRepository repository;

    public MyShopsImplementation(MyShopsRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public List<MyShops> getMyShops(long id) {
        List<MyShops> list = new ArrayList<>();
        repository.getMyShops(id).forEach(list::add);
        return list;
    }
}
