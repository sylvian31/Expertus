package com.expertus.microServiceProduct.service;

import java.util.List;
import java.util.Optional;

import com.expertus.microServiceProduct.bean.Product;

public interface IProductService {

	public List<Product> findAll();
	
	public Optional<Product> findById(int pId);
	
	public List<Product> findByNameStartsWithIgnoreCase(String name);

	public void delete(Product product);

	public void save(Product product);

}
