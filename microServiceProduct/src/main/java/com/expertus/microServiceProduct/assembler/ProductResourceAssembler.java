package com.expertus.microServiceProduct.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.concurrent.ExecutionException;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.expertus.microServiceProduct.bean.Product;
import com.expertus.microServiceProduct.controller.ProductController;

@Component
public class ProductResourceAssembler implements ResourceAssembler<Product, Resource<Product>>  {

	@Override
	public Resource<Product> toResource(Product product) {
		try {
			return new Resource<>(product, linkTo(methodOn(ProductController.class).one(product.getId())).withSelfRel(),
					linkTo(methodOn(ProductController.class).all()).withRel("products"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Resource<>(product);
	}

}
