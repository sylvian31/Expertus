package com.expertus.expertusprojet.service;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expertus.expertusprojet.GlobalPropertiesPath;
import com.expertus.expertusprojet.bean.Product;

@Service
public class ProductService implements IProductService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public ResponseEntity<Product[]> findAll() {
		ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE, Product[].class);
		return responseEntity;
	}

	@Override
	public Product findById(Long pId) {
		return restTemplate.getForObject(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE + pId, Product.class);
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
