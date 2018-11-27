package com.expertus.microServiceOrder;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class GlobalPropertiesPath {

	/* ----------------- Path Private ----------------- */
	
	private static final String ORDER = "/orders";
	
	/* ----------------- Path Public ----------------- */
	
	public static final String ROUTE_ORDER_HOME = "/";
	
	public static final String ROUTE_ORDER_ALL = ORDER;
	
	public static final String ROUTE_ORDER_ID = ORDER + "/{id}";
	
	public static final String ROUTE_ORDER_CANCEL = ORDER + "/delete";
	
	public static final String ROUTE_ORDER_ADD = ORDER + "/add";
	
	public static final String ROUTE_ORDER_COMPLETE = ORDER + "/update";
	
}
