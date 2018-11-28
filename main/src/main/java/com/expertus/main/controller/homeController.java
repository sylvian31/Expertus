//package com.expertus.main.controller;
//
//import java.util.Collection;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.expertus.main.bean.Product;
//import com.expertus.main.service.IProductService;
//
//@RestController
//public class homeController {
//
//	Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private IProductService productService;
//
//	private @Autowired RestTemplate restTemplate;
//
////	@GetMapping("/")
////	public String accueil(Model model) {
////		logger.info("azerty1");
////
////
////
////		return productService.findById((long) 1).toString();
////
////	}
//
//	@GetMapping("/home")
//	public String home() {
//		return "salut";
//	}
//
//}
