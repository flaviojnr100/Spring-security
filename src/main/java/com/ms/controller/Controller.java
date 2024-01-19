package com.ms.controller;

import com.ms.model.Product;
import com.ms.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(path = "/")
public class Controller {

    @Autowired
    private  ServiceProduct serviceProduct;



    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.status(200).body(this.serviceProduct.getAll());
    }

    @GetMapping(path = "/home")
    public ResponseEntity<String> home(){
        return ResponseEntity.status(200).body("Home");
    }
}
