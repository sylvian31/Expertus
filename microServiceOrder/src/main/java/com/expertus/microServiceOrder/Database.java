package com.expertus.microServiceOrder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.expertus.microServiceOrder.bean.Order;
import com.expertus.microServiceOrder.bean.Status;
import com.expertus.microServiceOrder.repository.OrderRepository;

@Configuration
public class Database {

	@Bean
	CommandLineRunner initDatabase(OrderRepository orderRepository) {
		orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
		orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
		return null;
	}
}
