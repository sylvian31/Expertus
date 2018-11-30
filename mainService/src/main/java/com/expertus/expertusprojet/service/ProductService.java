package com.expertus.expertusprojet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.config.GlobalPropertiesPath;

@Service
public class ProductService implements IProductService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public ResponseEntity<Product[]> findAll() {
		return restTemplate.getForEntity(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_GET, Product[].class);
	}

	@Override
	public Product findById(Long pId) {
		return restTemplate.getForObject(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_GET + pId, Product.class);
	}

	@Override
	public ResponseEntity<Product> add(Product product) {
		return restTemplate.postForEntity(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_ADD, product, Product.class);
	}

	@Override
	public Product update(Long pId, Product product) {
		return null;
//		return restTemplate.getForObject(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_UPDATE + pId, Product.class);
	}

	@Override
	public void delete(Long pId) {
		restTemplate.delete(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_DELETE + pId);
	}

}
