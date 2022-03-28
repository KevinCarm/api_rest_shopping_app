package com.example.demo.implementation;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Products;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImplementation implements ProductService {
    private final ProductRepository repository;

    public ProductImplementation(ProductRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public List<Products> getAllProducts() {
        ArrayList<Products> result = new ArrayList<>();
        repository.getAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Products> getBySearch(String search) {
        List<Products> result = new ArrayList<>();
        repository.getBySearch(search).forEach(result::add);
        return result;
    }

    @Override
    public Products getOneById(long id) {
        return repository.getOneById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product",
                        "Id",
                        id));
    }

    @Override
    public Products save(Products product) {
        return repository.save(product);
    }

    @Override
    public void delete(long id) {
        Products existing = repository.getOneById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product",
                        "Id",
                        id));
        if (existing != null) {
            repository.deleteById(id);
        }
    }

    @Override
    public Products update(Products product, long id) {
        Products existing = repository.getOneById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product",
                        "Id",
                        id));
        existing.setProduct_name(product.getProduct_name());
        existing.setProduct_description(product.getProduct_description());
        existing.setProduct_discount(product.getProduct_discount());
        existing.setProduct_price(product.getProduct_price());
        existing.setId_user(product.getId_user());
        existing.setProduct_image(product.getProduct_image());
        existing.setOne_star(product.getOne_star());
        existing.setTwo_star(product.getTwo_star());
        existing.setThree_star(product.getThree_star());
        existing.setFour_star(product.getFour_star());
        existing.setFive_star(product.getFive_star());
        return repository.save(existing);
    }

    @Override
    public List<Products> getNameBySearch(String search) {
        List<Products> list = new ArrayList<>();
        repository.getNameProductBySearch(search).forEach(list::add);
        return list;
    }

    @Override
    public List<Products> getAllRecentlyById(long id) {
        List<Products> list = new ArrayList<>();
        repository.getAllRecentlyById(id).forEach(list::add);
        return list;
    }
}
