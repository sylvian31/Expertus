package com.expertus.microServiceProduct.service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import com.expertus.microServiceProduct.bean.Product;

public interface IProductService {
	
	/**
	 * Find all Product in the BDD 
	 * @return list Product
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public List<Product> findAll() throws InterruptedException, ExecutionException;

	/**
	 * Find a Product by ID in the BDD
	 * @param id
	 * @return a Product found
	 */
	public Product findById(int id);

	/**
	 * Add a new Product in the BDD
	 * @param product
	 * @return
	 * @throws URISyntaxException
	 */
	public Product save(Product product) throws URISyntaxException;

	/**
	 * Delete a Product by ID in the BDD
	 * @param id
	 * @return ResponseEntity without content
	 */
	public void deleteById(int id);

	/**
	 * Update a product by id in the BDD
	 * @param product
	 * @param id
	 * @return Updated Product
	 * @throws URISyntaxException
	 */
	public Product update(Product product) throws URISyntaxException;

}
