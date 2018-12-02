package com.expertus.expertusprojet.vaadin.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.expertus.expertusprojet.config.GlobalPropertiesPath;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
	
	/** The view name */
    public static final String VIEW_NAME = "";

	/** The environment */
	@Autowired
	Environment env;
	
    @PostConstruct
    void init() {
        addComponent(new Label(env.getProperty(GlobalPropertiesPath.I18N_VIEW_DEFAULT_LABEL_TITLE)));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}