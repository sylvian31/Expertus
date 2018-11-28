package com.expertus.main.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image implements Serializable {

	private Long id;

	private String name;

	private String url;
	
	public Image() {
		
	}

	@Override
	public boolean equals(Object pObject) {
		if (this == pObject)
			return true;
		if (pObject == null || getClass() != pObject.getClass())
			return false;

		Image lImage = (Image) pObject;

		return id != null ? id.equals(lImage.id) : lImage.id == null;

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
