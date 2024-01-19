package com.ms.service;

import com.ms.model.Product;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServiceProduct {

    private final List<Product> products;

    public ServiceProduct(){
        products =  List.of(
                new Product(0,"Televisão",2000,10,true),
                new Product(0,"Geladeira",1000,5,true),
                new Product(0,"Fogão",500,2,true));

    }

    public List<Product> getAll(){
        return this.products;
    }
}
