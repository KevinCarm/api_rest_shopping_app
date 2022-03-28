package com.example.demo.repository;

import com.example.demo.model.MyShops;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MyShopsRepository extends CrudRepository<MyShops, Long> {

    @Query(value = "CALL get_my_shops (:myId);", nativeQuery = true)
    Iterable<MyShops> getMyShops(@Param("myId") long myId);
}
