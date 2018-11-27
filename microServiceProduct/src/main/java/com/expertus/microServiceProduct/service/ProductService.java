package com.expertus.microServiceProduct.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expertus.microServiceProduct.GlobalPropertiesPath;
import com.expertus.microServiceProduct.assembler.ProductResourceAssembler;
import com.expertus.microServiceProduct.bean.Product;
import com.expertus.microServiceProduct.bean.ProductWithImage;
import com.expertus.microServiceProduct.controller.ProductController;
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

	/** The Product resource assembler */
	@Autowired
	private ProductResourceAssembler productResourceAssembler;

	@Override
	public Resources<Resource<Product>> findAll() throws InterruptedException, ExecutionException {
		List<Product> lProducts = productRepository.findAll();
		List<CompletableFuture<Resource<Product>>> lProductsWithImageContentFutures = new ArrayList<>();
        // Start the clock
        long start = System.currentTimeMillis();
		for (Product product : lProducts) {
			lProductsWithImageContentFutures.add(createProductWithImageAsync(product));
		}

		// Create a combined Future using allOf()
		CompletableFuture<Void> lAllFutures = CompletableFuture.allOf(lProductsWithImageContentFutures
				.toArray(new CompletableFuture[lProductsWithImageContentFutures.size()]));

		// When all the Futures are completed, call `future.join()` to get their results
		// and collect the results in a list -
		CompletableFuture<List<Resource<Product>>> lResourceProductContentsFuture = lAllFutures.thenApply(v -> {
			return lProductsWithImageContentFutures.stream()
					.map(lProductsWithImageContentFuture -> lProductsWithImageContentFuture.join())
					.collect(Collectors.toList());
		});
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));

		return new Resources<>(lResourceProductContentsFuture.get(),
				linkTo(methodOn(ProductController.class).all()).withSelfRel());
	}

	@Override
	public Resource<Product> findById(int pId) {
		Product lProduct = productRepository.findById(pId).orElseThrow(() -> new ProductNotFoundException(pId));

		return productResourceAssembler.toResource(createProductWithImage(lProduct));
	}

	@Override
	public ResponseEntity<?> save(Product pProduct) throws URISyntaxException {
		Resource<Product> lResource = productResourceAssembler.toResource(productRepository.save(pProduct));

		return ResponseEntity.created(new URI(lResource.getId().expand().getHref())).body(lResource);
	}

	@Override
	public ResponseEntity<?> deleteById(int pId) {
		productRepository.deleteById(pId);

		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<?> update(Product pNewProduct, int pId) throws URISyntaxException {
		Product lUpdatedProduct = productRepository.findById(pId).map(product -> {
			product.setName(pNewProduct.getName());
			product.setPrice(pNewProduct.getPrice());
			return productRepository.save(product);
		}).orElseGet(() -> {
			pNewProduct.setId(pId);
			return productRepository.save(pNewProduct);
		});

		Resource<Product> lResource = productResourceAssembler.toResource(lUpdatedProduct);
		return ResponseEntity.created(new URI(lResource.getId().expand().getHref())).body(lResource);
	}

	@Async
	private CompletableFuture<Resource<Product>> createProductWithImageAsync(Product pProduct)
			throws InterruptedException {
		ProductWithImage lProductWithImage = new ProductWithImage(pProduct);
		Object lImage = null;
		lImage = getImage(pProduct);
		lProductWithImage.setImage(lImage);
		return CompletableFuture.completedFuture(productResourceAssembler.toResource(lProductWithImage));
	}

	private ProductWithImage createProductWithImage(Product pProduct) {
		ProductWithImage productWithImage = new ProductWithImage(pProduct);
		Object lImage = null;
		lImage = getImage(pProduct);
		productWithImage.setImage(lImage);
		return productWithImage;
	}

	private Object getImage(Product pProduct) {
		return restTemplate.getForObject(GlobalPropertiesPath.URL_IMAGE_SERVICE + pProduct.getIdImage(), Object.class);
	}

}
