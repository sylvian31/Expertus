package com.expertus.microServiceProduct.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.expertus.microServiceProduct.exception.RestTemplateResponseErrorHandler;

@Configuration
public class RestTemplateConfig {

	
	@Bean				// Create a bean for restTemplate to call services
	@LoadBalanced		// Load balance between service instances running at different ports.
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
		return restTemplate;
	}
}
