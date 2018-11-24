package com.expertus.expertusprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//@PropertySource({ 
//"classpath:persistence-${envTarget:mysql}.properties"
//})

@Configuration
@PropertySource("classpath:language/languageEN.properties")
//@PropertySource("classpath:test.properties")
public class Language {
	
	@Autowired
	private Environment env;
	


	/* ----------------- Path ----------------- */

	private static final String LANGUAGE_PROPERTISES_PATH = "expertus.web.language.";

	private static final String LANGUAGE_PROPERTISES_HEADER_PATH = LANGUAGE_PROPERTISES_PATH + "header.";

	private static final String LANGUAGE_HEADER_TITRE_PATH = LANGUAGE_PROPERTISES_HEADER_PATH + "titre";

	
	/* ------------- initialisation  Constante ------------------- */
	
	private static String languageHeaderTitre;



	@Bean
	public void load() {
		languageHeaderTitre = env.getProperty(LANGUAGE_HEADER_TITRE_PATH);
	}


	/* ----------- getter / setter ---------- */
	

	public static String getLanguageHeaderTitre() {
		return languageHeaderTitre;
	}



	public static void setLanguageHeaderTitre(String pLanguageHeaderTitre) {
		Language.languageHeaderTitre = languageHeaderTitre;
	}
	
	
	
	
	
	
	

}
