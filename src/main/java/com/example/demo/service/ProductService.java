package com.example.demo.service;

import com.example.demo.model.Products;

import java.util.List;

public interface ProductService {
    List<Products> getAllProducts();

    List<Products> getBySearch(String search);

    Products getOneById(long id);

    Products save(Products product);

    void delete(long id);

    Products update(Products product, long id);

    List<Products> getNameBySearch(String search);

    List<Products> getAllRecentlyById(long id);

}
