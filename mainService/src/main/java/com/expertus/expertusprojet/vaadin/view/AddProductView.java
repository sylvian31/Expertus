package com.expertus.expertusprojet.vaadin.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.expertus.expertusprojet.service.ImageService;
import com.expertus.expertusprojet.service.ProductService;
import com.expertus.expertusprojet.vaadin.component.ProductFormComponent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = AddProductView.VIEW_NAME)
public class AddProductView extends VerticalLayout implements View{

	/** The view name */
    public static final String VIEW_NAME = "addProduct";
    
    /** The product service */
    @Autowired
    ProductService productService;
    
	/** The image Service */
	@Autowired
	ImageService imageService;
    
	/** The environment */
	@Autowired
	Environment env;

    @PostConstruct
    void init() {
    	addComponent(new ProductFormComponent(productService, imageService, env));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
    

}