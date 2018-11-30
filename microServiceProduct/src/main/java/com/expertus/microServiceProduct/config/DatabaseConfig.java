package com.expertus.microServiceProduct.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.expertus.microServiceProduct.bean.Product;
import com.expertus.microServiceProduct.repository.ProductRepository;

@Configuration
public class DatabaseConfig {
	
	@Bean
	CommandLineRunner initDatabase(ProductRepository productRepository) {
		productRepository.save(new Product("MacBook Pro", 1400.50, 1));
		productRepository.save(new Product("IPhone", 800.00, 2));
		productRepository.save(new Product("Clavier", 37.58, 3));
		productRepository.save(new Product("souris", 10.3, 4));
		return null;
	}

}
