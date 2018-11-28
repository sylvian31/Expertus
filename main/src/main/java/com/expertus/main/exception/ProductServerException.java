package com.expertus.main.exception;

public class ProductServerException extends RuntimeException {

	public ProductServerException(int status, String reason) {
		super("Exception from to server");
	}

}
