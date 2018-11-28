package com.expertus.main.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

	private Long id;

	private String name;

	private double price;

	private Image image;

	public Product() {

	}
	public Product(String pName) {
		this.name = pName;
	}


	@Override
	public boolean equals(Object pObject) {
		if (this == pObject)
			return true;
		if (pObject == null || getClass() != pObject.getClass())
			return false;

		Product lProduct = (Product) pObject;

		return id != null ? id.equals(lProduct.id) : lProduct.id == null;

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	/* -------------- Getter & Setter -------------- */

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
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


	public Image getImage() {
		return image;
	}

	public void setImage(Image pImage) {
		this.image = pImage;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image.toString() + "]";
	}
	
	
	
}
