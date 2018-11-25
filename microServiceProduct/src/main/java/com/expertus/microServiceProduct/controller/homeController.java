package com.expertus.microServiceProduct.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.expertus.microServiceProduct.bean.Product;

@RestController
public class homeController {

	
	@GetMapping(value="")
	public String afficherUnProduit() {
	    return "Welcome to product api";
	}
}
