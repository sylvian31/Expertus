package com.expertus.main.vaadin.ui;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.expertus.main.bean.Product;
import com.expertus.main.service.ProductService;
import com.vaadin.ui.VerticalLayout;

public class ProductList extends VerticalLayout implements IProductChangeListener {

	@Autowired
	private ProductService productService;
	private List<Product> products;

    @PostConstruct
    void init() {
        setWidth("80%");

        update();
    }
    
    private void update() {
        setProducts(productService.findAll());
    }
    
    private void setProducts(List<Product> pProducts) {
        this.products = pProducts;
        removeAllComponents();
        products.forEach(todo -> addComponent(new ProductLayout(todo, this)));
    }

     void addProduct(Product pProduct) {
    	 productService.add(pProduct);
        update();
    }

    @Override
    public void productChanged(Product pProduct) {
        addProduct(pProduct);
    }


    public void deleteCompleted(Product pProduct) {
    	productService.delete(pProduct.getId());
        update();
    }

	public void deleteCompleted(int pId) {
    	productService.delete((long) pId);
        update();
	}
    
    

}
