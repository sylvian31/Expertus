package com.expertus.expertusprojet.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.expertus.expertusprojet.bean.Product;


public interface IProductService {

    public ResponseEntity<Product[]> findAll();
    
    public Product findById(Long id);

    public ResponseEntity<Product> add( Product product);

    public Product update(Long id, Product product);

    public void delete(Long id);
}
