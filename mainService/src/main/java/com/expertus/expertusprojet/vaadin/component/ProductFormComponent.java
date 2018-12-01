package com.expertus.expertusprojet.vaadin.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.expertus.expertusprojet.bean.Image;
import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.config.GlobalPropertiesPath;
import com.expertus.expertusprojet.service.ProductService;
import com.expertus.expertusprojet.vaadin.view.GridProductView;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@UIScope
public class ProductFormComponent extends FormLayout{
	
	@Autowired
	private ProductService productService;
    
	private Binder<Product> binderProduct = new Binder<>();

	private List<Binder<Image>> binderImages = new ArrayList();
	
	public ProductFormComponent() {
		addComponent(new Label("Add Product"));
		initBinder();
		addComponent(buildAddButton());	}
	
	private void initBinder() {
		final Product lProdcut = new Product();
		binderProduct.bind(createTextField("Name"), Product::getName, Product::setName);

		binderProduct.forField(createTextField("Price"))
				.withValidator(string -> string != null && !string.isEmpty(), "Input values should not be empty")
				.withConverter(new StringToDoubleConverter("Must enter a number"))
				.withValidator(lDouble -> lDouble > 0.0, "Input value should be a positive integer")
				.bind(Product::getPrice, Product::setPrice);

		for (int i = 0; i < GlobalPropertiesPath.NB_TEXTFIELD_INIT; i++) {
			final Image lImage = new Image();
			Binder<Image> lBinderImage = new Binder<>();
			lBinderImage.bind(createTextField("Image" + (i + 1)), Image::getUrl, Image::setUrl);
			lBinderImage.setBean(lImage);
			binderImages.add(lBinderImage);

		}

		binderProduct.setBean(lProdcut);

	}

	private TextField createTextField(String pName) {
		TextField lTitleField = new TextField(pName);
		lTitleField.setRequiredIndicatorVisible(true);
		addComponent(lTitleField);
		return lTitleField;
	}





	/* ------------------- Button ------------------- */

	/* ----------- Button delete ----------- */



	/* ----------- Button add ----------- */

	private Button buildAddButton() {
		Button lButton = new Button(VaadinIcons.PLUS_CIRCLE);
		lButton.addStyleName(ValoTheme.BUTTON_LARGE);
		lButton.addClickListener(e -> addButtonProductClicked());
		return lButton;
	}

	private void addButtonProductClicked() {
		System.out.println("azerty : " + binderProduct.getBean().toString());
		binderProduct.validate();

		if (binderProduct.isValid()) {
			Product lProduct = binderProduct.getBean();
			productService.add(getProductWithValidateListImage(lProduct));
			getUI().getNavigator().navigateTo(GridProductView.VIEW_NAME);
		} else {
			System.out.println("azerty : binder is not valid");
		}
	}

	private Product getProductWithValidateListImage(Product pProduct) {
		pProduct.setImage(new ArrayList());
		for (Binder<Image> lbinderImage : binderImages) {
			lbinderImage.validate();
			if (lbinderImage.isValid()) {
				if (lbinderImage.getBean().getUrl() != null && !lbinderImage.getBean().getUrl().isEmpty()) {
					pProduct.getImage().add(lbinderImage.getBean());
				}
			}
		}
		return pProduct;
	}

}
