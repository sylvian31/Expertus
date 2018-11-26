package com.expertus.microServiceProduct.exception;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(int pId) {
		super("Could not find product " + pId);
	}
}
