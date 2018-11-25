package com.expertus.microServiceImage;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:route.properties")
public class GlobalPropertiesPath {

	/* ----------------- Path Private ----------------- */
	
	private static final String ROUTE_IMAGE_PATH = "expertus.route.image.";
	
	/* ----------------- Path Public ----------------- */
	
	public static final String ROUTE_IMAGE_HOME_PATH = ROUTE_IMAGE_PATH + "home";
	
	public static final String ROUTE_IMAGE_ALL_PATH = ROUTE_IMAGE_PATH + "all";
	
	public static final String ROUTE_IMAGE_ID_PATH = ROUTE_IMAGE_PATH + "id";
	
	public static final String ROUTE_IMAGE_DELETE_PATH = ROUTE_IMAGE_PATH + "delete";
	
	public static final String ROUTE_IMAGE_ADD_PATH = ROUTE_IMAGE_PATH + "add";
	
	public static final String ROUTE_IMAGE_PUT_PATH = ROUTE_IMAGE_PATH + "update";
	
}
