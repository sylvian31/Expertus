package com.expertus.microServiceProduct.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalPropertiesPathConfig {

	private static final String PRODUCTS = "/products";

	public static final String ROUTE_PRODUCT_HOME = "/";

	public static final String ROUTE_PRODUCT_ALL = PRODUCTS;

	public static final String ROUTE_PRODUCT_ID = PRODUCTS + "/{id}";

	public static final String ROUTE_PRODUCT_DELETE = PRODUCTS + "/delete/{id}";

	public static final String ROUTE_PRODUCT_ADD = PRODUCTS + "/add";

	public static final String ROUTE_PRODUCT_PUT = PRODUCTS + "/update/{id}";
	
	/* ---------------- image service ---------------- */

	public static final String URL_IMAGE_SERVICE = "http://image-service/images/";
	
	public static final String URL_IMAGE_SERVICE_ID_PRODUCT = URL_IMAGE_SERVICE + "product/";
	
	public static final String URL_IMAGE_SERVICE_ADD = URL_IMAGE_SERVICE + "add";
	
	public static final String URL_IMAGE_SERVICE_DELETE = URL_IMAGE_SERVICE + "product/delete/";
	
	public static final String URL_IMAGE_SERVICE_UPDATE = URL_IMAGE_SERVICE + "update/";
}
