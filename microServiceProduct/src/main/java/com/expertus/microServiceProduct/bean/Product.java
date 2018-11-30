package com.expertus.microServiceProduct.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {

	/* ------------- Fields ------------- */

	private @Id @GeneratedValue int id;
	private String name;
	private double price;
	private @Transient Object image;

	/* ------------- Constructor ------------- */

	public Product() {
		super();
	}

	public Product(Product pProduct) {
		super();
		this.id = pProduct.getId();
		this.name = pProduct.getName();
		this.price = pProduct.getPrice();
	}

	public Product(String pName, double pPrice, int pIdImage) {
		super();
		this.name = pName;
		this.price = pPrice;
	}

	/* ------------- Getter & Setter ------------- */

	public int getId() {
		return id;
	}

	public void setId(int pId) {
		this.id = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double pPrice) {
		this.price = pPrice;
	}
	
	public Object getImage() {
		return image;
	}

	public void setImage(Object image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
