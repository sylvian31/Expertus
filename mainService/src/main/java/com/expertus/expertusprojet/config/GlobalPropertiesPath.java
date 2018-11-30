package com.expertus.expertusprojet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@PropertySource({ 
//"classpath:persistence-${envTarget:mysql}.properties"
//})

@Configuration
@PropertySource("classpath:language/languageEN.properties")
public class GlobalPropertiesPath {
	
	/* ----------------- Path Private ----------------- */

	private static final String LANGUAGE_PATH = "expertus.web.language.";

	private static final String LANGUAGE_HEADER_PATH = LANGUAGE_PATH + "header.";
	
	/* ----------------- Path Public ----------------- */

	public static final String LANGUAGE_HEADER_TITRE_PATH = LANGUAGE_HEADER_PATH + "titre";
	
	/* ----------------- Url microService Product ----------------- */
	
	private static final String URL_PRODUCT_MICRO_SERVICE = "http://localhost:8100/";
	
	public static final String URL_PRODUCT_MICRO_SERVICE_GET = URL_PRODUCT_MICRO_SERVICE + "products/";
	
	public static final String URL_PRODUCT_MICRO_SERVICE_DELETE = URL_PRODUCT_MICRO_SERVICE + "products/delete/";
	
	public static final String URL_PRODUCT_MICRO_SERVICE_ADD = URL_PRODUCT_MICRO_SERVICE + "products/add";
	
	public static final String URL_PRODUCT_MICRO_SERVICE_UPDATE = URL_PRODUCT_MICRO_SERVICE + "products/update/";
	

}
