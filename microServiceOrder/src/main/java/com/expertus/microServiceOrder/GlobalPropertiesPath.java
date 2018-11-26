package com.expertus.microServiceOrder;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:route.properties")
public class GlobalPropertiesPath {

	/* ----------------- Path Private ----------------- */
	
	private static final String ROUTE_ORDER_PATH = "expertus.route.order.";
	
	/* ----------------- Path Public ----------------- */
	
	public static final String ROUTE_ORDER_HOME_PATH = ROUTE_ORDER_PATH + "home";
	
	public static final String ROUTE_ORDER_ALL_PATH = ROUTE_ORDER_PATH + "all";
	
	public static final String ROUTE_ORDER_ID_PATH = ROUTE_ORDER_PATH + "id";
	
	public static final String ROUTE_ORDER_CANCEL_PATH = ROUTE_ORDER_PATH + "delete";
	
	public static final String ROUTE_ORDER_ADD_PATH = ROUTE_ORDER_PATH + "add";
	
	public static final String ROUTE_ORDER_COMPLETE_PATH = ROUTE_ORDER_PATH + "update";
	
}
