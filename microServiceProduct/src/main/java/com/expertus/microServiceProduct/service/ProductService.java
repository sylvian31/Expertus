package com.expertus.microServiceProduct.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.expertus.microServiceProduct.assembler.ProductResourceAssembler;
import com.expertus.microServiceProduct.bean.Product;
import com.expertus.microServiceProduct.controller.ProductController;
import com.expertus.microServiceProduct.exception.ProductNotFoundException;
import com.expertus.microServiceProduct.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	/** The image repository */
	@Autowired
	private ProductRepository productRepository;

	/** The Product resource assembler */
	@Autowired
	private ProductResourceAssembler productResourceAssembler;

	@Override
	public Resources<Resource<Product>> findAll() {
		List<Resource<Product>> products = productRepository.findAll().stream()
				.map(productResourceAssembler::toResource).collect(Collectors.toList());

		return new Resources<>(products, linkTo(methodOn(ProductController.class).all()).withSelfRel());
	}

	@Override
	public Resource<Product> findById(int pId) {
		Product product = productRepository.findById(pId).orElseThrow(() -> new ProductNotFoundException(pId));

		return productResourceAssembler.toResource(product);
	}

	@Override
	public ResponseEntity<?> save(Product pImage) throws URISyntaxException {
		Resource<Product> resource = productResourceAssembler.toResource(productRepository.save(pImage));

		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}

	@Override
	public ResponseEntity<?> deleteById(int pId) {
		productRepository.deleteById(pId);

		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<?> update(Product pNewProduct, int pId) throws URISyntaxException {
		Product updatedImage = productRepository.findById(pId).map(product -> {
			product.setName(pNewProduct.getName());
			product.setPrice(pNewProduct.getPrice());
			return productRepository.save(product);
		}).orElseGet(() -> {
			pNewProduct.setId(pId);
			return productRepository.save(pNewProduct);
		});

		Resource<Product> resource = productResourceAssembler.toResource(updatedImage);

		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}

}
