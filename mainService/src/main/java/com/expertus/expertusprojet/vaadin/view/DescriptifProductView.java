package com.expertus.expertusprojet.vaadin.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.expertus.expertusprojet.bean.Image;
import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.config.GlobalPropertiesPath;
import com.expertus.expertusprojet.service.ImageService;
import com.expertus.expertusprojet.service.ProductService;
import com.expertus.expertusprojet.util.Util;
import com.expertus.expertusprojet.vaadin.component.ProductFormComponent;
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

	/** The view name */
	public static final String VIEW_NAME = "DescriptionProduct";

	/** The product service */
	@Autowired
	private ProductService productService;
	
    /** The image Service */
    @Autowired
    private ImageService imageService;

	/** The environment */
	@Autowired
	private Environment env;

	/** The current product */
	private Product currentProduct;

	/** The title Label */
	private Label labelTitle;

	/** The price label */
	private Label labelPrice;

	/** The Image label */
	private Label labelImages;

	/** The horizontal layout for images */
	private HorizontalLayout horizontalLayoutImages;

	@PostConstruct
	void init() {
		labelTitle = new Label();
		labelPrice = new Label();
		labelImages = new Label();
		horizontalLayoutImages = new HorizontalLayout();
		addComponent(labelTitle);
		addComponent(labelPrice);
		addComponent(horizontalLayoutImages);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		if (event.getParameters() != null) {
			String[] msgs = event.getParameters().split("/");
			currentProduct = productService.findById(Long.parseLong(msgs[0]));
			addComponent(new ProductFormComponent(productService, imageService, env, currentProduct));
			updateView();
		}
	}

	/**
	 * Update view
	 */
	private void updateView() {
		labelTitle.setCaption(currentProduct.getName());
		labelPrice.setCaption(Util.formatDecimal((float) currentProduct.getPrice()) + "$");
		if (currentProduct.getImage() != null) {
			if (currentProduct.getImage().size() > 0) {
				labelImages.setCaption(env.getProperty(GlobalPropertiesPath.I18N_VIEW_DESCRIPTION_LABEL_IMAGES));
				horizontalLayoutImages.addComponent(labelImages);
			}
			int i = 1;
			for (Image lImage : currentProduct.getImage()) {
				Embedded lEmbedded = new Embedded("", new ExternalResource(lImage.getUrl()));
				lEmbedded.setWidth(200, Unit.PIXELS);
				lEmbedded.setHeight(150, Unit.PIXELS);
				horizontalLayoutImages.addComponent(lEmbedded);
				i++;
			}
		}
	}

}
