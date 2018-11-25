package com.expertus.microServiceProduct.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expertus.microServiceProduct.service.IProductService;
import com.expertus.microServiceProduct.bean.Product;

@RestController
public class ProductController {
	
    @Autowired
    IProductService productService;

	@RequestMapping(value="/Produits", method=RequestMethod.GET)
    public List<Product> listeProduits() {
        return productService.findAll();
    }
	
	@GetMapping(value="/Produits/{id}")
	public Optional<Product> afficherUnProduit(@PathVariable int id) {
	    return productService.findById(id);
	}
}
