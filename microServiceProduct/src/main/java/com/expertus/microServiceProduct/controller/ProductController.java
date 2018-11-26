package com.expertus.microServiceProduct.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expertus.microServiceProduct.GlobalPropertiesPath;
import com.expertus.microServiceProduct.bean.Product;
import com.expertus.microServiceProduct.service.IProductService;

@RestController
public class ProductController {

	/**
	 * The Environment
	 */
	private @Autowired Environment env;

	/** The product service */
	private final IProductService productService;

	/**
	 * Constructor
	 * 
	 * @param pProductService
	 */
	public ProductController(IProductService pProductService) {
		super();
		this.productService = pProductService;
	}

	/* -------------- Get -------------- */

	/**
	 * Show home
	 * 
	 * @return micro service name
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_HOME_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String showHome() {
		return "Hello from Product Service running at port: " + env.getProperty("local.server.port");
	}

	/**
	 * Get all product
	 * 
	 * @return list Product
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_ALL_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<Resource<Product>> all() {
		return productService.findAll();
	}

	/**
	 * Get Product by id
	 * 
	 * @param id
	 * @return a product
	 */
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_ID_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Product> one(@PathVariable int id) {
		return productService.findById(id);
	}

	/* -------------- Post -------------- */

	/**
	 * Add a new Product
	 * 
	 * @param product
	 * @return Product
	 * @throws URISyntaxException
	 */
	@PostMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_ADD_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> newProduct(@RequestBody Product product) throws URISyntaxException {
		return productService.save(product);
	}

	/* -------------- Put -------------- */

	/**
	 * Update a Order
	 * 
	 * @param newProduct
	 * @param id
	 * @return the update Order
	 * @throws URISyntaxException
	 */
	@PutMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_PUT_PATH
			+ "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> replaceProduct(@RequestBody Product newProduct, @PathVariable int id)
			throws URISyntaxException {
		return productService.update(newProduct, id);
	}

	/* -------------- Delete -------------- */

	/**
	 * Delete a Order
	 * 
	 * @param id
	 * @return ResponseEntity without content
	 */
	@DeleteMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_DELETE_PATH + "}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		return productService.deleteById(id);
	}

}
