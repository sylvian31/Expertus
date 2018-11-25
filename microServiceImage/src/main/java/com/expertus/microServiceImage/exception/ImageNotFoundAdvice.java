package com.expertus.microServiceImage.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ImageNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(ImageNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String imageNotFoundHandler(ImageNotFoundException ex) {
		return ex.getMessage();
	}
}
