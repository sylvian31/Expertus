package com.expertus.microServiceProduct.service;

import java.net.URISyntaxException;
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
	public Resources<Resource<Product>> findAll() throws InterruptedException, ExecutionException;

	/**
	 * Find a Product by ID in the BDD
	 * @param id
	 * @return a Product found
	 */
	public Resource<Product> findById(int id);

	/**
	 * Add a new Product in the BDD
	 * @param product
	 * @return
	 * @throws URISyntaxException
	 */
	public ResponseEntity<?> save(Product product) throws URISyntaxException;

	/**
	 * Delete a Product by ID in the BDD
	 * @param id
	 * @return ResponseEntity without content
	 */
	public ResponseEntity<?> deleteById(int id);

	/**
	 * Update a product by id in the BDD
	 * @param product
	 * @param id
	 * @return Updated Product
	 * @throws URISyntaxException
	 */
	public ResponseEntity<?> update(Product product, int id) throws URISyntaxException;

}
