package com.expertus.microServiceOrder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;

import com.expertus.microServiceOrder.bean.Order;

public interface IOrderService {

	public Resources<Resource<Order>> findAll();
	
	public Resource<Order> findById(int id);
	
	public ResponseEntity<Resource<Order>> save(Order image);
	
	public ResponseEntity<ResourceSupport> cancelById(int id);

	public ResponseEntity<ResourceSupport> completeById(int id);


}
