package com.expertus.microServiceOrder.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalPropertiesPathConfig {

	/* ----------------- Path Private ----------------- */

	private static final String ORDER = "/orders";

	/* ----------------- Path Public ----------------- */

	public static final String ROUTE_ORDER_HOME = "/";

	public static final String ROUTE_ORDER_ALL = ORDER;

	public static final String ROUTE_ORDER_ID = ORDER + "/{id}";

	public static final String ROUTE_ORDER_CANCEL = ORDER + "/delete/{id}";

	public static final String ROUTE_ORDER_ADD = ORDER + "/add";

	public static final String ROUTE_ORDER_COMPLETE = ORDER + "/update/{id}";

}
