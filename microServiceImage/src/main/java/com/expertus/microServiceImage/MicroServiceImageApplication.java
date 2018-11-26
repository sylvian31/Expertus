package com.expertus.microServiceImage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.expertus.microServiceImage.service.IImageService;

@SpringBootApplication
@ComponentScan("com.expertus.microServiceImage")
@EnableJpaRepositories("com.expertus.microServiceImage.repository")
@EnableEurekaClient
public class MicroServiceImageApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IImageService imageService;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceImageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users 1 -> {}", imageService.findAll());			
	}
}
