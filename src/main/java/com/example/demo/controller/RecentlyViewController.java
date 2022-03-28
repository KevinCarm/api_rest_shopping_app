package com.example.demo.controller;

import com.example.demo.implementation.RecentlyViewImplementation;
import com.example.demo.model.RecentlyView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecentlyViewController {
    private final RecentlyViewImplementation implementation;

    public RecentlyViewController(RecentlyViewImplementation implementation) {
        super();
        this.implementation = implementation;
    }

    @PostMapping("/recently/save/{id_user}/{id_product}")
    public ResponseEntity<RecentlyView> saveRecently(@PathVariable("id_user") long id_user, @PathVariable("id_product") long id_product) {
        try {
            return new ResponseEntity<>(
                    implementation.saveRecently(id_user, id_product),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new RecentlyView(0, 0),
                    HttpStatus.OK
            );
        }
    }

}
