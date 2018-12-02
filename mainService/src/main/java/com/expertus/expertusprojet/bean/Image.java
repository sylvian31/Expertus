package com.expertus.expertusprojet.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image implements Serializable {

	/** The image id */
	private Long id;

	/** The image url */
	private String url;

	/** The id product */
	private Long idProduct;

	/**
	 * Constructor
	 */
	public Image() {

	}

	/* -------------- Getter & Setter -------------- */

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		this.id = pId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String pUrl) {
		this.url = pUrl;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long pIdProduct) {
		this.idProduct = pIdProduct;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", url=" + url + "]";
	}

}
