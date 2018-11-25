package com.expertus.expertusprojet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expertus.expertusprojet.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByNameStartsWithIgnoreCase(String name);
}
