package com.expertus.microServiceProduct.service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expertus.microServiceProduct.bean.Product;
import com.expertus.microServiceProduct.config.GlobalPropertiesPathConfig;
import com.expertus.microServiceProduct.exception.ProductNotFoundException;
import com.expertus.microServiceProduct.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	/** The product repository */
	@Autowired
	private ProductRepository productRepository;

	/**
	 * The Rest template
	 */
	private @Autowired RestTemplate restTemplate;

	@Override
	public List<Product> findAll() throws InterruptedException, ExecutionException {
		List<Product> lProducts = productRepository.findAll();
		List<CompletableFuture<Product>> lProductsWithImageContentFutures = new ArrayList<>();
		// Start the clock
		long start = System.currentTimeMillis();
		for (Product product : lProducts) {
			lProductsWithImageContentFutures.add(updateProductWithImageAsync(product));
		}

		// Create a combined Future using allOf()
		CompletableFuture<Void> lAllFutures = CompletableFuture.allOf(lProductsWithImageContentFutures
				.toArray(new CompletableFuture[lProductsWithImageContentFutures.size()]));

		// When all the Futures are completed, call `future.join()` to get their results
		// and collect the results in a list -
		CompletableFuture<List<Product>> lResourceProductContentsFuture = lAllFutures.thenApply(v -> {
			return lProductsWithImageContentFutures.stream()
					.map(lProductsWithImageContentFuture -> lProductsWithImageContentFuture.join())
					.collect(Collectors.toList());
		});

		return lResourceProductContentsFuture.get();
	}

	@Override
	public Product findById(int pId) {
		Product lProduct = productRepository.findById(pId).orElseThrow(() -> new ProductNotFoundException(pId));

		return updateProductWithImage(lProduct);
	}

	@Override
	public Product save(Product pProduct) throws URISyntaxException {
		Product lProduct = productRepository.save(pProduct);
		for (Object lObject : lProduct.getImage()) {
			saveImage(lProduct, lObject);
		}
		return lProduct;
	}

	@Override
	public void deleteById(int pId) {
		deleteImage(pId);
		productRepository.deleteById(pId);
	}

	@Override
	public Product update(Product pNewProduct, int pId) throws URISyntaxException {
		Product lUpdatedProduct = productRepository.findById(pId).map(product -> {
			product.setName(pNewProduct.getName());
			product.setPrice(pNewProduct.getPrice());
			return productRepository.save(product);
		}).orElseGet(() -> {
			pNewProduct.setId(pId);
			return productRepository.save(pNewProduct);
		});

		return lUpdatedProduct;
	}

	/* -------------- Method to image -------------- */

	/**
	 * Create a Product with a image from to image service to way asynchrone
	 * 
	 * @param pProduct
	 * @return a CompletableFuture to Resources to product
	 * @throws InterruptedException
	 */
	@Async
	private CompletableFuture<Product> updateProductWithImageAsync(Product pProduct) throws InterruptedException {
		pProduct.setImage(getImageFromImageService(pProduct));
		return CompletableFuture.completedFuture(pProduct);
	}

	/**
	 * Create a Product with a image from to image service
	 * 
	 * @param pProduct
	 * @return
	 */
	private Product updateProductWithImage(Product pProduct) {
		pProduct.setImage(getImageFromImageService(pProduct));
		return pProduct;
	}

	/**
	 * Request HTTP toward image service
	 * 
	 * @param pProduct
	 * @return restTemplate Object
	 */
	private List<Object> getImageFromImageService(Product pProduct) {
		ResponseEntity<List> response = restTemplate
				.getForEntity(GlobalPropertiesPathConfig.URL_IMAGE_SERVICE_ID_PRODUCT + pProduct.getId(), List.class);
		return response.getBody();
	}

	private void saveImage(Product lProduct, Object pImage) {
		restTemplate.postForObject(GlobalPropertiesPathConfig.URL_IMAGE_SERVICE_ADD + "/" + lProduct.getId(), pImage,
				Object.class);
	}

	private void deleteImage(int pIdProduct) {
		restTemplate.delete(GlobalPropertiesPathConfig.URL_IMAGE_SERVICE_DELETE + pIdProduct);
	}
}
