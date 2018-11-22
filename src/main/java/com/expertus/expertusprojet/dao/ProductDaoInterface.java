package com.expertus.expertusprojet.dao;


import java.util.List;

import com.expertus.expertusprojet.model.Product;

public interface ProductDaoInterface {

	/**
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	 * Look to convention name
	 */
	
    public List<Product> findAll();
    public Product findById(int pId);
    public void save(Product pProduct);
}
