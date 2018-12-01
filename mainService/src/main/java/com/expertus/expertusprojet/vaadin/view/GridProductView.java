package com.expertus.expertusprojet.vaadin.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.expertus.expertusprojet.bean.Product;
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
public class GridProductView extends VerticalLayout implements View{

    public static final String VIEW_NAME = "gridProduct";
    
	@Autowired
	private ProductService productService;

	private Grid<Product> gridProduct;
    
    @PostConstruct
    void init() {
    	gridProduct = new Grid();
        addComponent(new Label("This is a product view"));
        addComponent(gridProduct);
        initListProduct();
    }

    @Override
    public void enter(ViewChangeEvent event) {
    	gridProduct.setItems(productService.findAll().getBody());
    }
    
	private void initListProduct() {
		gridProduct.setItems(productService.findAll().getBody());
		gridProduct.addColumn(Product::getName).setCaption("Name");
		gridProduct.addColumn(Product::getPrice).setCaption("Price");
//		gridProduct.addColumn(p -> createImage(p), new ImageRenderer()).setCaption("Image");

		gridProduct.addComponentColumn(this::buildDescriptionLink);
		gridProduct.addComponentColumn(this::buildDeleteButton);

	}
	
	private ExternalResource createImage(Product pProduct) {
		String lUrl = "";
		if (pProduct.getImage() != null) {
			lUrl = pProduct.getImage().get(0).getUrl();
		}
		return new ExternalResource(lUrl);
	}
	
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
	
	private Link buildDescriptionLink(Product pProduct) {
		Link lLink = new Link("Description", new ExternalResource("#!" + DescriptifProductView.VIEW_NAME + "/" + pProduct.getId()));
		lLink.addStyleName(ValoTheme.BUTTON_LINK);
		return lLink;
	}
	
}
