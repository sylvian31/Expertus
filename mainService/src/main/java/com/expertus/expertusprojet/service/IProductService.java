package com.expertus.expertusprojet.service;

import com.expertus.expertusprojet.bean.Product;

public interface IProductService {

	/**
	 * Find all product
	 * 
	 * @return Array product
	 */
	public Product[] findAll();

	/**
	 * Find a product by his id
	 * 
	 * @param id
	 * @return product
	 */
	public Product findById(Long id);

	/**
	 * Add a product
	 * 
	 * @param product
	 * @return 
	 */
	public Product add(Product product);

	/**
	 * Update a product
	 * 
	 * @param product
	 */
	public void update(Product product);

	/**
	 * Delete a product by his id
	 * 
	 * @param id
	 */
	public void delete(Long id);
}
