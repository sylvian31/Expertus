package com.expertus.expertusprojet.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expertus.expertusprojet.dao.ProductDaoInterface;
import com.expertus.expertusprojet.model.Product;

@RestController
public class ProductController {
	
	//create a instance
    @Autowired
    private ProductDaoInterface productDao;

	@RequestMapping(value="/Produits", method=RequestMethod.GET)
    public List<Product> listeProduits() {
        return productDao.findAll();
    }
	
	@GetMapping(value="/Produits/{id}")
	public Product afficherUnProduit(@PathVariable int id) {
	    return productDao.findById(id);
	}
}
