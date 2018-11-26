package com.expertus.microServiceOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertus.microServiceOrder.bean.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
