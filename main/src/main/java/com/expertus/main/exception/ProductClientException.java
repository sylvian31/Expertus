package com.expertus.main.exception;

public class ProductClientException extends RuntimeException {

	public ProductClientException(int status, String reason) {
		super("Exception from to client");
	}

}
