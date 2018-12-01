package com.expertus.expertusprojet.vaadin.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.expertus.expertusprojet.bean.Image;
import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.service.ProductService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = DescriptifProductView.VIEW_NAME)
public class DescriptifProductView extends VerticalLayout implements View {

	public static final String VIEW_NAME = "DescriptionProduct";

	@Autowired
	private ProductService productService;

	private Product currentProduct;

	private Label labelTitre;
	private Label labelPrice;

	private HorizontalLayout horizontalLayoutImages;

	@PostConstruct
	void init() {
		labelTitre = new Label();
		labelPrice = new Label();
		horizontalLayoutImages = new HorizontalLayout();
		addComponent(labelTitre);
		addComponent(labelPrice);
		addComponent(horizontalLayoutImages);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		if (event.getParameters() != null) {
			String[] msgs = event.getParameters().split("/");
			currentProduct = productService.findById(Long.parseLong(msgs[0]));
			updateView();
		}
	}

	private void updateView() {
		labelTitre.setCaption(currentProduct.getName());
		labelPrice.setCaption(String.valueOf(currentProduct.getPrice()));
		int i = 1;
		for (Image lImage : currentProduct.getImage()) {
			horizontalLayoutImages.addComponent(
					new Embedded("image-" + currentProduct.getName() + "-" + i, new ExternalResource(lImage.getUrl())));
			i++;
		}

	}
}
