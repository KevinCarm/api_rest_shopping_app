package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(MyShopsKey.class)
public class MyShops {
    @Id
    private long id_user;
    @Id
    private long id_product;
}
