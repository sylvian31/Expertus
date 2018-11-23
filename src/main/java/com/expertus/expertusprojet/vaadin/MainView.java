/*
package com.expertus.expertusprojet.vaadin;

import org.springframework.util.StringUtils;

import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.service.IProductService;
import com.expertus.expertusprojet.vaadin.component.ProductEditor;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class MainView extends VerticalLayout{

	private static final long serialVersionUID = -7361273608052974849L;

    private final IProductService productService;
    
    private final ProductEditor productEditor;
	
	final Grid<Product> grid;
	
	final TextField textFieldFilter;
	
	private final Button buttonAddProduct;

	public MainView(IProductService pProductService, ProductEditor pEditor) {
		this.productService = pProductService;
		this.productEditor = pEditor;
		this.grid = new Grid<>(Product.class);
		this.textFieldFilter = new TextField();
		this.buttonAddProduct = new Button("New product", VaadinIcons.PLUS);
		init();
	}
	
	private void init(){
		initLayoutH();
		initTextField();
		initGrid();
		initButtonAddProduct();
		initProductEditor();
		// Initialize listing
		listProduct(null);
	}
	
	// build layout
	private void initLayoutH() {
		HorizontalLayout actions = new HorizontalLayout(textFieldFilter, buttonAddProduct);
//		add(actions, grid, productEditor);
	}
	
	private void initTextField() {
		textFieldFilter.setPlaceholder("Filter by last name");
		textFieldFilter.setValueChangeMode(ValueChangeMode.EAGER);
		textFieldFilter.addValueChangeListener(e -> listProduct(e.getValue()));
//		add(textFieldFilter, grid);
	}
	
	private void initGrid() {
		grid.setHeight("300px");
		grid.setColumns("id", "a changer", "a changer");
//		grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);
		
		// Connect selected Customer to editor or hide if none is selected
		grid.asSingleSelect().addValueChangeListener(e -> {
			productEditor.editProduct(e.getValue());
		});
	}
	
	private void initButtonAddProduct() {
		// Instantiate and edit new Customer the new button is clicked
		buttonAddProduct.addClickListener(e -> productEditor.editProduct(new Product("", 0.0)));
	}
	
	private void initProductEditor() {
		// Listen changes made by the editor, refresh data from backend
		productEditor.setChangeHandler(() -> {
//			productEditor.setVisible(false);
			listProduct(textFieldFilter.getValue());
		});
	}

	
	void listProduct(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			grid.setItems(productService.findAll());
		}
		else {
			grid.setItems(productService.findByNameStartsWithIgnoreCase(filterText));
		}
	}


    
}
*/
