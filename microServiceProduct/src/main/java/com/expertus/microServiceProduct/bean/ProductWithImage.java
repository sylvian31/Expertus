package com.expertus.microServiceProduct.bean;

public class ProductWithImage extends Product {

	private Object image;

	public ProductWithImage() {
		super();
	}

	public ProductWithImage(Product pProduct) {
		super(pProduct);
	}

	public ProductWithImage(Product pProduct, Object image) {
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
