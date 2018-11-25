/*
package com.expertus.expertusprojet.vaadin.component;


import org.springframework.beans.factory.annotation.Autowired;

import com.expertus.expertusprojet.bean.Product;
import com.expertus.expertusprojet.service.IProductService;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;


@SpringComponent
@UIScope
public class ProductEditor extends VerticalLayout implements KeyNotifier{


	private static final long serialVersionUID = 7091236681285411827L;
	
	@Autowired
	private IProductService productService;
    private Product product;
 
    TextField textFieldName = new TextField("a changer");
    TextField textFieldPrice = new TextField("a changer");
 
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
 
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);
    Binder<Product> binder = new Binder<>(Product.class);
    private ChangeHandler changeHandler;
    
	@Autowired
	public ProductEditor() {

		add(textFieldName, textFieldPrice, actions);

		// bind using naming convention
		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);

		save.getElement().getThemeList().add("primary");
		delete.getElement().getThemeList().add("error");

		addKeyPressListener(Key.ENTER, e -> save());

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> save());
		delete.addClickListener(e -> delete());
		cancel.addClickListener(e -> editProduct(product));
		setVisible(false);
	}
    
    public void delete() {
    	productService.delete(product);
        changeHandler.onChange();
    }
     
    public void save() {
    	productService.save(product);
        changeHandler.onChange();
    }
    
    
	public void setChangeHandler(ChangeHandler pChangeHandler) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		changeHandler = pChangeHandler;
	}
	
	public final void editProduct(Product pProduct) {
		if (pProduct == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = pProduct.getId() > 0;
		if (persisted) {
			// Find fresh entity for editing
			product = productService.findById(pProduct.getId()).get();
		}
		else {
			product = pProduct;
		}
		cancel.setVisible(persisted);

		// Bind customer properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(product);

		setVisible(true);

		// Focus first name initially
		textFieldName.focus();
	}
	
	public interface ChangeHandler {
		void onChange();
	}
	    
}
*/
