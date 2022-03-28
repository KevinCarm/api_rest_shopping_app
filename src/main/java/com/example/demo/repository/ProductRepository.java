package com.example.demo.repository;

import com.example.demo.model.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Products, Long> {
    @Query(value = "SELECT * FROM products", nativeQuery = true)
    Iterable<Products> getAll();

    @Query(value = "SELECT * FROM products WHERE LOCATE(:search, product_name)", nativeQuery = true)
    Iterable<Products> getBySearch(@Param("search") String search);

    @Query(value = "SELECT * FROM products WHERE id_product = :id", nativeQuery = true)
    Optional<Products> getOneById(@Param("id") long id);

    @Query(value = "SELECT * FROM products WHERE LOCATE(:search, product_name)", nativeQuery = true)
    Iterable<Products> getNameProductBySearch(@Param("search") String search);

    @Query(value = "CALL getRecentlyByUser(:id);", nativeQuery = true)
    Iterable<Products> getAllRecentlyById(@Param("id") long id);

}
