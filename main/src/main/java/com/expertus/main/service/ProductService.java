package com.expertus.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expertus.main.bean.Product;

@Service
public class ProductService implements IProductService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Product> findAll() {

		ResponseEntity<List<Product>> response = restTemplate.exchange("http://localhost:8100/products/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
				});
		return response.getBody();
	}

	@Override
	public Product findById(Long id) {

		return restTemplate.getForObject("http://localhost:8100/products/" + id, Product.class);
	}

	@Override
	public Product add(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
