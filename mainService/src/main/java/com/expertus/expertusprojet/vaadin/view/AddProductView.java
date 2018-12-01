package com.expertus.expertusprojet.vaadin.view;

import javax.annotation.PostConstruct;

import com.expertus.expertusprojet.vaadin.component.ProductFormComponent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = AddProductView.VIEW_NAME)
public class AddProductView extends VerticalLayout implements View{

    public static final String VIEW_NAME = "addProduct";

    @PostConstruct
    void init() {
    	addComponent(new ProductFormComponent());
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
    

}