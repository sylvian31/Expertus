package com.expertus.microServiceProduct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.expertus.microServiceProduct.bean.Product;
import com.expertus.microServiceProduct.repository.ProductRepository;

@Configuration
public class Database {

	@Bean
	CommandLineRunner initDatabase(ProductRepository productRepository) {
		productRepository.save(new Product("MacBook Pro", 1400.50, 1));
		productRepository.save(new Product("IPhone", 800.00, 2));
		productRepository.save(new Product("Clavier", 37.58, 3));
		return null;
	}
}
