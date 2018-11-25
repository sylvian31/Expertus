package com.expertus.microServiceImage.service;

import java.util.List;
import java.util.Optional;

import com.expertus.microServiceImage.bean.Order;

public interface IOrderService {

	public List<Order> findAll();
	
	public Optional<Order> findById(int id);
	
	public void deleteById(int id);

	public Order save(Order image);
}
