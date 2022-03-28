package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(RecentlyViewKey.class)
public class RecentlyView {
    @Id
    private long id_user;
    @Id
    private long id_product;

    public RecentlyView(long id_user, long id_product) {
        this.id_user = id_user;
        this.id_product = id_product;
    }

    public RecentlyView() {}
}
