package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "users")
public class User implements Serializable {

    @Id
    private long id_user;

    @Column
    private String user_name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String image_path;

}