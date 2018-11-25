package com.expertus.microServiceImage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertus.microServiceImage.bean.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
