package com.expertus.microServiceProduct.bean;

public class ProductWithImages extends Product {

	private Object image;

	public ProductWithImages() {
		super();
	}

	public ProductWithImages(Product pProduct) {
		super(pProduct);
	}

	public ProductWithImages(Product pProduct, Object image) {
		super(pProduct);
		this.image = image;
	}

	/* -------------- Getter & Setter -------------- */

	public Object getImage() {
		return image;
	}

	public void setImage(Object pImage) {
		this.image = pImage;
	}

}
