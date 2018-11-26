package com.expertus.microServiceProduct.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	/* ------------- Fields ------------- */

	private @Id @GeneratedValue int id;
	private String name;
	private double price;
	private int IdImage;

	/* ------------- Constructor ------------- */

	public Product() {
		super();
	}

	public Product(Product pProduct) {
		super();
		this.id = pProduct.getId();
		this.name = pProduct.getName();
		this.price = pProduct.getPrice();
		this.IdImage = pProduct.getIdImage();
	}

	public Product(String pName, double pPrice, int pIdImage) {
		super();
		this.name = pName;
		this.price = pPrice;
		this.IdImage = pIdImage;
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

	public int getIdImage() {
		return IdImage;
	}

	public void setIdImage(int pIdImage) {
		IdImage = pIdImage;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
