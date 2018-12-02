package com.expertus.expertusprojet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:i18n.properties")
public class GlobalPropertiesPath {

	/* ----------------- Path i18n ----------------- */

	private static final String I18N = "expertus";
	
	/* ----- UI ----- */ 

	private static final String I18N_UI = I18N + ".ui";
	
	public static final String I18N_UI_TITLE = I18N_UI + ".title";

	private static final String I18N_NAVIGATION = I18N_UI + ".navigation";

	private static final String I18N_NAVIGATION_BUTTON = I18N_NAVIGATION + ".button";

	public static final String I18N_NAVIGATION_BUTTON_HOME = I18N_NAVIGATION_BUTTON + ".home";

	public static final String I18N_NAVIGATION_BUTTON_LIST_PRODUCT = I18N_NAVIGATION_BUTTON + ".listProduct";

	public static final String I18N_NAVIGATION_BUTTON_ADD_PRODUCT = I18N_NAVIGATION_BUTTON + ".addProduct";
	
	/* ----- View ----- */ 

	private static final String I18N_VIEW = I18N + ".view";
	
	private static final String I18N_VIEW_DEFAULT = I18N_VIEW + ".default";
	
	private static final String I18N_VIEW_DEFAULT_LABEL = I18N_VIEW_DEFAULT + ".label";
	
	public static final String I18N_VIEW_DEFAULT_LABEL_TITLE = I18N_VIEW_DEFAULT_LABEL + ".title";
	
	private static final String I18N_VIEW_DESCRIPTION = I18N_VIEW + ".description";
	
	private static final String I18N_VIEW_DESCRIPTION_LABEL = I18N_VIEW_DESCRIPTION + ".label";
	
	public static final String I18N_VIEW_DESCRIPTION_LABEL_IMAGES = I18N_VIEW_DESCRIPTION_LABEL + ".images";
	
	private static final String I18N_VIEW_GRID_PRODUCT = I18N_VIEW + ".gridProduct";
	
	private static final String I18N_VIEW_GRID_PRODUCT_LABEL = I18N_VIEW_GRID_PRODUCT + ".label";
	
	public static final String I18N_VIEW_GRID_PRODUCT_LABEL_TITLE = I18N_VIEW_GRID_PRODUCT_LABEL + ".title";
	
	private static final String I18N_VIEW_GRID_PRODUCT_COLUMN = I18N_VIEW_GRID_PRODUCT + ".column";
	
	public static final String I18N_VIEW_GRID_PRODUCT_COLUMN_NAME = I18N_VIEW_GRID_PRODUCT_COLUMN + ".name";
	
	public static final String I18N_VIEW_GRID_PRODUCT_COLUMN_PRICE = I18N_VIEW_GRID_PRODUCT_COLUMN + ".price";
	
	public static final String I18N_VIEW_GRID_PRODUCT_COLUMN_DESCRIPTION = I18N_VIEW_GRID_PRODUCT_COLUMN + ".description";
	
	/* ----- Component ----- */ 
	
	private static final String I18N_COMPONENT = I18N + ".component";
	
	private static final String I18N_COMPONENT_FORM_PRODUCT = I18N_COMPONENT + ".formProduct";
	
	private static final String I18N_COMPONENT_FORM_PRODUCT_LABEL= I18N_COMPONENT_FORM_PRODUCT + ".label";
	
	public static final String I18N_COMPONENT_FORM_PRODUCT_LABEL_ADD_TITLE= I18N_COMPONENT_FORM_PRODUCT_LABEL + ".add.title";
	
	public static final String I18N_COMPONENT_FORM_PRODUCT_LABEL_UPDATE_TITLE= I18N_COMPONENT_FORM_PRODUCT_LABEL + ".update.title";
	
	private static final String I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD = I18N_COMPONENT_FORM_PRODUCT + ".textField";
	
	public static final String I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD_NAME = I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD + ".name";
	
	public static final String I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD_PRICE = I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD + ".price";
	
	public static final String I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD_IMAGE = I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD + ".image";
	
	private static final String I18N_COMPONENT_FORM_PRODUCT_BUTTON = I18N_COMPONENT_FORM_PRODUCT + ".button";
	
	public static final String I18N_COMPONENT_FORM_PRODUCT_BUTTON_UPDATE = I18N_COMPONENT_FORM_PRODUCT_BUTTON + ".update";

	/* ----------------- Url microService Product ----------------- */

	private static final String URL_PRODUCT_MICRO_SERVICE = "http://localhost:8100/products";

	public static final String URL_PRODUCT_MICRO_SERVICE_GET = URL_PRODUCT_MICRO_SERVICE + "/";

	public static final String URL_PRODUCT_MICRO_SERVICE_DELETE = URL_PRODUCT_MICRO_SERVICE + "/delete/";

	public static final String URL_PRODUCT_MICRO_SERVICE_ADD = URL_PRODUCT_MICRO_SERVICE + "/add/";

	public static final String URL_PRODUCT_MICRO_SERVICE_UPDATE = URL_PRODUCT_MICRO_SERVICE + "/update/";

	public static final int NB_TEXTFIELD_INIT = 3;
	
	/* ----------------- Url microService Image ----------------- */	
	
	private static final String URL_IMAGE_MICRO_SERVICE = "http://localhost:8200/images";
	
	public static final String URL_IMAGE_MICRO_SERVICE_DELETE = URL_IMAGE_MICRO_SERVICE + "/delete/";
	
	public static final String URL_IMAGE_MICRO_SERVICE_UPDATE = URL_IMAGE_MICRO_SERVICE + "/update/";
	
	public static final String URL_IMAGE_MICRO_SERVICE_ADD = URL_IMAGE_MICRO_SERVICE + "/add/";
	

}
