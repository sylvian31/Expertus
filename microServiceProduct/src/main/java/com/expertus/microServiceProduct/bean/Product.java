package com.expertus.microServiceProduct.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;

	public Product() {
		super();
	}
	
	public Product(String pName, double pPrice) {
		super();
		this.name = pName;
		this.price = pPrice;
	}

	public Product(int pId, String pNom, double pPrice) {
		super();
		this.id = pId;
		this.name = pNom;
		this.price = pPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int pId) {
		this.id = pId;
	}

	public String getName() {
		return name;
	}

	public void setNom(String pName) {
		this.name = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double pPrice) {
		this.price = pPrice;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
