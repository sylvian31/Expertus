package com.expertus.microServiceProduct.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalPropertiesPathConfig {

	private static final String PRODUCTS = "/products";

	public static final String ROUTE_PRODUCT_HOME = "/";

	public static final String ROUTE_PRODUCT_ALL = PRODUCTS;

	public static final String ROUTE_PRODUCT_ID = PRODUCTS + "/{id}";

	public static final String ROUTE_PRODUCT_DELETE = PRODUCTS + "/add";

	public static final String ROUTE_PRODUCT_ADD = PRODUCTS + "/update/{id}";

	public static final String ROUTE_PRODUCT_PUT = PRODUCTS + "/delete/{id}";

	public static final String URL_IMAGE_SERVICE = "http://image-service/images/";
}
