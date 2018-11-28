package com.expertus.main.vaadin.ui;

import com.expertus.main.bean.Product;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
@Theme("valo")
public class MyUI extends UI{

	private VerticalLayout layout;
	
    @Autowired
    ProductList productList;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();
        addProductList();
        addActionButtons();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label lHeader = new Label("Product");
        lHeader.addStyleName(ValoTheme.LABEL_H1);
        layout.addComponent(lHeader);

    }

    private void addForm() {
        HorizontalLayout lFormLayout = new HorizontalLayout();
        lFormLayout.setWidth("80%");

        TextField lTaskField = new TextField();
        lTaskField.focus();
        Button lAddButton = new Button("");

        lFormLayout.addComponentsAndExpand(lTaskField);
        lFormLayout.addComponent(lAddButton);
        layout.addComponent(lFormLayout);

        lAddButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        lAddButton.setIcon(VaadinIcons.PLUS);

        lAddButton.addClickListener(click -> {
            productList.addProduct(new Product(lTaskField.getValue()));
            lTaskField.setValue("");
            lTaskField.focus();
        });
        lAddButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }

    private void addProductList() {
        layout.addComponent(productList);
    }

    private void addActionButtons() {
        Button deleteButton = new Button("Delete completed items");

        deleteButton.addClickListener(click->productList.deleteCompleted(1));

        layout.addComponent(deleteButton);

    }
    
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet{
    	
    }

}
