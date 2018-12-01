package com.expertus.microServiceImage.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalPropertiesPathConfig {

	/* ----------------- Path Private ----------------- */

	private static final String IMAGES = "/images";

	/* ----------------- Path Public ----------------- */

	public static final String ROUTE_IMAGE_HOME = "/";

	public static final String ROUTE_IMAGE_ALL = IMAGES;

	public static final String ROUTE_IMAGE_ID = IMAGES + "/{id}";
	
	public static final String ROUTE_IMAGE_ID_PRODUCT = IMAGES + "/product/{id}";

	public static final String ROUTE_IMAGE_DELETE = IMAGES + "/delete/{id}";

	public static final String ROUTE_IMAGE_ADD = IMAGES + "/add";
	
	public static final String ROUTE_IMAGE_ADD_WITH_ID = IMAGES + "/add/{id}";

	public static final String ROUTE_IMAGE_PUT = IMAGES + "/update/{id}";

}
