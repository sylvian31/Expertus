package com.expertus.expertusprojet.vaadin.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.expertus.expertusprojet.bean.Image;
import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.service.ProductService;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ImageRenderer;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MyUI extends UI implements  ViewDisplay{

	@Autowired
	Environment env;

	@Autowired
	private ProductService productService;

	private Grid<Product> gridProduct = new Grid<>(Product.class);
	private Panel springViewDisplay;

	@Override
	protected void init(VaadinRequest pRequest) {
		final VerticalLayout lVerticalLayout = new VerticalLayout();
		final Label lLabel = new Label("welcome expertus");

		lVerticalLayout.addComponent(lLabel);
		lVerticalLayout.addComponent(gridProduct);
		

		
		
		
		updateList();

		setContent(lVerticalLayout);

	}
	
	private void updateList() {
		Product[] lProducts = productService.findAll().getBody();
		gridProduct.setItems(lProducts);
		
		gridProduct.setColumns("name", "price");
		gridProduct.setItems(lProducts);
		
		Column<Image, com.vaadin.ui.Image> lImageColumn = gridProduct.addColumn(
			    p -> new com.vaadin.ui.Image(p.getImage().getName(), new ExternalResource(p.getImage().getUrl())).getSource(),
			    new ImageRenderer());
		

	}

	@Override
	public void showView(View pView) {
		springViewDisplay.setContent((Component) pView);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

	}
}
