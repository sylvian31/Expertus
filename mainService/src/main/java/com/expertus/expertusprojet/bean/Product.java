package com.expertus.expertusprojet.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

	private Long id;

	@NotNull
	@Size(min = 1)
	private String name;

	@NotNull
	private double price;

	@NotNull
	private Image image;
	
	public Product() {

	}

	public Product(Long pId, @NotNull @Size(min = 1) String pName, @NotNull double pPrice) {
		super();
		this.id = pId;
		this.name = pName;
		this.price = pPrice;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product company = (Product) o;

        if (id != null)
			return id.equals(company.id);
		else
			return company.id == null;

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
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}
	
	

}
