package com.expertus.microServiceProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
public class GlobalPropertiesPath {
	
	private static final String PRODUCTS = "/products";
	
	public static final String ROUTE_PRODUCT_HOME = "/";
	
	public static final String ROUTE_PRODUCT_ALL = PRODUCTS;
	
	public static final String ROUTE_PRODUCT_ID = PRODUCTS +"/{id}";
	
	public static final String ROUTE_PRODUCT_DELETE =  PRODUCTS + "/add";
	
	public static final String ROUTE_PRODUCT_ADD = PRODUCTS + "/update";
	
	public static final String ROUTE_PRODUCT_PUT = PRODUCTS + "/delete";
	
	public static final String URL_IMAGE_SERVICE = "http://image-service/images/";
}
