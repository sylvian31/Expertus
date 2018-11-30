package com.expertus.expertusprojet.vaadin.ui;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.service.ProductService;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ImageRenderer;
import com.vaadin.ui.themes.ValoTheme;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MyUI extends UI /* implements ViewDisplay */ {

	@Autowired
	Environment env;

	@Autowired
	private ProductService productService;

	private Grid<Product> gridProduct;
	private Panel springViewDisplay;
	private FormLayout formLayout;

	Binder<Product> binder = new Binder<>();

	@Override
	protected void init(VaadinRequest pRequest) {
		final VerticalLayout lVerticalLayout = new VerticalLayout();
		final Label lLabel = new Label("welcome expertus");
		gridProduct = new Grid();
		formLayout = new FormLayout();
		lVerticalLayout.addComponent(lLabel);
		lVerticalLayout.addComponent(gridProduct);
		lVerticalLayout.addComponent(formLayout);

		initListProduct();

		initFormAddProduct();

		setContent(lVerticalLayout);

	}

	private void initFormAddProduct() {

		final Product lProdcut = new Product();

		formLayout.addComponent(new Label("Add Product"));

		TextField lTitleFieldName = new TextField("Name");
		lTitleFieldName.setRequiredIndicatorVisible(true);
		formLayout.addComponent(lTitleFieldName);

		TextField lTitleFieldPrice = new TextField("Price");
		lTitleFieldPrice.setRequiredIndicatorVisible(true);
		formLayout.addComponent(lTitleFieldPrice);

		binder.bind(lTitleFieldName, Product::getName, Product::setName);

		binder.forField(lTitleFieldPrice)
				.withValidator(string -> string != null && !string.isEmpty(), "Input values should not be empty")
				.withConverter(new StringToDoubleConverter("Must enter a number"))
				.withValidator(lDouble -> lDouble > 0.0, "Input value should be a positive integer")
				.bind(Product::getPrice, Product::setPrice);

		binder.setBean(lProdcut);
		formLayout.addComponent(buildAddButton());

	}

	private void initListProduct() {
		gridProduct.setItems(productService.findAll().getBody());
		gridProduct.addColumn(Product::getName).setCaption("Name");
		gridProduct.addColumn(Product::getPrice).setCaption("Price");
		gridProduct.addColumn(p -> createImage(p), new ImageRenderer()).setCaption("Image");

		gridProduct.addComponentColumn(this::buildDeleteButton);

	}

	private ExternalResource createImage(Product pProduct) {
		String lUrl = "";
		if (pProduct.getImage() != null) {
			lUrl = pProduct.getImage().getUrl();
		}
		return new ExternalResource(lUrl);
	}

	/* ------------------- Button ------------------- */

	/* ----------- Button delete ----------- */

	private Button buildDeleteButton(Product pProduct) {
		Button lButton = new Button(VaadinIcons.TRASH);
		lButton.addStyleName(ValoTheme.BUTTON_SMALL);
		lButton.addClickListener(e -> deleteButtonProductClicked(pProduct));
		return lButton;
	}

	private void deleteButtonProductClicked(Product pProduct) {
		productService.delete(pProduct.getId());
		gridProduct.setItems(productService.findAll().getBody());
	}

	/* ----------- Button add ----------- */

	private Button buildAddButton() {
		Button lButton = new Button(VaadinIcons.PLUS_CIRCLE);
		lButton.addStyleName(ValoTheme.BUTTON_LARGE);
		lButton.addClickListener(e -> addButtonProductClicked());
		return lButton;
	}

	private void addButtonProductClicked() {
		System.out.println("azerty : " + binder.getBean().toString());
		binder.validate();
		if (binder.isValid()) {
			System.out.println("azerty : " + binder.getBean().toString());
			productService.add(binder.getBean());
			gridProduct.setItems(productService.findAll().getBody());
		} else {
			System.out.println("azerty : binder is not valid");
		}
	}

//	@Override
//	public void showView(View pView) {
//		springViewDisplay.setContent((Component) pView);
//	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

	}
}
