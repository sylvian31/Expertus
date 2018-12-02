package com.expertus.expertusprojet.vaadin.component;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import com.expertus.expertusprojet.bean.Image;
import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.config.GlobalPropertiesPath;
import com.expertus.expertusprojet.service.ImageService;
import com.expertus.expertusprojet.service.ProductService;
import com.expertus.expertusprojet.vaadin.view.GridProductView;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@UIScope
public class ProductFormComponent extends FormLayout {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The product service */
	private ProductService productService;

	/** The image service */
	private ImageService imageService;

	/** The environment */
	Environment env;

	/** The binder product */
	private Binder<Product> binderProduct = new Binder<>();

	/** The list of binder image */
	private List<Binder<Image>> binderImages = new ArrayList();

	/**
	 * Constructor for Add form
	 * 
	 * @param pProductService
	 */
	public ProductFormComponent(ProductService pProductService, ImageService pImageService, Environment pEnv) {
		this.productService = pProductService;
		this.imageService = pImageService;
		this.env = pEnv;
		addComponent(new Label(env.getProperty(GlobalPropertiesPath.I18N_COMPONENT_FORM_PRODUCT_LABEL_ADD_TITLE)));
		initBinder(new Product());
		addComponent(buildAddButton());
	}

	/**
	 * Constructor for Update form
	 * 
	 * @param pProductService
	 * @param pProduct
	 */
	public ProductFormComponent(ProductService pProductService, ImageService pImageService, Environment pEnv,
			Product pProduct) {
		this.productService = pProductService;
		this.imageService = pImageService;
		this.env = pEnv;
		addComponent(new Label(env.getProperty(GlobalPropertiesPath.I18N_COMPONENT_FORM_PRODUCT_LABEL_UPDATE_TITLE)));
		initBinder(pProduct);
		addComponent(buildUpdateButton());
	}

	/**
	 * Init binder
	 * 
	 * @param pProduct
	 */
	private void initBinder(Product pProduct) {
		binderProduct.bind(
				buildTextField(env.getProperty(GlobalPropertiesPath.I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD_NAME)),
				Product::getName, Product::setName);

		binderProduct
				.forField(buildTextField(
						env.getProperty(GlobalPropertiesPath.I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD_PRICE)))
				.withValidator(lString -> lString != null && !lString.isEmpty(), "Input values should not be empty")
				.withConverter(new StringToDoubleConverter("Must enter a number"))
				.withValidator(lDouble -> lDouble > 0.0, "Input value should be a positive integer")
				.bind(Product::getPrice, Product::setPrice);

		// init binder for every image
		for (int i = 0; i < GlobalPropertiesPath.NB_TEXTFIELD_INIT; i++) {
			Image lImage = new Image();
			if (pProduct.getImage() != null) {
				if (i < pProduct.getImage().size()) {
					if (pProduct.getImage().get(i).getUrl() != null && !pProduct.getImage().get(i).getUrl().isEmpty()) {
						lImage = pProduct.getImage().get(i);
					}
				}
			}
			Binder<Image> lBinderImage = new Binder<>();
			lBinderImage.bind(buildTextField(
					env.getProperty(GlobalPropertiesPath.I18N_COMPONENT_FORM_PRODUCT_TEXT_FIELD_IMAGE) + " " + (i + 1)),
					Image::getUrl, Image::setUrl);
			lBinderImage.setBean(lImage);
			binderImages.add(lBinderImage);

		}

		binderProduct.setBean(pProduct);

	}

	/**
	 * Build TextField with a string name
	 * 
	 * @param pName
	 * @return TextField
	 */
	private TextField buildTextField(String pName) {
		TextField lTitleField = new TextField(pName);
		lTitleField.setRequiredIndicatorVisible(true);
		addComponent(lTitleField);
		return lTitleField;
	}

	/* ------------------- Button ------------------- */

	/* ----------- Button update ----------- */

	/**
	 * Build update button
	 * 
	 * @return Button
	 */
	private Button buildUpdateButton() {
		Button lButton = new Button(env.getProperty(GlobalPropertiesPath.I18N_COMPONENT_FORM_PRODUCT_BUTTON_UPDATE));
		lButton.addStyleName(ValoTheme.BUTTON_LARGE);
		lButton.addClickListener(e -> updateButtonProductClicked());
		return lButton;
	}

	/**
	 * Event update button
	 */
	private void updateButtonProductClicked() {
		binderProduct.validate();
		if (binderProduct.isValid()) {
			Product lProduct = binderProduct.getBean();
			productService.update(lProduct);
			managmentImage(lProduct);
			Page.getCurrent().reload();
		} else {
			logger.info(this.getClass().getName(), "binder is not valid");
		}
	}

	/* ----------- Button add ----------- */

	/**
	 * Build add button
	 * 
	 * @return Button
	 */
	private Button buildAddButton() {
		Button lButton = new Button(VaadinIcons.PLUS_CIRCLE);
		lButton.addStyleName(ValoTheme.BUTTON_LARGE);
		lButton.addClickListener(e -> addButtonProductClicked());
		return lButton;
	}

	/**
	 * Event add button
	 */
	private void addButtonProductClicked() {
		binderProduct.validate();
		if (binderProduct.isValid()) {
			Product lProduct = productService.add(binderProduct.getBean());
			managmentImage(lProduct);
			getUI().getNavigator().navigateTo(GridProductView.VIEW_NAME);
		} else {
			logger.info(this.getClass().getName(), "binder is not valid");
		}
	}

	/* ---------------- end button ---------------- */

	private void managmentImage(Product pProduct) {
		for (Binder<Image> lbinderImage : binderImages) {
			lbinderImage.validate();
			if (lbinderImage.isValid()) {
				Image lImage = lbinderImage.getBean();
				if (lImage.getUrl() != null) {
					if (lImage.getUrl() != null && !lImage.getUrl().isEmpty()) {
						if (lImage.getId() != null) {
							imageService.update(lImage);
						} else {
							lImage.setIdProduct(pProduct.getId());
							imageService.add(lImage);
						}
					} else if (lImage.getUrl().isEmpty() && lImage.getId() != null) {
						imageService.delete(lImage.getId());
					}
				}
			}
		}
	}

}
