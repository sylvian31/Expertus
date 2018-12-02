package com.expertus.expertusprojet.vaadin.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.config.GlobalPropertiesPath;
import com.expertus.expertusprojet.service.ProductService;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@UIScope
@SpringView(name = GridProductView.VIEW_NAME)
public class GridProductView extends VerticalLayout implements View {

	/** The view name */
	public static final String VIEW_NAME = "gridProduct";
	
	/** The environment */
	@Autowired
	Environment env;

	/** The product service */
	@Autowired
	private ProductService productService;

	/** The grid for show product */
	private Grid<Product> gridProduct;

	@PostConstruct
	void init() {
		gridProduct = new Grid();
		addComponent(new Label(env.getProperty(GlobalPropertiesPath.I18N_VIEW_GRID_PRODUCT_LABEL_TITLE)));
		addComponent(gridProduct);
		initGridProduct();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		updateList();
	}

	/**
	 * Init grid product
	 */
	private void initGridProduct() {
		gridProduct.addColumn(Product::getName).setCaption(env.getProperty(GlobalPropertiesPath.I18N_VIEW_GRID_PRODUCT_COLUMN_NAME));
		gridProduct.addColumn(Product::getPrice).setCaption(env.getProperty(GlobalPropertiesPath.I18N_VIEW_GRID_PRODUCT_COLUMN_PRICE));

		gridProduct.addComponentColumn(this::buildDescriptionLink);
		gridProduct.addComponentColumn(this::buildDeleteButton);

	}

	/**
	 * Build delete button
	 * 
	 * @param pProduct
	 * @return Button
	 */
	private Button buildDeleteButton(Product pProduct) {
		Button lButton = new Button(VaadinIcons.TRASH);
		lButton.addStyleName(ValoTheme.BUTTON_SMALL);
		lButton.addClickListener(e -> deleteButtonProductClicked(pProduct));
		return lButton;
	}

	/**
	 * Event delete button
	 * 
	 * @param pProduct
	 */
	private void deleteButtonProductClicked(Product pProduct) {
		productService.delete(pProduct.getId());
		updateList();
	}

	/**
	 * Build description link
	 * 
	 * @param pProduct
	 * @return Link
	 */
	private Link buildDescriptionLink(Product pProduct) {
		Link lLink = new Link(env.getProperty(GlobalPropertiesPath.I18N_VIEW_GRID_PRODUCT_COLUMN_DESCRIPTION),
				new ExternalResource("#!" + DescriptifProductView.VIEW_NAME + "/" + pProduct.getId()));
		lLink.addStyleName(ValoTheme.BUTTON_LINK);
		return lLink;
	}

	/**
	 * Update list to the grid product
	 */
	private void updateList() {
		gridProduct.setItems(productService.findAll());
	}

}
