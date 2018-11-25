package com.expertus.microServiceProduct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertus.microServiceProduct.repository.ProductRepository;
import com.expertus.microServiceProduct.bean.Product;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;
    
	@Override
	public List<Product> findAll() {
		return (List<Product>) repository.findAll();
	}

	@Override
	public Optional<Product> findById(int pId) {
		return (Optional<Product>) repository.findById(pId);
	}

	@Override
	public List<Product> findByNameStartsWithIgnoreCase(String pName) {
		return repository.findByNameStartsWithIgnoreCase(pName);
	}

	@Override
	public void deleteById(int pId) {
		repository.deleteById(pId);
	}

	@Override
	public Product save(Product pProduct) {
		return repository.save(pProduct);
	}

}
