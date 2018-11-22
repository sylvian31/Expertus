package com.expertus.expertusprojet.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.expertus.expertusprojet.model.Product;

@Repository
public class ProductDao implements ProductDaoInterface {
	
    public static List<Product>products=new ArrayList<>();
    
    static {
        products.add(new Product(1, new String("Ordinateur portable"), 350));
        products.add(new Product(2, new String("Aspirateur Robot"), 500)); 
        products.add(new Product(3, new String("Table de Ping Pong"), 750));
    }

	@Override
	public List<Product> findAll() {
		return products;
	}

	@Override
	public Product findById(int pId) {
		for(Product lProduct : products) {
			if(lProduct.getId() == pId) {
				return lProduct;
			}
		}
		return null;
	}

	@Override
	public void save(Product pProduct) {
		products.add(pProduct);		
	}

}
