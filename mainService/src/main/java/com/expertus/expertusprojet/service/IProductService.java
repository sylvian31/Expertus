package com.expertus.expertusprojet.service;

import java.util.Collection;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.expertus.expertusprojet.bean.Product;


public interface IProductService {

    @GetMapping(value = "/products")
    public ResponseEntity<Product[]> findAll();
    
    @GetMapping(value = "/products/{id}")
    public Product findById(@PathVariable("id") Long id);

    @PostMapping(value = "/products/add")
    public Product add(@RequestBody Product product);

    @PutMapping(value = "/products/{id}")
    public Product update(@PathVariable("id") Long id, @RequestBody Product product);

    @DeleteMapping(value = "/products/{id}")
    public void delete(@PathVariable("id") Long id);
}
