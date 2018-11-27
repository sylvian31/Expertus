package com.expertus.microServiceImage;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class GlobalPropertiesPath {

	/* ----------------- Path Private ----------------- */
	
	private static final String IMAGES = "/images";
	
	/* ----------------- Path Public ----------------- */
	
	public static final String ROUTE_IMAGE_HOME = "/";
	
	public static final String ROUTE_IMAGE_ALL = IMAGES;
	
	public static final String ROUTE_IMAGE_ID = IMAGES + "/{id}";
	
	public static final String ROUTE_IMAGE_DELETE = IMAGES + "/delete";
	
	public static final String ROUTE_IMAGE_ADD = IMAGES + "/add";
	
	public static final String ROUTE_IMAGE_PUT = IMAGES + "/update";
	
}
