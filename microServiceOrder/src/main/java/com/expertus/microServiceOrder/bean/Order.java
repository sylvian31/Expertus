package com.expertus.microServiceOrder.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.expertus.microServiceOrder.bean.Status;

@Entity
//@Data
@Table(name = "CUSTOMER_ORDER")
public class Order {

	private @Id @GeneratedValue int id;
	private String description;
	private Status status;
	
	/**
	 * Constructor
	 */
	public Order(){
		
	}

	public Order(String pDescription, Status pStatus) {
		this.description = pDescription;
		this.status = pStatus;
	}
	
	public Order(int pId, String pDescription, Status pStatus) {
		this.id = pId;
		this.description = pDescription;
		this.status = pStatus;
	}
	
	/* -------------- Getter & Setter -------------- */

	public int getId() {
		return id;
	}

	public void setId(int pId) {
		this.id = pId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		this.description = pDescription;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status pStatus) {
		this.status = pStatus;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + ", status=" + status + "]";
	}
	
	

}
