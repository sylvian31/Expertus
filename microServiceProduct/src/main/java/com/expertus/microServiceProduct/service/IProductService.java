package com.expertus.microServiceProduct.service;

import java.util.List;
import java.util.Optional;

import com.expertus.microServiceProduct.bean.Product;

public interface IProductService {

	public List<Product> findAll();
	
	public Optional<Product> findById(int id);
	
	public List<Product> findByNameStartsWithIgnoreCase(String name);

	public void deleteById(int id);

	public Product save(Product product);
	
}
