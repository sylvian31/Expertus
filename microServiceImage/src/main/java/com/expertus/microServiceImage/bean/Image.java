package com.expertus.microServiceImage.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {

	/* ------------- Fields -------------*/ 
	
	private @Id	@GeneratedValue int id;
	private String name;
	private String url;
	private int idProduct;
	
	/* ------------- Constructor -------------*/
	
	public Image() {
		super();
	}

	public Image(String pName, String pUrl, int pIdProduct) {
		super();
		this.name = pName;
		this.url = pUrl;
		this.idProduct = pIdProduct;
	}
	
	/* ------------- Getter & Setter -------------*/

	public int getId() {
		return id;
	}
	
	public void setId(int pId) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String pUrl) {
		this.url = pUrl;
	}
	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
	
	
}
