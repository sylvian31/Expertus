package com.expertus.microServiceProduct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:route.properties")
public class GlobalPropertiesPath {

	/* ----------------- Path Private ----------------- */
	
	private static final String ROUTE_PRODUCT_PATH = "expertus.route.product.";
	
	/* ----------------- Path Public ----------------- */
	
	public static final String ROUTE_PRODUCT_HOME_PATH = ROUTE_PRODUCT_PATH + "home";
	
	public static final String ROUTE_PRODUCT_ALL_PATH = ROUTE_PRODUCT_PATH + "all";
	
	public static final String ROUTE_PRODUCT_ID_PATH = ROUTE_PRODUCT_PATH + "id";
	
	public static final String ROUTE_PRODUCT_DELETE_PATH = ROUTE_PRODUCT_PATH + "delete";
	
	public static final String ROUTE_PRODUCT_ADD_PATH = ROUTE_PRODUCT_PATH + "add";
	
	public static final String ROUTE_PRODUCT_PUT_PATH = ROUTE_PRODUCT_PATH + "update";
}
