package com.expertus.microServiceImage.exception;

public class ImageNotFoundException extends RuntimeException{

	public ImageNotFoundException(int pId) {
		super("Could not find image " + pId);
	}
	
}
