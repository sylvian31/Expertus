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
	
	/* ------------- Constructor -------------*/
	
	public Image() {
		super();
	}

	public Image(String pName, String pUrl) {
		super();
		this.name = pName;
		this.url = pUrl;
	}

	public Image(int pId, String pName, String pUrl) {
		super();
		this.id = pId;
		this.name = pName;
		this.url = pUrl;
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

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
}
