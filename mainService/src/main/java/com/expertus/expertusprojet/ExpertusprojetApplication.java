package com.expertus.expertusprojet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.expertus.expertusprojet.repository.ProductRepository;


@SpringBootApplication
@ComponentScan("com.expertus.expertusprojet")
@EnableJpaRepositories("com.expertus.expertusprojet.repository")
public class ExpertusprojetApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExpertusprojetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users 1 -> {}", productRepository.findAll());
	}
	
    @Service
    public static class MyService {
        public String sayHi() {
            return "Hello Spring Initializr!";
        }

    }

}
