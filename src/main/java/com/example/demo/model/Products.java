package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "products")
public class Products implements Serializable {

    @Id
    private long id_product;

    @Column
    private String product_name;

    @Column
    private double product_price;

    @Column
    private String product_description;

    @Column
    private float product_discount;

    @Column
    private String product_image;

    @Column
    private long id_user;

    @Column
    private long one_star;

    @Column
    private long two_star;

    @Column
    private long three_star;

    @Column
    private long four_star;

    @Column
    private long five_star;

}
