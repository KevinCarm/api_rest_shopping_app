package com.example.demo.controller;

import com.example.demo.implementation.ProductImplementation;
import com.example.demo.model.Products;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductImplementation implementation;

    public ProductController(ProductImplementation implementation) {
        this.implementation = implementation;
    }

    @GetMapping("products/getAll")
    public @ResponseBody List<Products> getAll() {
        return implementation.getAllProducts();
    }

    @GetMapping("products/getAllRecentlyByUser/{id}")
    public @ResponseBody List<Products> getAllRecentlyByUser(@PathVariable("id") long id) {
        return implementation.getAllRecentlyById(id);
    }

    @GetMapping("products/getBySearch/{search}")
    public List<Products> getBySearch(@PathVariable("search") String search) {
        return implementation.getBySearch(search);
    }

    @GetMapping("products/getNameBySearch/{search}")
    public List<Products> getNameBySearch(@PathVariable("search") String search) {
        return implementation.getNameBySearch(search);
    }

    @GetMapping("products/getOne/{id}")
    public ResponseEntity<Products> getOneById(@PathVariable("id") long id) {
        return new ResponseEntity<>(
                implementation.getOneById(id),
                HttpStatus.OK
        );
    }

    @PostMapping("products/save")
    public ResponseEntity<Products> save(@RequestBody Products product) {
        return new ResponseEntity<>(
                implementation.save(product),
                HttpStatus.OK
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Products> update(
            @PathVariable("id") long id,
            @RequestBody Products product
    ) {
        return new ResponseEntity<>(
                implementation.update(product, id),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        implementation.delete(id);
        return new ResponseEntity<>(
                "Product deleted successfully",
                HttpStatus.OK
        );
    }
}
