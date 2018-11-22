package com.expertus.expertusprojet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private int prix;
	
	public Product() {
		super();
	}
	
	public Product(int pId, String pNom, int pPrix) {
		super();
		this.id = pId;
		this.nom = pNom;
		this.prix = pPrix;
	}

	public int getId() {
		return id;
	}

	public void setId(int pId) {
		this.id = pId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String pNom) {
		this.nom = pNom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int pPrix) {
		this.prix = pPrix;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}
	
}
