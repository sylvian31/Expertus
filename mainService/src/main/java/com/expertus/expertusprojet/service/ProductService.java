package com.expertus.expertusprojet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.config.GlobalPropertiesPath;

@Service
public class ProductService implements IProductService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The rest template */
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public Product[] findAll() {
		return restTemplate.getForEntity(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_GET, Product[].class).getBody();
	}

	@Override
	public Product findById(Long pId) {
		return restTemplate.getForObject(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_GET + pId, Product.class);
	}

	@Override
	public Product add(Product pProduct) {
		return restTemplate.postForEntity(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_ADD, pProduct, Product.class)
				.getBody();
	}

	@Override
	public void update(Product pProduct) {
		restTemplate.put(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_UPDATE, pProduct);
	}

	@Override
	public void delete(Long pId) {
		restTemplate.delete(GlobalPropertiesPath.URL_PRODUCT_MICRO_SERVICE_DELETE + pId);
	}

}
