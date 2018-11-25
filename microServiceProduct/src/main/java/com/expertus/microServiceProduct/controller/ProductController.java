package com.expertus.microServiceProduct.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private IProductService productService;

	/* ---------------------------- Route ---------------------------- */
	
	/* -------------- Home -------------- */

	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_HOME_PATH + "}")
	public String showHome() {
		return "Welcome to product api";
	}

	/* -------------- Get -------------- */ 
	
	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_ALL_PATH + "}")
	public List<Product> getProductList() {
		return productService.findAll();
	}

	@GetMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_ID_PATH + "}")
	public Optional<Product> getProductById(@PathVariable int id) {
		return productService.findById(id);
	}

	/* -------------- Post -------------- */ 
	
	@PostMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_ADD_PATH + "}")
	public void addImage(@RequestBody Product product) {
		productService.save(product);
	}
	
	/* -------------- Put -------------- */ 

	@PutMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_PUT_PATH + "}")
	Product replaceImage(@RequestBody Product pNewProduct, @PathVariable int id) {

		return productService.findById(id).map(product -> {
			product.setName(pNewProduct.getName());
			product.setPrice(pNewProduct.getPrice());
			return productService.save(product);
		}).orElseGet(() -> {
			pNewProduct.setId(id);
			return productService.save(pNewProduct);
		});
	}

	/* -------------- Delete -------------- */
	
	@DeleteMapping(value = "${" + GlobalPropertiesPath.ROUTE_PRODUCT_DELETE_PATH + "}")
	void deleteImage(@PathVariable int id) {
		productService.deleteById(id);
	}

}
