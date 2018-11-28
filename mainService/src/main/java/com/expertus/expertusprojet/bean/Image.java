package com.expertus.expertusprojet.bean;

import javax.validation.constraints.NotNull;

public class Image {

	private int id;

	@NotNull
	private String name;
	
	@NotNull
	private String url;
	

	public Image(int pId, @NotNull String pName, @NotNull String pUrl) {
		super();
		this.id = pId;
		this.name = pName;
		this.url = pUrl;
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

	public void setName(String pName) {
		this.name = pName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String pUrl) {
		this.url = pUrl;
	}
	
	
}
