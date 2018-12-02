package com.expertus.expertusprojet.bean;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

	/** The id product */
	private Long id;

	/** The product name */
	@NotNull
	@Size(min = 1)
	private String name;

	/** The product price */
	@NotNull
	private double price;

	/** The list image */
	private List<Image> images;

	/**
	 * The Constructor
	 */
	public Product() {

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

	public List<Image> getImage() {
		return images;
	}

	public void setImage(List<Image> pImage) {
		this.images = pImage;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", images=" + images + "]";
	}

}
