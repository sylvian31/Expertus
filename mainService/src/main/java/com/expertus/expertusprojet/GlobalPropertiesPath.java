package com.expertus.expertusprojet;

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
	
	public static final String URL_PRODUCT_MICRO_SERVICE = "http://localhost:8100/products/";
	

}
