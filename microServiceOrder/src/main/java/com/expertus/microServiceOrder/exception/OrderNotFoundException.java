package com.expertus.microServiceOrder.exception;

public class OrderNotFoundException extends RuntimeException{

	public OrderNotFoundException(int pId) {
		super("Could not find order " + pId);
	}
}
